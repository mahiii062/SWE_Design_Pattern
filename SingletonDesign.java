class King {
    private static King instance;

    private King() {
        System.out.println("One KING VK18");
    }

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

        System.out.println(obj1 == obj2);
    }
}
