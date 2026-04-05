class King {
    // Static variable to hold the single instance of the class
    private static King instance;

    // Private constructor to prevent instantiation from outside the class
    private King() {
        System.out.println("One KING VK18");
    }

    // Public method to provide access to the instance
    public static King getInstance() {
        if (instance == null) {
            instance = new King();
        }
        return instance;
    }
}

public class SingletonDesign {
    public static void main(String[] args) {
        King obj1 = King.getInstance();
        King obj2 = King.getInstance();
        King obj3 = King.getInstance();

        System.out.println(obj1 == obj2);
    }
}
