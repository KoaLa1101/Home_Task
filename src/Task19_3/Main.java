package Task19_3;

import Task16.MimeTypes;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.nio.file.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            URI uri = new URI(in.nextLine());
            URLConnection connection = uri.toURL().openConnection();
            InputStream inputStream = connection.getInputStream();
            Path html = Paths.get("").toAbsolutePath().normalize().resolve("web.html");
            if (Files.exists(html)) Files.delete(html);
            Files.copy(inputStream, html);

            String str = new String(Files.readAllBytes(html));
            ArrayList<String> result = new ArrayList<>();
            String regex = "(https|http|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            while (matcher.find())
                result.add(matcher.group());

            MimeTypes mimeTypes = new MimeTypes();

            Path save = Paths.get("").toAbsolutePath().normalize().resolve("save");
            if (Files.exists(save))
                Files.walk(save).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
            save.toFile().mkdir();
            int i = 0;
            for (String s : result) {
                uri = new URI(s);
                connection = uri.toURL().openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
                String mime = connection.getContentType();
                if (mime != null) {
                    mime = mime.split(";")[0];
                    for (Map.Entry<String, String> node : mimeTypes.entrySet())
                        if (node.getValue().equals(mime)) {
                            Files.copy(connection.getInputStream(), save.resolve("file" + i + "." + node.getKey()));
                            i++;
                        }
                    Thread.sleep(500);
                }
            }
        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
        System.out.println(e.getMessage());
        }
    }

}
