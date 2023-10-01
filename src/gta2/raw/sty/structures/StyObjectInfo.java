package gta2.raw.sty.structures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StyObjectInfo {
    private final int model;
    private final int sprites;
    
    public StyObjectInfo(int model, int sprites) {
        super();
        this.model = model;
        this.sprites = sprites;
    }
    
    public int getModel() {
        return model;
    }
    
    public int getSprites() {
        return sprites;
    }

    public static class StyObjectInfoReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            List<StyObjectInfo> objectInfo = new ArrayList<>();
            long read = 0;
            while(read < chunkSize) {
                int model = input.readUInt8();
                int sprites = input.readUInt8();
                objectInfo.add(new StyObjectInfo(model, sprites));
                read += 2;
            }
        }
    }
}
