package gta2.raw.sty.structures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyConstants;
import gta2.raw.sty.StyFileCorruptException;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StySpritePage {
    private final byte[] raw;
    
    public StySpritePage(byte[] raw) {
        super();
        this.raw = raw;
    }

    public byte[] getRaw() {
        return raw;
    }
    
    public static class StySpritePageReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            List<StySpritePage> spritePages = new ArrayList<>();
            long read = 0;
            while(read < chunkSize) {
                byte[] page = input.readFully(StyConstants.SPRITE_PAGE_SIZE);
                read += StyConstants.SPRITE_PAGE_SIZE;
                spritePages.add(new StySpritePage(page));
            }
            if(read != chunkSize) {
                throw new StyFileCorruptException();
            }
            dst.setSpritePages(spritePages);
        }
    }
}
