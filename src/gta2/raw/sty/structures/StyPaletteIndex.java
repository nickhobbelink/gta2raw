package gta2.raw.sty.structures;

import java.io.IOException;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileCorruptException;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StyPaletteIndex {
    private final int[] physPalette;
    
    public StyPaletteIndex(int[] physPalette) {
        super();
        this.physPalette = physPalette;
    }

    public int[] getPhysPalette() {
        return physPalette;
    }
    
    public static class StyPaletteIndexReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            int[] physPalette = input.readUInt16Array(16384);
            
            dst.setPaletteIndex(new StyPaletteIndex(physPalette));
            
            if(physPalette.length * 2 != chunkSize) {
                throw new StyFileCorruptException();
            }
        }
    }
}
