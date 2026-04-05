// Target interface: Client use this interface to call the method
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Existing class that we want to adapt
class Mp4Player {
    void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

// Adapter class that implements the target interface and uses the existing 
class Adapter implements MediaPlayer {
    private Mp4Player mp4Player; // composition: Adapter has an instance of the existing class

    // Constructor initializes the existing class
    Adapter() {
        mp4Player = new Mp4Player();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp4")) {
            mp4Player.playMp4(fileName);
        }
    }
}

public class AdapterDesign {
    public static void main(String[] args) {
        MediaPlayer player = new Adapter();
        player.play("mp4", "song.mp4");
    }
}
