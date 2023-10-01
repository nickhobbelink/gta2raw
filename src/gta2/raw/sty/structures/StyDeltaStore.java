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
public class StyDeltaStore {
    private final int offset;
    private final int length;
    private final byte[] data;
    
    public StyDeltaStore(int offset, int length, byte[] data) {
        super();
        this.offset = offset;
        this.length = length;
        this.data = data;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return length;
    }

    public byte[] getData() {
        return data;
    }

    public static class StyDeltaStoreReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            List<StyDeltaStore> deltaStores = new ArrayList<>();
            long read = 0;
            while(read < chunkSize){
                int offset = input.readUInt16();
                int length = input.readUInt8();
                byte[] data = input.readFully(length);
                read += 3 + length;
                deltaStores.add(new StyDeltaStore(offset, length, data));
            }
            if(read != chunkSize) {
                throw new StyFileCorruptException();
            }
        }
    }
}
