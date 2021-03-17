package shapes;

public class Circle implements Shape{
    private double radius;

    public Circle(double radius) throws CircleException {
        if (radius <= 0) {
            throw new CircleException("Invalid radius!");
        } else {
            this.radius = radius;
        }
    }

    public double getRadius() {return radius;}

    public void setRadius(double radius) throws CircleException{
        if (radius <= 0) {
            throw new CircleException("Invalid radius!");
        } else {
            this.radius = radius;
        }
    }

    @Override
    public double perimeter() {
        return 2 * getRadius() * Math.PI ;
    }


    @Override
    public String toString() {
        return String.format("Circle {r=" + getRadius() +"} perimeter = "
                + perimeter() + " area = " + calArea((radius, sth) -> radius * Math.PI * Math.PI, radius, 1));
    }

    public double calArea(ShapeArea shapeArea, double one, double two) {
        return shapeArea.area(one, two);
    }

}
