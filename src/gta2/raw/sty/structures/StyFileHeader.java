package gta2.raw.sty.structures;

import java.io.IOException;

import gta2.raw.io.RawReader;
import gta2.raw.io.RawInputStream;

/**
 * @author Nick Hobbelink
 */
public class StyFileHeader {
    private final String fileType;
    private final int versionCode;
    
    public StyFileHeader(String fileType, int versionCode) {
        super();
        this.fileType = fileType;
        this.versionCode = versionCode;
    }

    public String getFileType() {
        return fileType;
    }
    
    public int getVersionCode() {
        return versionCode;
    }

    public static class StyFileHeaderReader implements RawReader<StyFileHeader>{
        @Override
        public StyFileHeader read(RawInputStream input) throws IOException {
            String fileType = input.readChars(4);
            int versionCode = input.readUInt16();
            return new StyFileHeader(fileType, versionCode);
        }
    }
    
}
