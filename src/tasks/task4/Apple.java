package tasks.task4;

public class Apple extends Fruit {

    private String[] colorArray = {"Red", "Green", "Yellow"};
    public String color;

    public Apple(String color, int weight) {
        super(weight);
        this.color = color;
    }

    public Apple getRandomApple() {

    }

    @Override
    public String toString() {
        return "Apple: " +
                "color= " + color + ", weight= " + super.weight;
    }
}
