package gta2.raw.sty.structures;

import java.io.EOFException;
import java.io.IOException;

import gta2.raw.io.RawReader;
import gta2.raw.io.RawInputStream;

/**
 * @author Nick Hobbelink
 */
public class StyFileChunk {
    private final String chunkType;
    private final long chunkSize;
    
    public StyFileChunk(String chunkType, long chunkSize) {
        this.chunkType = chunkType;
        this.chunkSize = chunkSize;
    }
    
    public String getChunkType() {
        return chunkType;
    }
    
    public long getChunkSize() {
        return chunkSize;
    }
    
    public static class StyFileChunkReader implements RawReader<StyFileChunk>{
        @Override
        public StyFileChunk read(RawInputStream input) throws IOException {
            String chunkType = null;
            try {
                chunkType = input.readChars(4);
            } catch(EOFException e) {
                return null;
            }
            long chunkSize = input.readUInt32();
            return new StyFileChunk(chunkType, chunkSize);
        }
        
    }
}
