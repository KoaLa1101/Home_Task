package Task20;

import Task16.MimeTypes;


import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.net.URI;
import java.net.URLConnection;
import java.util.Map;

public class Download extends Thread {
    private URI uri;
    private URLConnection connection;
    private MimeTypes mt;
    private Path download;
    private InputStream inputStream;
    private int size;

    public Download(String uri) {
        try {
            this.uri = new URI(uri);
            connection = this.uri.toURL().openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            inputStream = connection.getInputStream();
            mt = new MimeTypes();
            size = connection.getContentLength();
        } catch (URISyntaxException | IOException e) {
            System.out.println("failed to get data");
        }
    }

    @Override
    public void run() {
        String mime = connection.getContentType().split(";")[0];
        System.out.println("Start of downloading");
        if (mime == null) {
            return;
        }
        for (Map.Entry<String, String> node : mt.entrySet()) {
            if (node.getValue().equals(mime)) {
                mime = node.getKey();
                break;
            }
        }
        download = Paths.get("").toAbsolutePath().resolve("test." + mime).normalize();
        isExist(download);
        try {
            Files.copy(inputStream, download);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("Could not download file");
        }
    }

    private void isExist(Path path){
        if(Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                System.out.println("Failed to delete file");
            }
        }
    }

    public void partOfDownloading(){
        if(Thread.currentThread().getState().equals(State.TERMINATED)) {
            System.out.println("100%");
            return;
        }
        try {
            System.out.println((Files.size(download) * 1.0f / size) * 100 + "%");
        } catch (IOException e) {
            System.out.println("Failed to get data");
        }

    }
}
