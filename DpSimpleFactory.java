/**
class Circle {
    void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle {
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

public class Main {
    public static void main(String[] args) {

        String type = "circle";

        if(type.equals("circle")) {
            Circle c = new Circle();
            c.draw();
        }
        else if(type.equals("rectangle")) {
            Rectangle r = new Rectangle();
            r.draw();
        }
    }
}
 */

// step : 1 >> interface Shape
interface Shape{
    void draw();
}

// step : 2 >> concrete classes
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
}

// step : 3 >> simple factory class
class ShapeFactory {

    public static Shape getShape(String type) {

        if(type.equalsIgnoreCase("circle")) {
            return new Circle();
        }
        else if(type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }

        return null;
    }
}

// client classs
public class DpSimpleFactory {
        public static void main(String[] args) {

        Shape s1 = ShapeFactory.getShape("circle");
        s1.draw();

        Shape s2 = ShapeFactory.getShape("rectangle");
        s2.draw();
    }
}
