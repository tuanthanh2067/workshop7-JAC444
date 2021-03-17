package main;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import shapes.CircleException;
import shapes.RectangleException;
import shapes.SquareException;
import shapes.TriangleException;

import shapes.*;

public class Main {
    public static Shape createShapes(String[] tokens) {
        try {
            if (tokens[0].equals("Circle")) {
                if (tokens.length > 2) return null;
                double token1 = Double.parseDouble(tokens[1]);
                return new Circle(token1);
            }
            if (tokens[0].equals("Parallelogram") || tokens[0].equals("Rectangle")) {
                if (tokens.length > 3) return null;
                double token1 = Double.parseDouble(tokens[1]);
                double token2 = Double.parseDouble(tokens[2]);
                if (tokens[0].equals("Parallelogram")) {
                    return new Parallelogram(token1, token2);
                }
                return new Rectangle(token1, token2);

            }
            if (tokens[0].equals("Square")) {
                if (tokens.length > 2) return null;
                double token1 = Double.parseDouble(tokens[1]);
                return new Square(token1);
            }
            if (tokens[0].equals("Triangle")) {
                if (tokens.length > 4) return null;
                double token1 = Double.parseDouble(tokens[1]);
                double token2 = Double.parseDouble(tokens[2]);
                double token3 = Double.parseDouble(tokens[3]);
                return new Triangle(token1, token2, token3);
            }
        } catch (CircleException | RectangleException | SquareException | TriangleException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public static int countLines(String path) {
        int lines = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while (br.readLine() != null) lines++;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    public static int read(String path, Shape[] shapes) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            while ((s = br.readLine()) != null) {
                String[] tokens = s.split(",");
                Shape temp = createShapes(tokens);
                if (temp != null) {
                    count++;
                    shapes[count] = temp;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return count;
    }

    public static double getMinPerimeterForTriangle(Shape[] shapes) {
        double min = 99999;
        for (Shape shape : shapes) {
            if (shape != null) {
                if ((shape instanceof Triangle) && (shape.perimeter() < min)) {
                    min = shape.perimeter();
                }
            }
        }
        return min;
    }

    public static double getMaxPerimeterForCircle(Shape[] shapes) {
        double max = -1;
        for (Shape shape : shapes) {
            if (shape != null) {
                if ((shape instanceof Circle) && (shape.perimeter() > max)) {
                    max = shape.perimeter();
                }
            }
        }
        return max;
    }

    public static void deleteShapes(Shape[] shapes) {
        // min for triangle
        double minPerimeter = getMinPerimeterForTriangle(shapes);
        // max for circle
        double maxPerimeter = getMaxPerimeterForCircle(shapes);

        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] != null) {
                if ((shapes[i] instanceof Triangle && shapes[i].perimeter() == minPerimeter) ||
                        (shapes[i] instanceof Circle && shapes[i].perimeter() == maxPerimeter)) {
                    shapes[i] = null;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("------->JAC 444 Assignment 1<-------");
        System.out.println("------->Task 1 ... <-------");

        String path = "shapes.txt";
        int lines = countLines(path);
        Shape[] shapes = new Shape[lines];
        int shapesTotal = read(path, shapes);

        // display
        System.out.println(shapesTotal + " shapes were created:");
        for (Shape shape : shapes) {
            if (shape != null) {
                System.out.println(shape + "\n");
            }

        }

        System.out.println("------->Task 2 ... <-------");
        deleteShapes(shapes);
        for (Shape shape : shapes) {
            if (shape != null) {
                System.out.println(shape + "\n");
            }
        }

        System.out.println("------->Task 3 ... <-------");
        double parallelogramTotal = 0;
        double triangleTotal = 0;
        for (Shape shape : shapes) {
            if (shape != null) {
                if (shape instanceof Parallelogram) {
                    parallelogramTotal += shape.perimeter();
                } else if (shape instanceof Triangle) {
                    triangleTotal += shape.perimeter();
                }
            }
        }
        System.out.println("Total perimeter of Parallelogram is: " + parallelogramTotal);
        System.out.println("Total perimeter of Triangle is: " + triangleTotal);

    }
}
