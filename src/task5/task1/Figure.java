package task5.task1;

public abstract class Figure {
    int x;
    int y;

    abstract double square();

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Quadrant getQuadrant() {
        if (x > 0 && y > 0) {
            return Quadrant.I;
        } else if (x < 0 && y > 0) {
            return Quadrant.II;
        } else if (x < 0 && y < 0) {
            return Quadrant.III;
        } else if (x > 0 && y < 0) {
            return Quadrant.IV;
        } else if (x == 0 && y == 0) {
            return Quadrant.ORIGIN_OF_COORDINATES;
        } else {
            return (x == 0) ? Quadrant.THE_COORDINATE_IS_ON_THE_X_AXIS : Quadrant.THE_COORDINATE_IS_ON_THE_Y_AXIS;
        }
    }
}
