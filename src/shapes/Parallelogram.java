package shapes;

public class Parallelogram extends Rectangle{
    public Parallelogram(double width, double height) throws RectangleException {
        super(width, height);
    }

    @Override
    public String toString() {
        return String.format("Parallelogram {w="+ getWidth() + ", h=" + getHeight() + "} perimeter = %.4f", perimeter());
    }
}
