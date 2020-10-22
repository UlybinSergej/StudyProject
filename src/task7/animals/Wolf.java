package task7.animals;

import task7.enums.Meal;
import task7.enums.Name;
import task7.abstractClasses.WildAnimal;

public class Wolf extends WildAnimal {

    public Wolf(Name name) {
        super(name);
    }

    @Override
    public Meal getFavoriteMeal() {
        return Meal.RABBIT;
    }
}
