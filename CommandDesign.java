// command interface 
interface Command {
    void execute();
}

// Receiver
class Light {
    void turnOn() {
        System.out.println("Light is ON ");
    }

    void turnOff() {
        System.out.println("Light is OFF");
    }
}

// concrete command
class LightOn implements Command {
    private Light light;

    LightOn(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOff implements Command {
    private Light light;

    LightOff(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Invoker(trigger the command)
class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

public class CommandDesign {
    public static void main(String[] args) {

        Light light = new Light();

        Command onCommand = new LightOn(light);
        Command ffCommand = new LightOff(light);
        RemoteControl remote = new RemoteControl();

        remote.setCommand(onCommand);
        remote.pressButton();

        remote.setCommand(ffCommand);
        remote.pressButton();
    }
}
