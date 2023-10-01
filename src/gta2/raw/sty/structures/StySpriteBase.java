package gta2.raw.sty.structures;

import java.io.IOException;

import gta2.raw.io.RawInputStream;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.StyReader;

/**
 * @author Nick Hobbelink
 */
public class StySpriteBase {
    private int car;
    private int ped;
    private int codeObj;
    private int mapObj;
    private int user;
    private int font;

    public int getCar() {
        return car;
    }
    
    public int getPed() {
        return ped;
    }
    
    public int getCodeObj() {
        return codeObj;
    }
    
    public int getMapObj() {
        return mapObj;
    }
    
    public int getUser() {
        return user;
    }
    
    public int getFont() {
        return font;
    }
    
    public int calcCarBase() {
        return 0;
    }
    
    public int calcPedBase() {
        return car;
    }
    
    public int calcCodeObjBase() {
        return car + ped;
    }
    
    public int calcMapObjBase() {
        return car + ped + codeObj;
    }
    
    public int calcUserBase() {
        return car + ped + codeObj + mapObj;
    }
    
    public int calcFontBase() {
        return car + ped + codeObj + mapObj + user;
    }
    
    public static class StySpriteBaseReader implements StyReader{
        @Override
        public void read(RawInputStream input, long chunkSize, StyFileStructure dst) throws IOException {
            StySpriteBase base = new StySpriteBase();
            base.car = input.readUInt16();
            base.ped = input.readUInt16();
            base.codeObj = input.readUInt16();
            base.mapObj = input.readUInt16();
            base.user = input.readUInt16();
            base.font = input.readUInt16();
            dst.setSpriteBase(base);
        }
    }

    public String getType(int sprite) {
        if(sprite >= calcFontBase()) {
            return "font";
        }
        if(sprite >= calcUserBase()) {
            return "user";
        }
        if(sprite >= calcMapObjBase()) {
            return "mapObj";
        }
        if(sprite >= calcCodeObjBase()) {
            return "codeObj";
        }
        if(sprite >= calcPedBase()) {
            return "ped";
        }
        return "car";
    }
}
