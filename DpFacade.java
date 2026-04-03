/**
 * // Four subsystem classes
class Amplifier {
    public void on()               { System.out.println("Amplifier on"); }
    public void setVolume(int v)   { System.out.println("Volume: " + v); }
    public void setSurroundSound() { System.out.println("Surround sound on"); }
}

class StreamingPlayer {
    public void on()                       { System.out.println("Player on"); }
    public void play(String movie)         { System.out.println("Playing: " + movie); }
    public void setStreamingService(String s) { System.out.println("Service: " + s); }
}

class Projector {
    public void on()              { System.out.println("Projector on"); }
    public void wideScreenMode()  { System.out.println("Widescreen mode"); }
    public void setInput(StreamingPlayer p) { System.out.println("Input set"); }
}

class TheaterLights {
    public void on()        { System.out.println("Lights on"); }
    public void dim(int lvl){ System.out.println("Lights dimmed to " + lvl + "%"); }
}

// Client must know and orchestrate all of it — every time
public class Main {
    public static void main(String[] args) {
        Amplifier amp       = new Amplifier();
        StreamingPlayer player = new StreamingPlayer();
        Projector projector = new Projector();
        TheaterLights lights = new TheaterLights();

        // To watch a movie, client does ALL of this manually:
        lights.on();
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        projector.setInput(player);
        amp.on();
        amp.setSurroundSound();
        amp.setVolume(7);
        player.on();
        player.setStreamingService("Netflix");
        player.play("Inception");
    }
}
 */

// Same four subsystem classes — unchanged
class Amplifier {
    public void on()               { System.out.println("Amplifier on"); }
    public void setVolume(int v)   { System.out.println("Volume: " + v); }
    public void setSurroundSound() { System.out.println("Surround sound on"); }
    public void off()              { System.out.println("Amplifier off"); }
}

class StreamingPlayer {
    public void on()                          { System.out.println("Player on"); }
    public void play(String movie)            { System.out.println("Playing: " + movie); }
    public void setStreamingService(String s) { System.out.println("Service: " + s); }
    public void stop()                        { System.out.println("Player stopped"); }
    public void off()                         { System.out.println("Player off"); }
}

class Projector {
    public void on()                        { System.out.println("Projector on"); }
    public void wideScreenMode()            { System.out.println("Widescreen mode"); }
    public void setInput(StreamingPlayer p) { System.out.println("Input set"); }
    public void off()                       { System.out.println("Projector off"); }
}

class TheaterLights {
    public void on()         { System.out.println("Lights on"); }
    public void dim(int lvl) { System.out.println("Dimmed to " + lvl + "%"); }
    public void off()        { System.out.println("Lights off"); }
}

class Facade{
    private Amplifier amp;
    private StreamingPlayer player;
    private Projector projector;
    private TheaterLights lights;

    public Facade(Amplifier amp, StreamingPlayer player, Projector projector, TheaterLights lights){
        this.amp=amp;
        this.player=player;
        this.projector=projector;
        this.lights=lights;
    }
    public void watchMovie(String movie){
        System.out.println("Get ready to watch movie!");
        lights.on();
        lights.dim(10);
        projector.on();
        projector.wideScreenMode();
        projector.setInput(player);
        amp.on();
        amp.setSurroundSound();
        amp.setVolume(7);
        player.on();
        player.setStreamingService("Netflix");
        player.play(movie);
    }
    public void endMovie(){
        System.out.println("--- Shutting movie theater down ---");
        player.stop();
        player.off();
        amp.off();
        projector.off();
        lights.on();
    }
}


public class DpFacade {
    public static void main(String [] args){
        Amplifier amp          = new Amplifier();
        StreamingPlayer player = new StreamingPlayer();
        Projector projector    = new Projector();
        TheaterLights lights   = new TheaterLights();

        Facade facade = new Facade(amp, player, projector, lights);

        facade.watchMovie("Inception");  // just one call!
        facade.endMovie();
    }
}
