package gta2.raw.sty.structures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileCorruptException;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;
import static gta2.raw.sty.StyConstants.PALETTE_PAGE_SIZE;

/**
 * @author Nick Hobbelink
 */
public class StyPalettePage {
    private final byte[] raw;

    public StyPalettePage(byte[] raw) {
        super();
        this.raw = raw;
    }
    
    public byte[] getRaw() {
        return raw;
    }
    
    public static class StyPhysicalPalettesReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            List<StyPalettePage> palettes = new ArrayList<>();
            long read = 0;
            while(read < chunkSize){
                byte[] rawData = new byte[PALETTE_PAGE_SIZE];
                input.readFully(rawData);
                palettes.add(new StyPalettePage(rawData));
                read += PALETTE_PAGE_SIZE;
            }
            dst.setPalletePages(palettes);
            if(read != chunkSize) {
                throw new StyFileCorruptException();
            }
        }
    }
}
