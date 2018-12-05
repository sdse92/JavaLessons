package pattern.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteCountinputStream extends FilterInputStream{

    private long readBytes;

    protected ByteCountinputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int res = super.read();
        if (res >= 0) readBytes++;
        return res;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int res = super.read(b, off, len);
        if (res > 0) readBytes +=res;
        return res;
    }
}
