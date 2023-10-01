package gta2.raw.io;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Nick Hobbelink
 * Utility class to read integers in little-endian order
 */
public class RawInputStream extends DataInputStream{
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final long LBYTE = 0xFF;
    private static final int BYTE = 0xFF;

    public RawInputStream(InputStream input) {
        super(input);
    }

    public String readChars(int length) throws IOException {
        byte[] buffer = new byte[length];
        readFully(buffer);
        return new String(buffer, UTF8);
    }

    /**
     * Reads an unsigned 8 bit integer
     * @throws IOException
     */
    public int readUInt8() throws IOException {
        return readByte() & 0xFF;
    }

    /**
     * Reads an unsigned 16 bits little-endian integer
     * @throws IOException
     */
    public int readUInt16() throws IOException {
        byte[] b = new byte[2];
        readFully(b);
        return b[0] & 0xFF | ((b[1] & 0xFF)<<8);
    }
    
    /**
     * Reads an unsigned 32 bits little-endian integer
     * @throws IOException
     */
    public long readUInt32() throws IOException {
        byte[] b = new byte[4];
        readFully(b);
        return   (long)b[0] & LBYTE | 
               (((long)b[1] & LBYTE) << 8) |
               (((long)b[2] & LBYTE) << 16) |
               (((long)b[3] & LBYTE) << 24);
    }
    
    /**
     * Reads a signed 32 bits little-endian integer
     * @throws IOException
     */
    public int readInt32() throws IOException {
        byte[] b = new byte[4];
        readFully(b);
        return   (int)b[0] & BYTE | 
               (((int)b[1] & BYTE) << 8) |
               (((int)b[2] & BYTE) << 16) |
               (((int)b[3] & BYTE) << 24);
    }

    /**
     * Reads an array of unsigned 16 bits little-endian integers
     * @throws IOException
     */
    public int[] readUInt16Array(int count) throws IOException {
        int[] result = new int[count];
        for(int i = 0; i < count; ++i) {
            result[i] = readUInt16();
        }
        return result;
    }

    /**
     * Reads the given number of bytes into a byte array
     * @param length number of bytes to read
     * @throws IOException
     */
    public byte[] readFully(int length) throws IOException {
        byte[] buffer = new byte[length];
        readFully(buffer);
        return buffer;
    }
    
    /**
     * Reads an array of unsigned 8 bit integers
     * @throws IOException
     */
    public int[] readUInt8Array(int count) throws IOException {
        int[] result = new int[count];
        for(int i = 0; i < count; ++i) {
            result[i] = readUInt8();
        }
        return result;
    }
    
    /**
     * Reads a zero-terminated array of unsigned 16 bits little-endian integers
     * @throws IOException
     */
    public List<Integer> readZtUInt16List() throws IOException {
        List<Integer> values = new ArrayList<>();
        int value = 0;
        do {
            value = readUInt16();
            if(value > 0) {
                values.add(value);
            }
        } while(value > 0);
        return values;
    }

}
