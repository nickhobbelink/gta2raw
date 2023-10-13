package gta2.raw.io;

import gta2.raw.io.structures.ArgbImage;
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
    private static final int EXPLOSION_START = 878;
    private static final int EXPLOSION_END = 1059;
    private StyFileStructure structure;
    
    public StyConverter(StyFileStructure structure) {
        super();
        this.structure = structure;
    }
    
    public RgbaImage convertTileToRgba(int tile) {
        int physPalette = getTilePhysPalette(tile);
        byte[] palettePage = getPalletePage(physPalette);
        byte[] tilePage = getTilePage(tile);
        int tileIndex = getTileIndex(tile);
        int left = getTileLeft(tileIndex);
        int top = getTileTop(tileIndex);
        int start = getTileStart(left, top);
        
        int pcolumn = getPaletteColumn(physPalette);

        return convertToRgba(tilePage, start, TILE_WIDTH, TILE_HEIGHT, TILE_PAGE_SCANLINE, palettePage, pcolumn);
    }

    public RgbaImage convertSpriteToRgba(int sprite) {
        int physPalette = getSpritePhysPalette(sprite);byte[] palettePage = getPalletePage(physPalette);

        StySpriteIndex index = structure.getSpriteIndexes().get(sprite);
        byte[] spritePage = getSpritePage(index);
        
        int pcolumn = getPaletteColumn(physPalette);
        int start = getSpriteStart(index);
        
        if(sprite >= EXPLOSION_START && sprite <= EXPLOSION_END) {
            return convertExplosionToRgba(spritePage, start, index.getWidth(), index.getHeight(), SPRITE_PAGE_SCANLINE, palettePage, pcolumn);
        }
        return convertToRgba(spritePage, start, index.getWidth(), index.getHeight(), SPRITE_PAGE_SCANLINE, palettePage, pcolumn);
    }

    private int getSpriteStart(StySpriteIndex index) {
        return (int) index.getPtr() % SPRITE_PAGE_SIZE;
    }

    private byte[] getSpritePage(StySpriteIndex index) {
        return structure.getSpritePages().get( (int)(index.getPtr() / SPRITE_PAGE_SIZE) ).getRaw();
    }

    private RgbaImage convertToRgba(byte[] tilePage, int start, int w, int h, int pageW, byte[] palettePage, int pcolumn) {
        byte[] out = new byte[w * h * 4];

        int outOfs = 0;
        for(int y = 0; y < h; y++) {
            int inScan = pageW * y;
            
            for(int x = 0; x < w; ++x) {
                int inColor = (tilePage[start + x + inScan] & 0xFF);
                int paletteOfs = (inColor * PAGE_PALETTES + pcolumn) * 4;

                out[outOfs++] = palettePage[paletteOfs + 2];
                out[outOfs++] = palettePage[paletteOfs + 1];
                out[outOfs++] = palettePage[paletteOfs];
                out[outOfs++] = (byte) (inColor == 0 ? 0 : 0xFF);
            }
        }
        return new RgbaImage(w, h, out);
    }
    
    private RgbaImage convertExplosionToRgba(byte[] tilePage, int start, int w, int h, int pageW, byte[] palettePage, int pcolumn) {
        byte[] out = new byte[w * h * 4];

        int outOfs = 0;
        for(int y = 0; y < h; y++) {
            int inScan = pageW * y;
            
            for(int x = 0; x < w; ++x) {
                int inColor = (tilePage[start + x + inScan] & 0xFF);
                int paletteOfs = (inColor * PAGE_PALETTES + pcolumn) * 4;

                int r = palettePage[paletteOfs + 2] & 0xFF;
                byte a = (byte) (inColor == 0 ? 0 : 0xFF);
                
                if(a != 0) {
                    a = (byte) Math.min(255, (r * 2));
                }
                
                out[outOfs++] = palettePage[paletteOfs + 2];
                out[outOfs++] = palettePage[paletteOfs + 1];
                out[outOfs++] = palettePage[paletteOfs];
                out[outOfs++] = a;
            }
        }
        return new RgbaImage(w, h, out);
    }
    
    public ArgbImage convertTileToArgb(int tile) {
        int physPalette = getTilePhysPalette(tile);
        byte[] palettePage = getPalletePage(physPalette);
        byte[] tilePage = getTilePage(tile);
        int tileIndex = getTileIndex(tile);
        int left = getTileLeft(tileIndex);
        int top = getTileTop(tileIndex);
        int start = getTileStart(left, top);
        
        int pcolumn = getPaletteColumn(physPalette);

        return convertToArgb(tilePage, start, TILE_WIDTH, TILE_HEIGHT, TILE_PAGE_SCANLINE, palettePage, pcolumn);
    }
    
    public ArgbImage convertSpriteToArgb(int sprite) {
        int physPalette = getSpritePhysPalette(sprite);
        byte[] palettePage = getPalletePage(physPalette);

        StySpriteIndex index = structure.getSpriteIndexes().get(sprite);
        byte[] spritePage = getSpritePage(index);
        
        int pcolumn = getPaletteColumn(physPalette);
        int start = getSpriteStart(index);
        
        if(sprite >= EXPLOSION_START && sprite <= EXPLOSION_END) {
            convertExplosionToArgb(spritePage, start, index.getWidth(), index.getHeight(), SPRITE_PAGE_SCANLINE, palettePage, pcolumn);
        }
        return convertToArgb(spritePage, start, index.getWidth(), index.getHeight(), SPRITE_PAGE_SCANLINE, palettePage, pcolumn);
    }

    private int getSpritePhysPalette(int sprite) {
        int base = structure.getPaletteBase().calcSpriteBase();
        return structure.getPaletteIndex().getPhysPalette()[base + sprite];
    }

    private ArgbImage convertToArgb(byte[] tilePage, int start, int w, int h, int pageW, byte[] palettePage, int pcolumn) {
        int[] out = new int[w * h];

        int outOfs = 0;
        for(int y = 0; y < h; y++) {
            int inScan = pageW * y;

            for(int x = 0; x < w; ++x) {
                int inColor = (tilePage[start + x + inScan] & 0xFF);
                int paletteOfs = (inColor * PAGE_PALETTES + pcolumn) * 4;

                int b = palettePage[paletteOfs];
                int g = palettePage[paletteOfs + 1];
                int r = palettePage[paletteOfs + 2];
                int a = (inColor == 0 ? 0 : 0xFF);
                out[outOfs++] = (a & 0xff) << 24 | (r & 0xff) << 16 | (g & 0xff) << 8 | (b & 0xff);
            }
        }
        return new ArgbImage(w, h, out);
    }
    
    private ArgbImage convertExplosionToArgb(byte[] tilePage, int start, int w, int h, int pageW, byte[] palettePage, int pcolumn) {
        int[] out = new int[w * h];

        int outOfs = 0;
        for(int y = 0; y < h; y++) {
            int inScan = pageW * y;

            for(int x = 0; x < w; ++x) {
                int inColor = (tilePage[start + x + inScan] & 0xFF);
                int paletteOfs = (inColor * PAGE_PALETTES + pcolumn) * 4;

                int b = ((int)palettePage[paletteOfs]) & 0xff;
                int g = ((int)palettePage[paletteOfs + 1]) & 0xff;
                int r = ((int)palettePage[paletteOfs + 2]) & 0xff;
                int a = (inColor == 0 ? 0 : 0xFF);
                
                if(a != 0) {
                    a = (byte) Math.min(255, (r * 2));
                }
                
                out[outOfs++] = a << 24 | r << 16 | g << 8 | b;
            }
        }
        return new ArgbImage(w, h, out);
    }
    
    private int getTileStart(int left, int top) {
        return left + TILE_PAGE_SCANLINE * top;
    }

    private int getTilePhysPalette(int tile) {
        int base = structure.getPaletteBase().calcTileBase();
        return structure.getPaletteIndex().getPhysPalette()[base + tile];
    }

    private byte[] getTilePage(int tile) {
        return structure.getTilePages().get(tile / PAGE_TILES).getRaw();
    }

    private int getTileTop(int tileIndex) {
        return (tileIndex / PAGE_H_TILES) * TILE_HEIGHT;
    }

    private int getTileLeft(int tileIndex) {
        return (tileIndex % PAGE_H_TILES) * TILE_WIDTH;
    }

    private int getTileIndex(int tile) {
        return tile % PAGE_TILES;
    }

    private byte[] getPalletePage(int physPalette) {
        return structure.getPalletePages().get(physPalette / PAGE_PALETTES).getRaw();
    }

    private int getPaletteColumn(int physPalette) {
        return physPalette % PAGE_PALETTES;
    }
}
