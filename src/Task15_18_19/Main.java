package Task15_18_19;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

            if (line[0].equals("clear")) {
                // it should be supplemented
            }

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
            if (line[0].equals("open")) {
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

            if (line[0].equals("delete")) {
                if (line.length > 1) {
                    Path toBeDeleted = path.resolve(line[1]).toAbsolutePath().normalize();

                    if (Files.exists(toBeDeleted)) {
                        System.out.println("Removal process..");
                        Files.delete(toBeDeleted);
                    }
                } else {
                    System.out.println("Enter file path");
                }
            }

            if (line[0].equals("copy")) {
                if (line.length > 1) {
                    ArrayList<String> fromTo = new ArrayList<>();
                    String param = line[1].trim().toLowerCase();

                    if (param.contains("\"")) {
                        Pattern pattern = Pattern.compile("\"([a-zA-Z\\s0-9/\\\\.]+)\"");
                        Matcher matcher = pattern.matcher(param);

                        while (matcher.find()) {
                            String add = matcher.group();
                            add = add.substring(add.indexOf("\"") + 1, add.lastIndexOf("\""));
                            fromTo.add(add);
                            System.out.println(add);
                        }
                    } else fromTo.addAll(Arrays.asList(line[1].trim().split(" ", 2)));

                }

                if (line[0].equals("cat")) {
                    if (line.length > 1) {
                        String[] encoding = line[1].split(" ", 2);
                        Path read;

                        BufferedReader reader = null;
                        String param, encodingParam;

                        if (encoding.length > 1) {
                            param = encoding[0].trim().toLowerCase();
                            encodingParam = encoding[1].trim().toLowerCase();

                            read = path.resolve(param).toAbsolutePath().normalize();
                            if (Files.exists(read))
                                reader = Files.newBufferedReader(read, Charset.forName(encodingParam));
                        } else {
                            param = encoding[0].trim().toLowerCase();
                            read = path.resolve(param).toAbsolutePath().normalize();
                            if (Files.exists(read)) reader = Files.newBufferedReader(read);
                        }

                        if (reader != null) {
                            while ((param = reader.readLine()) != null) {
                                System.out.println(param);
                            }
                            reader.close();
                        } else {
                            System.out.println("Error in path");
                        }
                    }
                } else {
                    System.out.println("Unknown command");
                }
            }
        } catch (InvalidPathException e) {
            System.out.println("Error in path");
        } catch (IOException e) {
            System.out.println("File cannot be opened");
        }

    }
}
