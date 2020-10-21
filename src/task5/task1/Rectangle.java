package task5.task1;

public class Rectangle extends Figure {

    private int width;
    private int height;

    public Rectangle(int x, int y, int width, int height) throws RectangleSizeException {
        super(x, y);
        validateRectangle(width, height);
        this.width = width;
        this.height = height;
    }

    @Override
    double square() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle, square = " + square();
    }

    private void validateRectangle(int width, int height) throws RectangleSizeException {
        if (width > 20 || width < 0 || height > 20 || height < 0) {
            throw new RectangleSizeException("Ширина/Высота вне допустимых значений(0 <= side <= 20)");
        }
    }
}

class RectangleSizeException extends FigureException {

    public RectangleSizeException(String msg) {
        super(msg);
    }
}
