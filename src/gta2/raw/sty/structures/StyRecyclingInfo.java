package gta2.raw.sty.structures;

import java.io.IOException;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StyRecyclingInfo {
    private final int[] info;
    
    public StyRecyclingInfo(int[] info) {
        super();
        this.info = info;
    }

    public int[] getInfo() {
        return info;
    }
    
    public static class StyRecyclingInfoReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            int[] info = input.readUInt8Array( (int) chunkSize);
            dst.setRecyclingInfo(new StyRecyclingInfo(info));
        }
    }
}
