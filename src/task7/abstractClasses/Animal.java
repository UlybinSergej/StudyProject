package task7.abstractClasses;

import task7.enums.Meal;
import task7.enums.Name;

import java.util.Objects;

public abstract class Animal {
    private Name name;

    public Animal(Name name) {
        this.name = name;
    }

    abstract Meal getFavoriteMeal();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return name == animal.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Animal { " + this.getClass().getSimpleName() + " " +
                "name = " + name + ", favorite meal = " + getFavoriteMeal() + " }";
    }
}
