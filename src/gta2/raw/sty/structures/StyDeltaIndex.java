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
public class StyDeltaIndex {
    private final int whichSprite;
    private final int deltaCount;
    private final int pad;
    private final int[] deltaSize;
    
    public StyDeltaIndex(int whichSprite, int deltaCount, int pad, int[] deltaSize) {
        super();
        this.whichSprite = whichSprite;
        this.deltaCount = deltaCount;
        this.pad = pad;
        this.deltaSize = deltaSize;
    }
    
    public int getWhichSprite() {
        return whichSprite;
    }

    public int getDeltaCount() {
        return deltaCount;
    }

    public int getPad() {
        return pad;
    }

    public int[] getDeltaSize() {
        return deltaSize;
    }
    
    public static class StyDeltaIndexReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            List<StyDeltaIndex> deltaIndexes = new ArrayList<>();
            long read = 0;
            while(read < chunkSize) {
                int whichSprite = input.readUInt16();
                int deltaCount = input.readUInt8();
                int pad = input.readUInt8();
                int[] deltaSize = input.readUInt16Array(deltaCount);
                read += 4 + deltaCount * 2;
                deltaIndexes.add(new StyDeltaIndex(whichSprite, deltaCount, pad, deltaSize));
            }
            dst.setDeltaIndexes(deltaIndexes);
            if(read != chunkSize) {
                throw new StyFileCorruptException();
            }
        }
    }
}
