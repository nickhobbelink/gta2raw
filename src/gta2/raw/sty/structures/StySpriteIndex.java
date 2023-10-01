package gta2.raw.sty.structures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileCorruptException;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StySpriteIndex {
    private final long ptr;
    private final int width;
    private final int height;
    private final int pad;
    
    public long getPtr() {
        return ptr;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPad() {
        return pad;
    }

    public StySpriteIndex(long ptr, int width, int height, int pad) {
        super();
        this.ptr = ptr;
        this.width = width;
        this.height = height;
        this.pad = pad;
    }
    
    public static class StySpriteIndexReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            List<StySpriteIndex> spriteIndexes = new ArrayList<>();
            long read = 0;
            while(read < chunkSize) {
                long ptr = input.readUInt32();
                int width = input.readUInt8();
                int height = input.readUInt8();
                int pad = input.readUInt16();
                spriteIndexes.add(new StySpriteIndex(ptr, width, height, pad));
                read += 8;
            }
            dst.setSpriteIndexes(spriteIndexes);
            if(read != chunkSize) {
                throw new StyFileCorruptException();
            }
        }
    }
}
