package gta2.raw.io.structures;

/**
 * @author Nick Hobbelink
 * Packages width, height and ARGB data together
 *
 */
public class ArgbImage {
    private int w;
    private int h;
    private int[] raw;

    public ArgbImage(int w, int h, int[] raw) {
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
    
    public int[] getRaw() {
        return raw;
    }
}
