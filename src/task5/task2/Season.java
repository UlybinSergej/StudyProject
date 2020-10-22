package task5.task2;

public enum Season {
    WINTER(Games.SNOW_BALLS, 0),
    SPRING(Games.SHIP_IN_RIVER, 1),
    SUMMER(Games.EATING_BARRY, 2),
    AUTUMN(Games.PUDDLE_MEASURE, 3);

    private Games game;
    private int seasonNumber;

    Season(Games game, int seasonNumber) {
        this.game = game;
        this.seasonNumber = seasonNumber;
    }

    public Games getGame() {
        return game;
    }
}
