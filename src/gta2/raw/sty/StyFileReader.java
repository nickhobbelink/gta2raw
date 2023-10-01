package gta2.raw.sty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.structures.StyFileChunk;
import gta2.raw.sty.structures.StyFileHeader;
import gta2.raw.sty.structures.StyDeltaIndex.StyDeltaIndexReader;
import gta2.raw.sty.structures.StyDeltaStore.StyDeltaStoreReader;
import gta2.raw.sty.structures.StyFileChunk.StyFileChunkReader;
import gta2.raw.sty.structures.StyFileHeader.StyFileHeaderReader;
import gta2.raw.sty.structures.StyFontBase.StyFontBaseReader;
import gta2.raw.sty.structures.StyPalettePage.StyPhysicalPalettesReader;
import gta2.raw.sty.structures.StySpriteBase.StySpriteBaseReader;
import gta2.raw.sty.structures.StyPaletteIndex.StyPaletteIndexReader;
import gta2.raw.sty.structures.StyObjectInfo.StyObjectInfoReader;
import gta2.raw.sty.structures.StyRecyclingInfo.StyRecyclingInfoReader;
import gta2.raw.sty.structures.StySpritePage.StySpritePageReader;
import gta2.raw.sty.structures.StySpriteIndex.StySpriteIndexReader;
import gta2.raw.sty.structures.StyPaletteBase.StyPaletteBaseReader;
import gta2.raw.sty.structures.StyCarInfo.StyCarInfoReader;
import gta2.raw.sty.structures.StyTilePage.StyTilesReader;
import gta2.raw.sty.structures.StySpecs.StySpecsReader;

/**
 * @author Nick Hobbelink
 * Reads GTA2 sty files into a StyFileStructure container
 */
public class StyFileReader {
    private static final String FILE_HEADER = "GBST";
    private final File styFile;
    private final StyFileHeaderReader headerReader;
    private final StyFileChunkReader chunkReader;
    private final Map<String, StyReader> readers; 

    public StyFileReader(File styFile) {
        this.styFile = styFile;
        headerReader = new StyFileHeaderReader();
        chunkReader = new StyFileChunkReader();
        readers = new HashMap<>();
        readers.put("TILE", new StyTilesReader());
        readers.put("PPAL", new StyPhysicalPalettesReader());
        readers.put("SPRB", new StySpriteBaseReader());
        readers.put("FONB", new StyFontBaseReader());
        readers.put("DELX", new StyDeltaIndexReader());
        readers.put("DELS", new StyDeltaStoreReader());
        readers.put("PALX", new StyPaletteIndexReader());
        readers.put("OBJI", new StyObjectInfoReader());
        readers.put("RECY", new StyRecyclingInfoReader());
        readers.put("SPRG", new StySpritePageReader());
        readers.put("SPRX", new StySpriteIndexReader());
        readers.put("PALB", new StyPaletteBaseReader());
        readers.put("CARI", new StyCarInfoReader());
        readers.put("SPEC", new StySpecsReader());
    }

    public StyFileStructure readFile() throws FileNotFoundException, IOException {
        try(FileInputStream fileInput = new FileInputStream(styFile)){
            try(RawInputStream input = new RawInputStream(fileInput)){
                StyFileHeader header = headerReader.read(input);
                if(!FILE_HEADER.equals(header.getFileType())) {
                    throw new StyFileCorruptException("Unexpected file header for " + styFile.getAbsolutePath());
                }
                StyFileStructure structure = new StyFileStructure();
                readChunks(input, structure);
                return structure;
            }
        }
    }
    
    private void readChunks(RawInputStream input, StyFileStructure dst) throws IOException {
        StyFileChunk chunk;
        do {
            chunk = chunkReader.read(input);
            if(chunk == null) {
                break;
            }
            StyReader reader = readers.get(chunk.getChunkType());
            if(reader != null) {
                reader.read(input, chunk.getChunkSize(), dst);
            }
        } while(chunk != null);
    }

}
