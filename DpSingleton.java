/**
 * class DatabaseConnection {
 * public DatabaseConnection() {
 * System.out.println("New Database Connection Created!");
 * }
 * }
 * 
 * public class Main {
 * public static void main(String[] args) {
 * DatabaseConnection obj1 = new DatabaseConnection();
 * DatabaseConnection obj2 = new DatabaseConnection();
 * DatabaseConnection obj3 = new DatabaseConnection();
 * }
 * }
 * 
 * Imagine like that
 * We create 3 objects → 3 separate memory allocations
 * Different parts of program use different instances.
 * Problem:
 * Data inconsistency
 * Resource waste (multiple DB connections)
 * Hard to control shared state
 */

class Singleton {

    // Step 1: Create static instance
    private static Singleton instance;

    // Step 2: Private constructor
    private Singleton() {
        System.out.println("Singleton Instance Created!");
    }

    // Step 3: Public method to access instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // create only once
        }
        return instance;
    }
}

public class DpSingleton {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        Singleton obj3 = Singleton.getInstance();

        System.out.println(obj1 == obj2); // true - same instance

    }
}
