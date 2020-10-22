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
}
