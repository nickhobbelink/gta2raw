package gta2.raw.io;

import gta2.raw.io.structures.RgbaImage;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.sty.structures.StySpriteIndex;

import static gta2.raw.sty.StyConstants.PAGE_PALETTES;
import static gta2.raw.sty.StyConstants.PAGE_TILES;
import static gta2.raw.sty.StyConstants.TILE_PAGE_SCANLINE;
import static gta2.raw.sty.StyConstants.TILE_WIDTH;

import static gta2.raw.sty.StyConstants.TILE_HEIGHT;
import static gta2.raw.sty.StyConstants.PAGE_H_TILES;
import static gta2.raw.sty.StyConstants.SPRITE_PAGE_SCANLINE;
import static gta2.raw.sty.StyConstants.SPRITE_PAGE_SIZE;

/**
 * @author Nick Hobbelink
 * Converts GTA2 sty data into usable RGBA data
 */
public class StyConverter {
    private StyFileStructure structure;
    
    public StyConverter(StyFileStructure structure) {
        super();
        this.structure = structure;
    }
    
    public RgbaImage convertTileToRgba(int tile) {
        int base = structure.getPaletteBase().calcTileBase();
        int physPalette = structure.getPaletteIndex().getPhysPalette()[base + tile];
        byte[] palettePage = structure.getPalletePages().get(physPalette / PAGE_PALETTES).getRaw();
        byte[] tilePage = structure.getTilePages().get(tile / PAGE_TILES).getRaw();
        int tileIndex = tile % PAGE_TILES;
        int left = (tileIndex % PAGE_H_TILES) * TILE_WIDTH;
        int top = (tileIndex / PAGE_H_TILES) * TILE_HEIGHT;
        int start = left + TILE_PAGE_SCANLINE * top;
        
        int pcolumn = physPalette % PAGE_PALETTES;

        return convertToRgba(tilePage, start, TILE_WIDTH, TILE_HEIGHT, TILE_PAGE_SCANLINE, palettePage, pcolumn);
    }
    
    public RgbaImage convertSpriteToRgba(int sprite) {
        int base = structure.getPaletteBase().calcSpriteBase();
        int physPalette = structure.getPaletteIndex().getPhysPalette()[base + sprite];
        byte[] palettePage = structure.getPalletePages().get(physPalette / PAGE_PALETTES).getRaw();

        StySpriteIndex index = structure.getSpriteIndexes().get(sprite);
        long ptr = index.getPtr();
        
        byte[] spritePage = structure.getSpritePages().get( (int)(ptr / SPRITE_PAGE_SIZE) ).getRaw();
        
        int pcolumn = physPalette % PAGE_PALETTES;
        int start = (int) ptr % SPRITE_PAGE_SIZE;
        
        return convertToRgba(spritePage, start, index.getWidth(), index.getHeight(), SPRITE_PAGE_SCANLINE, palettePage, pcolumn);
        
    }

    private RgbaImage convertToRgba(byte[] tilePage, int start, int w, int h, int pageW, byte[] palettePage, int pcolumn) {
        byte[] out = new byte[w * h * 4];
        int inScanWidth = (w * 4);
        
        for(int y = 0; y < h; y++) {
            int outScan = inScanWidth * y;
            int inScan = pageW * y;
            
            for(int x = 0; x < w; ++x) {
                int inColor = (tilePage[start + x + inScan] & 0xFF);
                int paletteOfs = (inColor * PAGE_PALETTES + pcolumn) * 4;

                int outOfs = outScan + x * 4;
                out[outOfs] = palettePage[paletteOfs + 2];
                out[outOfs + 1] = palettePage[paletteOfs + 1];
                out[outOfs + 2] = palettePage[paletteOfs + 0];
                out[outOfs + 3] = (byte) (inColor == 0 ? 0 : 0xFF);
            }
        }
        return new RgbaImage(w, h, out);
    }
}
