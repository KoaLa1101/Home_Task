package Task17;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Piano extends Thread {
    public static String nameTrack;
    public static HashMap<String, String> keys;


    public Piano() {
        keys = new HashMap<>();
        keys.put("a", "do.mp3");
        keys.put("b", "re.mp3");
        keys.put("c", "mi.mp3");
        keys.put("d", "fa.mp3");
        keys.put("e", "sol.mp3");
        keys.put("f", "lja.mp3");
        keys.put("g", "si.mp3");
    }

    public void Track(String nameTrack){
        this.nameTrack = nameTrack;
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
