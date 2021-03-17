package shapes;

public class Square extends Rectangle{
    public Square(double side) throws SquareException, RectangleException {
        if (side <= 0) {
            throw new SquareException("Invalid side!");
        }
        this.setHeight(side);
        this.setWidth(side);
    }

    @Override
    public String toString() {
        return String.format("Square {s=" + getWidth() + "} perimeter = " + perimeter()
                + " area = " + calArea((width, height) -> width * height, this.getWidth(), this.getHeight()));
    }
}
