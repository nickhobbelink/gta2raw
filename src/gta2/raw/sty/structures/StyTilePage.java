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
public class StyTilePage {
    private final byte[] raw;

    public StyTilePage(byte[] raw) {
        super();
        this.raw = raw;
    }
    
    public byte[] getRaw() {
        return raw;
    }
    
    public static class StyTilesReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            List<StyTilePage> tiles = new ArrayList<>();
            long read = 0;
            while(read < chunkSize){
                byte[] rawData = new byte[StyConstants.TILE_PAGE_SIZE];
                input.readFully(rawData);
                tiles.add(new StyTilePage(rawData));
                read += StyConstants.TILE_PAGE_SIZE;
            }
            dst.setTilePages(tiles);
            if(read != chunkSize) {
                throw new StyFileCorruptException();
            }
        }
    }
}
