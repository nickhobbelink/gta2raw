package gta2.raw.audio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gta2.raw.audio.SdtEntry.SdtEntryReader;
import gta2.raw.io.RawInputStream;

/**
 * @author Nick Hobbelink
 * Reads a GTA2 SDT file into an array of sound entries
 */
public class SdtFileReader {
    private final File sdtFile;
    private final SdtEntryReader entryReader;
    
    public SdtFileReader(File sdtFile) {
        this.sdtFile = sdtFile;
        entryReader = new SdtEntryReader();
    }
    
    public SdtFileStructure readFile() throws FileNotFoundException, IOException {
        List<SdtEntry> entries = new ArrayList<>();
        try(FileInputStream fileInput = new FileInputStream(sdtFile)){
            try(RawInputStream input = new RawInputStream(fileInput)){
                SdtEntry entry;
                do {
                    entry = entryReader.read(input);
                    if(entry != null) {
                        entries.add(entry);
                    }
                } while(entry != null);
            }
        }
        return new SdtFileStructure(entries);
    }
}
