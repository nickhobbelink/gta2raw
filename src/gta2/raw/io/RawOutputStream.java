package gta2.raw.io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * @author Nick Hobbelink
 * Utility class to write integers in little-endian order
 */
public class RawOutputStream extends DataOutputStream {
    private static final Charset UTF8 = Charset.forName("UTF-8");

    public RawOutputStream(OutputStream output) {
        super(output);
    }
    
    /**
     * Writes a 32 bit little-endian integer
     * @throws IOException
     */
    public void writeInt32(int value) throws IOException {
        write(value & 0xFF);
        write(value >> 8 & 0xFF);
        write(value >> 16 & 0xFF);
        write(value >> 24 & 0xFF);
    }
    
    /**
     * Writes a 16 bit little-endian integer
     * @throws IOException
     */
    public void writeInt16(int value) throws IOException {
        write(value & 0xFF);
        write(value >> 8 & 0xFF);
    }
    
    public void writeString(String value) throws IOException {
        write(value.getBytes(UTF8));
    }

}
