package gta2.raw.io.structures;

/**
 * @author Nick Hobbelink
 * Packages width, height and RGBA data together
 *
 */
public class RgbaImage {
    private int w;
    private int h;
    private byte[] raw;
    
    public RgbaImage(int w, int h, byte[] raw) {
        super();
        this.w = w;
        this.h = h;
        this.raw = raw;
    }

    public int getW() {
        return w;
    }
    
    public int getH() {
        return h;
    }
    
    public byte[] getRaw() {
        return raw;
    }
}
