package tasks.task4;


public class Pineapple extends Fruit {
    private int[] heightTailArray = new int[16];
    int heightTail;

    {
        for (int i = 0; i < 16; i++) {
            heightTailArray[i] = i + 5;
        }
    }

    public Pineapple(int heightTail, int weight) {
        super(weight);
        this.heightTail = heightTail;
    }

    @Override
    public String toString() {
        return "Pineapple: " +
                "heightTail= " + heightTail + ", weight= " + super.weight;
    }
}
