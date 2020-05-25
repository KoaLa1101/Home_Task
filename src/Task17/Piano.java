package Task17;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Piano extends Thread {
    public static String nameTrack;

    public Piano(String track) {
        nameTrack = track;
    }



    public void run() {
        try {
            FileInputStream is = new FileInputStream(Paths.get("").toAbsolutePath().resolve("notes").resolve(nameTrack).toString());
            Player player = new Player(is);
            player.play();
            player.close();
        } catch (IOException | JavaLayerException e) {
            System.out.println(e.getMessage());
        }
    }


}
