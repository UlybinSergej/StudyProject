package task6;

import java.util.Objects;

public class Bicycle {
    BicyclesModel modelName;
    int maxSpeed;

    public Bicycle(BicyclesModel modelName, int maxSpeed) throws MaxSpeedException {
        validateMaxSpeed(maxSpeed);
        this.modelName = modelName;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return maxSpeed == bicycle.maxSpeed &&
                Objects.equals(modelName, bicycle.modelName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelName, maxSpeed);
    }

    private void validateMaxSpeed(int maxSpeed) throws MaxSpeedException {
        if (maxSpeed > 50 || maxSpeed < 5) {
            throw new MaxSpeedException("Максимальная скорость вне допустимого диапазона!(5 <= maxSpeed <= 50)");
        }
    }

    public static int getBicycleModelSize() {
        return BicyclesModel.values().length;
    }

    @Override
    public String toString() {
        return "Bicycle{" + "modelName=" + modelName + ", maxSpeed=" + maxSpeed + '}';
    }
}

class MaxSpeedException extends Exception {
    MaxSpeedException(String msg) {
        super(msg);
    }
}

enum BicyclesModel {
    ROAD_BIKE(0),
    MOUNTAIN_BIKE(1),
    CITY_BIKE(2),
    TRIAL_BIKE(3);

    private int bikeNumber;

    BicyclesModel(int bikeNumber) {
        this.bikeNumber = bikeNumber;
    }
}
