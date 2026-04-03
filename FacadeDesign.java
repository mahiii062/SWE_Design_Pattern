// Subsystem classes 
class TV {
    void on() {
        System.out.println("TV ON");
    }
}

class DVDPlayer {
    void on() {
        System.out.println("DVD Player ON");
    }

    void play() {
        System.out.println("Movie Playing");
    }
}

class SoundSystem {
    void on() {
        System.out.println("Sound System ON");
    }
}

// Facade class
class HomeTheater {
    private TV tv;
    private DVDPlayer dvd;
    private SoundSystem sound;

    public HomeTheater() {
        tv = new TV();
        dvd = new DVDPlayer();
        sound = new SoundSystem();
    }

    void watchMovie() {
        tv.on();
        sound.on();
        dvd.on();
        dvd.play();
    }

}

public class FacadeDesign {
    public static void main(String[] args) {
        HomeTheater homeTheater = new HomeTheater();
        homeTheater.watchMovie();
    }
}
