package gta2.raw.examples;

import java.awt.image.BufferedImage;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import gta2.raw.io.StyConverter;
import gta2.raw.io.structures.RgbaImage;
import gta2.raw.sty.StyFileReader;
import gta2.raw.sty.StyFileStructure;
import gta2.raw.util.LocalLogger;
import gta2.raw.util.Logger;

/**
 * @author Nick Hobbelink
 * This example converts GTA2 Sty files into .png files
 */
public class StyConverterExample {
    private final Logger log;
    private final File inputFile;
    private final File outputFolder;

    public StyConverterExample(Logger log, File inputFile, File outputFolder) {
        this.log = log;
        this.inputFile = inputFile;
        this.outputFolder = outputFolder;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Logger log = new LocalLogger();
        if(args.length != 2) {
            log.error("Usage: styconverterexample [sty file path] [output folder path]");
            return;
        }
        File inputFile = new File(args[0]);
        if(!inputFile.exists()) {
            throw new FileNotFoundException(inputFile.getAbsolutePath() + " does not exist");
        }
        File outputFolder = new File(args[1]);
        if(!outputFolder.exists()) {
            outputFolder.mkdir();
        }
        new StyConverterExample(log, inputFile, outputFolder).execute();
    }

    private void execute() throws FileNotFoundException, IOException {
        StyFileReader reader = new StyFileReader(inputFile);
        StyFileStructure structure = reader.readFile();
        StyConverter converter = new StyConverter(structure);
        
        writeSprites(structure, converter);
        writeTiles(structure, converter);
    }

    private void writeSprites(StyFileStructure structure, StyConverter converter) throws FileNotFoundException, IOException {
        File spritesFolder = new File(outputFolder, "sprites");
        if(!spritesFolder.exists()) {
            spritesFolder.mkdir();
        }
        for(int i = 0; i < structure.getPaletteBase().getSprite(); ++i) {
            RgbaImage sprite = converter.convertSpriteToRgba(i);
            String type = structure.getSpriteBase().getType(i);
            File outFile = new File(spritesFolder, String.format("%d-%s.png", i, type));
            
            log.info("Writing %s...", outFile.getName());
            writePng(sprite, outFile);
        }
    }
    
    private void writeTiles(StyFileStructure structure, StyConverter converter) throws FileNotFoundException, IOException {
        File tilesFolder = new File(outputFolder, "tiles");
        if(!tilesFolder.exists()) {
            tilesFolder.mkdir();
        }
        for(int i = 0; i < structure.getPaletteBase().getTile(); ++i) {
            RgbaImage raw = converter.convertTileToRgba(i);
            File outFile = new File(tilesFolder, String.format("%d.png", i));
            
            log.info("Writing %s...", outFile.getName());
            writePng(raw, outFile);
        }
    }

    private void writePng(RgbaImage img, File file) throws FileNotFoundException, IOException {
        try(FileOutputStream output = new FileOutputStream(file)){
            writePng(img, output);
        }
    }

    private void writePng(RgbaImage raw, OutputStream output) throws IOException {
        DataBuffer buffer = new DataBufferByte(raw.getRaw(), raw.getRaw().length);
        SampleModel sampleModel = new ComponentSampleModel(DataBuffer.TYPE_BYTE, raw.getW(), raw.getH(), 4, raw.getW() * 4, new int[]{0,1,2,3});
        Raster raster = Raster.createRaster(sampleModel, buffer, null);
        BufferedImage image = new BufferedImage(raw.getW(), raw.getH(), BufferedImage.TYPE_4BYTE_ABGR);
        image.setData(raster);
        
        ImageIO.write(image, "png", output);
    }
    
}
