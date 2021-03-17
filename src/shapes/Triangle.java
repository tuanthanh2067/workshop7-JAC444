package shapes;

public class Triangle implements Shape{
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || b <= 0 || c <= 0 ||
                (a + b < c) ||
                (b + c < a) ||
                (c + a < b)) {
            throw new TriangleException("Invalid side(s)!");
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {return a;}
    public double getB() {return b;}
    public double getC() {return c;}

    public void setA(double a) throws TriangleException {
        if (a <= 0) {
            throw new TriangleException("Invalid side(s)!");
        }
        this.a = a;
    }
    public void setB(double b) throws TriangleException {
        if (b <= 0) {
            throw new TriangleException("Invalid side(s)!");
        }
        this.b = b;
    }
    public void setC(double c) throws TriangleException {
        if (c <= 0) {
            throw new TriangleException("Invalid side(s)!");
        }
        this.c = c;
    }

    @Override
    public double perimeter() {
        return getA() + getB() + getC();
    }

    @Override
    public String toString() {
        return String.format("Triangle {s1=" + getA() + ", s2=" + getB() + ", s3=" + getC() + "} perimeter = %.4f", perimeter());
    }
}
