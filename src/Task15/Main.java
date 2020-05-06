package Task15;

import java.awt.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);
    static String text;
    static Path path = Paths.get(".").normalize().toAbsolutePath();

    public static void main(String[] args) throws IOException {
        System.out.print("\"" + path + "\":");
        while (!(text = in.nextLine()).toLowerCase().trim().equals("quit")) {
            command(text.toLowerCase().trim());
            System.out.print("\"" + path + "\":");
        }
    }

    public static void command(String str) {
        try {
            String[] line = text.split(" ");

            if (line[0].equals("cd")) {
                if (line.length > 1) {
                    if (line[1].equals("..") && !path.equals(path.getRoot())) {
                        path = path.getParent();
                        return;
                    }

                    Path absolute = path.resolve(line[1]).toAbsolutePath().normalize();
                    if (Files.exists(absolute) && Files.isDirectory(absolute)) path = Paths.get(absolute.toString());
                } else {
                    System.out.println("Input path");
                }
            }
            if (line[0].equals("run")) {
                if (line.length > 1) {
                    Path run = path.resolve(line[1]).toAbsolutePath().normalize();

                    if (Files.exists(run) && !Files.isDirectory(run)) {
                        System.out.println("Starting..");
                        Desktop.getDesktop().open(run.toFile());
                    }
                } else {
                    System.out.println("Enter file path");
                }
            }
        } catch (InvalidPathException e) {
            System.out.println("Error in path");
        } catch (IOException e) {
            System.out.println("File cannot be opened");
        }
    }

}
