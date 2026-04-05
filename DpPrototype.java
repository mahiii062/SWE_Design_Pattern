/**
 * class Car {
 * String model;
 * String color;
 * 
 * Car(String model, String color) {
 * this.model = model;
 * this.color = color;
 * }
 * }
 * 
 * public class Main {
 * public static void main(String[] args) {
 * Car car1 = new Car("Tesla Model 3", "Red");
 * 
 * // Manually copying
 * Car car2 = new Car(car1.model, car1.color);
 * 
 * System.out.println(car1.model + " - " + car1.color);
 * System.out.println(car2.model + " - " + car2.color);
 * }
 * }
 * 
 * Problems without prototype:
 * Manual copying is tedious.
 * If Car has many properties, copying becomes error-prone.
 * We have to know the constructor details every time.
 */

// Step : 1 >> prototype interface
interface Prototype {
    Prototype clone(); // method to clone the object
}

// Step : 2 >> concrete class implementing prototype
class Car implements Prototype {

    String model;
    String color;

    Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    @Override
    public Prototype clone() {
        return new Car(this.model, this.color); // creating a new Car with same properties
    }

    void showDetails() {
        System.out.println("Model : " + model + ", Color : " + color);
    }
}

public class DpPrototype {
    public static void main(String[] args) {
        Car obj1 = new Car("Tesla model 1", "Blue");
        Car obj2 = (Car) obj1.clone(); // (Car) means we are casting the Prototype type back to Car
        obj2.color = "Light Green";

        obj1.showDetails();
        obj2.showDetails();
    }
}
