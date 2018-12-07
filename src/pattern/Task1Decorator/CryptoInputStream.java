package pattern.Task1Decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CryptoInputStream extends FilterInputStream {

    private String password;
    protected CryptoInputStream(InputStream in, String password) {
        super(in);
        this.password = password;
    }

    @Override
    public int read() throws IOException {
        int data = super.read();
        int newByte = 0;
        byte bytes;
        int key = password.length();
        for(int i = 0; i < 1; i++){
            bytes =(byte) (data ^ (key + 2));
            newByte = (int)bytes;
        }
        return newByte;
    }

    @Override
    public int available() throws IOException {
        return super.available();
    }
}
