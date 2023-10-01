package gta2.raw.sty.structures;

import java.io.IOException;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileCorruptException;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StyPaletteBase {
    private int tile;
    private int sprite;
    private int carRemap;
    private int pedRemap;
    private int codeObjRemap;
    private int mapObjRemap;
    private int userRemap;
    private int fontRemap;
    
    public int getTile() {
        return tile;
    }
    
    public int getSprite() {
        return sprite;
    }
    
    public int getCarRemap() {
        return carRemap;
    }

    public int getPedRemap() {
        return pedRemap;
    }

    public int getCodeObjRemap() {
        return codeObjRemap;
    }

    public int getMapObjRemap() {
        return mapObjRemap;
    }

    public int getUserRemap() {
        return userRemap;
    }

    public int getFontRemap() {
        return fontRemap;
    }
    
    public int calcTileBase() {
        return 0;
    }
    
    public int calcSpriteBase() {
        return tile;
    }
    
    public int calcCodeObjRemap() {
        return tile + sprite + carRemap + pedRemap;
    }
    
    public int calcMapObjRemap() {
        return tile + sprite + carRemap + pedRemap + codeObjRemap;
    }

    public static class StyPaletteBaseReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            if(chunkSize != 16) {
                throw new StyFileCorruptException();
            }
            StyPaletteBase paletteBase = new StyPaletteBase();
            paletteBase.tile = input.readUInt16();
            paletteBase.sprite = input.readUInt16();
            paletteBase.carRemap = input.readUInt16();
            paletteBase.pedRemap = input.readUInt16();
            paletteBase.codeObjRemap = input.readUInt16();
            paletteBase.mapObjRemap = input.readUInt16();
            paletteBase.userRemap = input.readUInt16();
            paletteBase.fontRemap = input.readUInt16();
            dst.setPaletteBase(paletteBase);
        }
    }
}
