package task6;

public enum BicyclesModel {
    ROAD_BIKE(0),
    MOUNTAIN_BIKE(1),
    CITY_BIKE(2),
    TRIAL_BIKE(3);

    private int bikeNumber;

    BicyclesModel(int bikeNumber) {
        this.bikeNumber = bikeNumber;
    }
}
