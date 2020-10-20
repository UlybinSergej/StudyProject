package tasks.task4;

public class Orange extends Fruit{
    private int[] deepSkinArray = new int[21];
    int deepSkin;

    {
        for (int i = 0; i < 21; i++) {
            deepSkinArray[i] = i;
        }
    }

    public Orange(int deepSkin, int weight) {
        super(weight);
        this.deepSkin = deepSkin;
    }

    @Override
    public String toString() {
        return "Orange: " +
                "deepSkin= " + deepSkin + ", weight= " + super.weight;
    }
}
