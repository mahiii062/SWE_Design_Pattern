// prototype interface 
interface Prototype {
    Prototype clone();
}

// concrete class
class Robot implements Prototype {
    String name;
    int powerLevel;

    Robot(String name, int powerlevel) {
        this.name = name;
        this.powerLevel = powerlevel;
    }

    // clone method
    public Prototype clone() {
        return new Robot(this.name, this.powerLevel);
    }

    void show() {
        System.out.println("Robot: " + name + ", Power: " + powerLevel);
    }
}

public class PrototypeDesign {
    public static void main(String[] args) {
        Robot og = new Robot("MegaBot", 100);
        og.show();

        // clone instead of using new keyword again
        Robot copy = (Robot) og.clone();
        copy.show();
    }
}
