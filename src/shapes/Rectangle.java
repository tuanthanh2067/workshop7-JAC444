package shapes;

public class Rectangle implements Shape{
    private double width;
    private double height;

    public Rectangle() {
        width = 0;
        height = 0;
    }

    public Rectangle(double width, double height) throws RectangleException {
        if (width <= 0 || height <= 0) {
            throw new RectangleException("Invalid side(s)!");
        } else {
            this.width = width;
            this.height = height;
        }
    }

    public double getWidth() {return width;}
    public double getHeight() {return height;}

    public void setWidth(double width) throws RectangleException {
        if (width <= 0) {
            throw new RectangleException("Invalid side(s)!");
        }
        this.width = width;
    }

    public void setHeight(double height) throws RectangleException {
        if (height <= 0) {
            throw new RectangleException("Invalid side(s)!");
        }
        this.height = height;
    }

    @Override
    public double perimeter() {
        return 2 * getWidth() +  2 * getHeight();
    }

    @Override
    public String toString() {
        return String.format("Rectangle {w="+ getWidth() + ", h="
                + getHeight() + "} perimeter = " + perimeter()
                + " area = " + calArea((width, height) -> width * height, this.getWidth(), this.getHeight()));
    }

    public double calArea(ShapeArea shapeArea, double one, double two) {
        return shapeArea.area(one, two);
    }

}
