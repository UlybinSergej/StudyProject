package task7.animals;

import task7.enums.Meal;
import task7.enums.Name;
import task7.abstractClasses.WildAnimal;

public class Fox extends WildAnimal {
    public Fox(Name name) {
        super(name);
    }

    @Override
    public Meal getFavoriteMeal() {
        return Meal.MOUSE;
    }
}
