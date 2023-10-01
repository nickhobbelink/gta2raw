package gta2.raw.sty.structures;

/**
 * @author Nick Hobbelink
 */
public class StyDoorInfo {
    private final int rx;
    private final int ry;
    
    public StyDoorInfo(int rx, int ry) {
        super();
        this.rx = rx;
        this.ry = ry;
    }
    
    public int getRx() {
        return rx;
    }
    
    public int getRy() {
        return ry;
    }
}
