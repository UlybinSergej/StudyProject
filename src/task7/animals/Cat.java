package task7.animals;

import task7.enums.Meal;
import task7.enums.Name;
import task7.abstractClasses.PetAnimal;

public class Cat extends PetAnimal {

    public Cat(Name name) {
        super(name);
    }

    @Override
    public Meal getFavoriteMeal() {
        return Meal.FISH;
    }
}
