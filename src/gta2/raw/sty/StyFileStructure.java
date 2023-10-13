package gta2.raw.sty;

import java.util.List;

import gta2.raw.sty.structures.StyDeltaIndex;
import gta2.raw.sty.structures.StyFontBase;
import gta2.raw.sty.structures.StyPaletteBase;
import gta2.raw.sty.structures.StyPaletteIndex;
import gta2.raw.sty.structures.StyPalettePage;
import gta2.raw.sty.structures.StyRecyclingInfo;
import gta2.raw.sty.structures.StySpecs;
import gta2.raw.sty.structures.StySpriteBase;
import gta2.raw.sty.structures.StySpriteIndex;
import gta2.raw.sty.structures.StySpritePage;
import gta2.raw.sty.structures.StyTilePage;

/**
 * @author Nick Hobbelink
 * Represents a parsed GTA2 sty file
 */
public class StyFileStructure {
    private List<StyTilePage> tilePages;
    private List<StyPalettePage> palettePages;
    private StySpriteBase spriteBase;
    private StyFontBase fontBase;
    private List<StyDeltaIndex> deltaIndexes;
    private StyPaletteIndex paletteIndex;
    private StyRecyclingInfo recyclingInfo;
    private List<StySpritePage> spritePages;
    private List<StySpriteIndex> spriteIndexes;
    private StyPaletteBase paletteBase;
    private StySpecs specs;
    
    public List<StyTilePage> getTilePages() {
        return tilePages;
    }
    
    public void setTilePages(List<StyTilePage> tiles) {
        this.tilePages = tiles;
    }
    
    public List<StyPalettePage> getPalletePages() {
        return palettePages;
    }
    
    public void setPalletePages(List<StyPalettePage> palettes) {
        this.palettePages = palettes;
    }
    
    public StySpriteBase getSpriteBase() {
        return spriteBase;
    }
    
    public void setSpriteBase(StySpriteBase spriteBase) {
        this.spriteBase = spriteBase;
    }
    
    public StyFontBase getFontBase() {
        return fontBase;
    }
    
    public void setFontBase(StyFontBase fontBase) {
        this.fontBase = fontBase;
    }
    
    public List<StyDeltaIndex> getDeltaIndexes() {
        return deltaIndexes;
    }
    
    public void setDeltaIndexes(List<StyDeltaIndex> deltaIndexes) {
        this.deltaIndexes = deltaIndexes;
    }
    
    public StyPaletteIndex getPaletteIndex() {
        return paletteIndex;
    }
    
    public void setPaletteIndex(StyPaletteIndex paletteIndex) {
        this.paletteIndex = paletteIndex;
    }
    
    public StyRecyclingInfo getRecyclingInfo() {
        return recyclingInfo;
    }
    
    public void setRecyclingInfo(StyRecyclingInfo recyclingInfo) {
        this.recyclingInfo = recyclingInfo;
    }
    
    public List<StySpritePage> getSpritePages() {
        return spritePages;
    }
    
    public void setSpritePages(List<StySpritePage> spritePages) {
        this.spritePages = spritePages;
    }
    
    public StyPaletteBase getPaletteBase() {
        return paletteBase;
    }
    
    public void setPaletteBase(StyPaletteBase paletteBase) {
        this.paletteBase = paletteBase;
    }
    
    public List<StySpriteIndex> getSpriteIndexes() {
        return spriteIndexes;
    }
    
    public void setSpriteIndexes(List<StySpriteIndex> spriteIndexes) {
        this.spriteIndexes = spriteIndexes;
    }

    public StySpecs getSpecs() {
        return specs;
    }

    public void setSpecs(StySpecs specs) {
        this.specs = specs;
    }
}
