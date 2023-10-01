package gta2.raw.examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import gta2.raw.audio.AudioConstants;
import gta2.raw.audio.SdtFileReader;
import gta2.raw.audio.SdtFileStructure;
import gta2.raw.io.AudioConverter;
import gta2.raw.util.LocalLogger;
import gta2.raw.util.Logger;

/**
 * @author Nick Hobbelink
 * This example converts a GTA2 STD+RAW pair into .WAV files
 */
public class AudioConverterExample {
    private final Logger log;
    private final String sdtName;
    private final File stdFile;
    private final File rawFile;
    private final File outputFolder;

    public AudioConverterExample(Logger log, String sdtName, File stdFile, File rawFile, File outputFolder) {
        this.log = log;
        this.sdtName = sdtName;
        this.stdFile = stdFile;
        this.rawFile = rawFile;
        this.outputFolder = outputFolder;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Logger log = new LocalLogger();
        if(args.length != 3) {
            log.error("Usage: audioconverterexample [GTA 2 Path] [Audio file name] [output folder path]");
            log.error("Example: audioconverterexample C:\\gta2 bil c:\\output\\audio");
            return;
        }
        File gta2 = new File(args[0]);
        if(!gta2.exists()) {
            throw new FileNotFoundException(gta2.getAbsolutePath() + " does not exist");
        }
        File stdFile = new File(gta2, String.format("data\\audio\\%s.sdt", args[1]));
        if(!stdFile.exists()) {
            throw new FileNotFoundException(stdFile.getAbsolutePath() + " does not exist");
        }
        File rawFile = new File(gta2, String.format("data\\audio\\%s.raw", args[1]));
        if(!rawFile.exists()) {
            throw new FileNotFoundException(rawFile.getAbsolutePath() + " does not exist");
        }
        File outputFolder = new File(args[2]);
        new AudioConverterExample(log, args[1], stdFile, rawFile, outputFolder).execute();
    }

    private void execute() throws FileNotFoundException, IOException {
        if(!outputFolder.exists()) {
            outputFolder.mkdirs();
        }
        
        SdtFileReader reader = new SdtFileReader(stdFile);
        SdtFileStructure structure = reader.readFile();
        AudioConverter converter = new AudioConverter(structure, rawFile);
        List<String> soundNames = AudioConstants.SOUND_NAMES.get(sdtName);
        
        for(int i = 0; i < structure.getEntries().size(); ++i) {
        	writeSoundFile(converter, soundNames, i);
        }
        log.info("Done.");
    }
    
    private void writeSoundFile(AudioConverter converter, List<String> soundNames, int i) throws FileNotFoundException, IOException {
        String name = (soundNames != null) ? soundNames.get(i) : "";
        String nameSuffix = name.isEmpty() ? "" : String.format("-%s", name);
        File outFile = new File(outputFolder, String.format("%d%s.wav", i, nameSuffix));
        log.info("Writing %s...", outFile.getName());
        try(FileOutputStream output = new FileOutputStream(outFile)){
            converter.convertToWave(i, output);
        }
    }
}
