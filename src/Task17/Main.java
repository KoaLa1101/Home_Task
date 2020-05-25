package Task17;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            String txt = in.nextLine();
            BufferedWriter bw = new BufferedWriter(new FileWriter(Paths.get("").resolve("play.txt").toString()));
            BufferedReader br = new BufferedReader(new FileReader(Paths.get("").resolve("play.txt").toString()));
            bw.write(txt);
            bw.flush();
            String read = br.readLine();
            for (char c : read.toCharArray()) {
                if (Keys.containsKey(c+"")){
                    new Piano(Keys.get(String.valueOf(c+""))).start();
                }
                Thread.sleep(400);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
