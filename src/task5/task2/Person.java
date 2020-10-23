package task5.task2;

public class Person {
    private Names name;
    private Season favoriteSeason;

    public Person(Names name, Season favoriteSeason) {
        this.name = name;
        this.favoriteSeason = favoriteSeason;
    }

    public Names getName() {
        return name;
    }

    public Season getFavoriteSeason() {
        return favoriteSeason;
    }

    @Override
    public String toString() {
        return "Имя " + name + ", Любимый сезон года " + favoriteSeason + ", Любимая игра " + favoriteSeason.getGame();
    }

    public enum Names {
        Дмитрий(0),
        Алексей(1),
        Юлия(2),
        Анастасия(3),
        Ольга(4),
        Михаил(5),
        Андрей(6),
        Артем(7),
        Николай(8),
        Константин(9);

        public int nameNumber;

        Names(int nameNumber) {
            this.nameNumber = nameNumber;
        }
    }

    public enum Games {
        SNOW_BALLS, SHIP_IN_RIVER, EATING_BARRY, PUDDLE_MEASURE;
    }

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
}
