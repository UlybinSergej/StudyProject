package task5.task1;

public class Circle extends Figure {
    private double radius;
    private final static int MAX_SIZE = 10;

    public Circle(int x, int y, double radius) throws RadiusException {
        super(x, y);
        validateRadius(radius);
        this.radius = radius;
    }

    @Override
    double square() {
        return (Math.pow(radius, 2) * Math.PI);
    }

    @Override
    public String toString() {
        return "Circle, square =" + square();
    }

    private void validateRadius(double radius) throws RadiusException {
        if (radius > MAX_SIZE || radius < 0) {
            throw new RadiusException("Радиус вне допустимых значений(0 <= radius <= " + MAX_SIZE + ")");
        }
    }
}

class RadiusException extends FigureException {
    public RadiusException(String msg) {
        super(msg);
    }
}
