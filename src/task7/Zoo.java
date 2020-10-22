package task7;

import task7.abstractClasses.Animal;
import task7.abstractClasses.PetAnimal;
import task7.abstractClasses.WildAnimal;
import task7.animals.*;
import task7.enums.Name;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Zoo {
    private Set<PetAnimal> petAnimals = new HashSet<>();
    private Set<WildAnimal> wildAnimals = new HashSet<>();

    public Zoo() {
        fillCollectionWithPetAnimals(petAnimals);
        fillCollectionWithWildAnimals(wildAnimals);
    }

    private void fillCollectionWithPetAnimals(Set<PetAnimal> petAnimals) {
        Random random = new Random();
        int choosePets = random.nextInt(2);
        int emptySizeSet = random.nextInt(5) + 1;
        System.out.println("PetSet size - " + emptySizeSet);
        do {
            PetAnimal pet;
            if (choosePets == 0) {
                pet = new Dog(Name.values()[random.nextInt(6)]);
            } else {
                pet = new Cat(Name.values()[random.nextInt(6)]);
            }
            if (petAnimals.add(pet)) {
                emptySizeSet--;
            }
        } while (emptySizeSet > 0);
    }

    private void fillCollectionWithWildAnimals(Set<WildAnimal> wildAnimals) {
        Random random = new Random();
        int chooseWildAnimal = random.nextInt(2);
        int emptySizeSet = random.nextInt(8) + 3;
        System.out.println("WildAnimalSet size - " + emptySizeSet);
        do {
            WildAnimal wildAnimal;
            if (chooseWildAnimal == 0) {
                wildAnimal = new Wolf(Name.values()[random.nextInt(Name.getQuantityNames())]);
            } else {
                wildAnimal = new Fox(Name.values()[random.nextInt(Name.getQuantityNames())]);
            }
            if (wildAnimals.add(wildAnimal)) {
                emptySizeSet--;
            }
        } while (emptySizeSet > 0);
    }

    private void printAnimalsFromCollection(Set<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    public void printAllAnimals() {
        printAnimalsFromCollection(petAnimals);
        printAnimalsFromCollection(wildAnimals);
    }
}
