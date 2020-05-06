package Task16;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> div1 = new ArrayList<>();
            ArrayList<Integer> div2 = new ArrayList<>();

            Scanner in = new Scanner(System.in);
            String text = in.next();

            URI uri = new URI(text);
            URLConnection connection = uri.toURL().openConnection();

            String str = connection.getContentType().split(";")[0];
            System.out.println(str);
            MimeTypes mt = new MimeTypes();
            for (Map.Entry<String, String> node : mt.entrySet()) {
                if (str.equals(node.getValue())) {
                    str = node.getKey();
                    break;
                }
            }

            BufferedInputStream is = new BufferedInputStream(connection.getInputStream());
            Files.copy(is, new File(System.getProperty("user.home") + "/downloaded." + str).toPath());
            System.out.println(str);
            if (str.equals("html")) {
                BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.home") + "/downloaded." + str));
                while ((text = reader.readLine()) != null) {
                    for (int i = 0; i < text.length(); i++) {
                        if (text.charAt(i) == '<') {
                            if (text.charAt(i + 1) != '/') {
                                if (text.substring(i + 1, i + 4).equals("div")) div1.add(1);
                            } else {
                                if (text.substring(i + 2, i + 5).equals("div")) div2.add(1);
                            }
                        }
                    }
                }
                System.out.println(Math.min(div1.size(), div2.size()));
            }
        } catch (URISyntaxException uriex) {
            System.out.println(uriex.getMessage());
        } catch (IOException ioex) {
            System.out.println(ioex.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
