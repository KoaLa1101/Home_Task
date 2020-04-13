package ReadsIniFile;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ReadIni extends Reader {
    private BufferedReader br;

    public ReadIni(Reader br){
        this.br = new BufferedReader(br);
    }

    public Map<String, String> readini() throws IOException {       //I'm so sorry, bot I haven't a fantasy to create the name for method...
        String text;
        Map<String, String> iniFiles = new HashMap<>();
        while((text = readLine())!=null){
            String first, second;
            first = text.split("=")[0];
            second = text.split("=")[1];
            iniFiles.put(first, second);
        }
        return iniFiles;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    public String readLine() throws IOException {
        return br.readLine();
    }

    @Override
    public long skip(long n) throws IOException {
        return br.skip(n);
    }

    @Override
    public boolean ready() throws IOException {
        return br.ready();
    }

    @Override
    public boolean markSupported() {
        return br.markSupported();
    }

    @Override
    public void mark(int readAheadLimit) throws IOException {
        br.mark(readAheadLimit);
    }

    @Override
    public void reset() throws IOException {
        br.reset();
    }

    @Override
    public void close() throws IOException {
    }

    public Stream<String> lines() {
        return br.lines();
    }

    @Override
    public int read(CharBuffer target) throws IOException {
        return br.read(target);
    }

    @Override
    public int read(char[] cbuf) throws IOException {
        return br.read(cbuf);
    }

    @Override
    public int read() throws IOException {
        return br.read();
    }
}
