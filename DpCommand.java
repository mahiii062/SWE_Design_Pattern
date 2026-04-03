/**
// Receiver
class Light {
        public void turnOn() { System.out.println("Light is ON"); }
        public void turnOff() { System.out.println("Light is OFF"); }
}

// Invoker — tightly coupled to Light
class RemoteControl {
        private Light light;

        public RemoteControl(Light light) {
            this.light = light;
        }
        // To add new behavior, you must edit this class
        public void pressOnButton() { light.turnOn(); }
        public void pressOffButton() { light.turnOff(); }
}

// Client
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        RemoteControl remote = new RemoteControl(light);
        remote.pressOnButton();
        remote.pressOffButton();
    }
}
 */

// Step : 1 >> Interface command
interface Command {
    void execute();

    void undo();

}

// Step : 2 >> Receiver :: Knows how to do the actual work
class Light {
    public void turnOn() {
        System.out.println("Light is ON!");
    }

    public void turnOff() {
        System.out.println("Light is OFF!");
    }
}

// Step : 3 >> Concrete commands >> each command wraps receiver action
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// Step : 4 >> Invoker >> Who knows nothing about light, only holds command
class RemoteControl {
    private Command cmd;

    public void setCommand(Command cmd) {
        this.cmd = cmd;
    }

    public void pressButton() {
        cmd.execute();
    }

    public void pressUndo() {
        cmd.undo();
    }
}

public class DpCommand {

    public static void main(String[] args) {
        Light light = new Light();

        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton(); // Light is ON
        remote.pressUndo(); // Light is OFF (undo!)

        remote.setCommand(lightOff);
        remote.pressButton(); // Light is OFF
        remote.pressUndo(); // Light is ON (undo!)
    }

}