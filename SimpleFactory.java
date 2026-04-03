interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving Car");
    }
}

class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding Bike ");
    }
}

/**
 * Factory class
 */
class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("bike")) {
            return new Car();
        } else {
            return null;
        }
    }
}

public class SimpleFactory {
    public static void main(String[] args) {
        Vehicle v = VehicleFactory.createVehicle("car");
        v.drive();
    }
}