package gta2.raw.audio;

import java.io.EOFException;
import java.io.IOException;

import gta2.raw.io.RawInputStream;
import gta2.raw.io.RawReader;

/**
 * @author Nick Hobbelink
 * Represents a sound entry in a GTA2 SDT file
 */
public class SdtEntry {
    private int offset;
    private int size;
    private int samplesPerSec;
    private int unknown;
    private int start;
    private int end;
    
    public int getOffset() {
        return offset;
    }

    public int getSize() {
        return size;
    }

    public int getSamplesPerSec() {
        return samplesPerSec;
    }

    public int getUnknown() {
        return unknown;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public static class SdtEntryReader implements RawReader<SdtEntry>{
        @Override
        public SdtEntry read(RawInputStream input) throws IOException {
            SdtEntry entry = new SdtEntry();
            try {
                entry.offset = input.readInt32();
            } catch(EOFException e) {
                return null;
            }
            entry.size = input.readInt32();
            entry.samplesPerSec = input.readInt32();
            entry.unknown = input.readInt32();
            entry.start = input.readInt32();
            entry.end = input.readInt32();
            return entry;
        }
        
    }
}
