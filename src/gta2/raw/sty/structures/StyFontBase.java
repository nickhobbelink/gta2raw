package gta2.raw.sty.structures;

import java.io.IOException;
import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileCorruptException;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StyFontBase {
    private final int fontCount;
    private final int[] base;
    
    public StyFontBase(int fontCount, int[] base) {
        super();
        this.fontCount = fontCount;
        this.base = base;
    }
    
    public int getFontCount() {
        return fontCount;
    }
    
    public int[] getBase() {
        return base;
    }
    
    public static class StyFontBaseReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            int fontCount = input.readUInt16();
            if( (fontCount * 2 + 2) != chunkSize) {
                throw new StyFileCorruptException();
            }
            int[] base = input.readUInt16Array(fontCount);
            dst.setFontBase(new StyFontBase(fontCount, base));
        }
    }
}
