package ReadsIniFile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadIni in = new ReadIni(new FileReader("C:\\gg.ini"));
        Map map = in.readini();
        System.out.println(map);
    }
}
