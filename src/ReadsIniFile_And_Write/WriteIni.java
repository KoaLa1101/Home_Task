package ReadsIniFile_And_Write;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class WriteIni extends Writer {
    private BufferedWriter writer;

    public WriteIni(Writer writer){
        this.writer = new BufferedWriter(writer);
    }

    public void writeini(Map<String, String> map) throws IOException { // I know, that this is wrong, but I haven't fantasy
        for(Map.Entry<String, String> map1 : map.entrySet()){
            write(map1.getKey());
            write("=");
            write(map1.getValue());
        }
    }

    protected WriteIni() {
        super();
    }

    protected WriteIni(Object lock) {
        super(lock);
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        super.write(cbuf);
    }

    @Override
    public void write(String str) throws IOException {
        super.write(str);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
    }

    @Override
    public Writer append(CharSequence csq) throws IOException {
        return super.append(csq);
    }

    @Override
    public Writer append(CharSequence csq, int start, int end) throws IOException {
        return super.append(csq, start, end);
    }

    @Override
    public Writer append(char c) throws IOException {
        return super.append(c);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

    }

    @Override
    public void flush() throws IOException {

    }

    @Override
    public void close() throws IOException {

    }
}
