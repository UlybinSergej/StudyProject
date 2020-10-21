package task5.task1;

public class FigureMain {
    public static void main(String[] args) throws FigureException {

        try {
            Figure f1 = new Circle(4, 8, 9);
            System.out.println(f1.toString());
            Figure f2 = new Rectangle(1, 6, 15, 5);
            System.out.println(f2.toString());
            Figure f3 = new Circle(1, 1, 7);
            System.out.println(f3.toString());
            Figure f4 = new Circle(0, 0, 18);
            System.out.println(f4.toString());
            Figure f5 = new Rectangle(15, 45, 50, 84);
            System.out.println(f5.toString());
        } catch (FigureException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
