package task5.task1;

public class Circle extends Figure {

    private double radius;

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
        if (radius > 10 || radius < 0) {
            throw new RadiusException("Радиус вне допустимых значений(0 <= radius <= 10)");
        }
    }
}

class RadiusException extends FigureException {

    public RadiusException(String msg) {
        super(msg);
    }
}
