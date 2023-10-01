package gta2.raw.sty;

import java.io.IOException;

import gta2.raw.io.RawInputStream;

/**
 * @author Nick Hobbelink
 * Reader abstraction for various types of sty data formats
 */
public interface StyReader {
    public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException;
}
