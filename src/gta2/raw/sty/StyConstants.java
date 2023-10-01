package gta2.raw.sty;

/**
 * @author Nick Hobbelink
 */
public class StyConstants {
    /** Amount of palettes in a palette page */
    public static final int PAGE_PALETTES = 64;
    /** Amount of tiles in a tile page */
    public static final int PAGE_TILES = 16;
    /** Amount of tiles in a single tile page row */
    public static final int PAGE_H_TILES = 4;
    /** Amount of colors in a palette */
    public static final int PALETTE_COUNT = 256;
    /** The size in bytes of a palette page */
    public static final int PALETTE_PAGE_SIZE = PAGE_PALETTES * PALETTE_COUNT * 4;
    /** The width in pixels of a tile */
    public static final int TILE_WIDTH = 64;
    /** The height in pixels of a tile */
    public static final int TILE_HEIGHT = 64;
    /** The width in pixels of a tile page scanline */
    public static final int TILE_PAGE_SCANLINE = PAGE_H_TILES * TILE_WIDTH;
    /** The size in bytes/pixels of a sprite page */
    public static final int SPRITE_PAGE_SIZE = 256 * 256;
    /** The size in bytes/pixels of a tile page */
    public static final int TILE_PAGE_SIZE = 256 * 256;
    /** The width in pixels of a sprite page scanline */
    public static final int SPRITE_PAGE_SCANLINE = 256;
}
