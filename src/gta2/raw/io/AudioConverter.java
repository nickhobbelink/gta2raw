package gta2.raw.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import gta2.raw.audio.SdtEntry;
import gta2.raw.audio.SdtFileStructure;

/**
 * @author Nick Hobbelink
 * Converts GTA2 audio data into usable Wave/PCM formats
 *
 */
public class AudioConverter {
    private SdtFileStructure sdtFile;
    private File rawFile;
    
    public AudioConverter(SdtFileStructure sdtFile, File rawFile) {
        super();
        this.sdtFile = sdtFile;
        this.rawFile = rawFile;
    }
    
    public void convertToWave(int index, OutputStream output) throws FileNotFoundException, IOException {
        SdtEntry entry = sdtFile.getEntries().get(index);
        try(RawOutputStream raw = new RawOutputStream(output)){
            raw.writeString("RIFF");
            raw.writeInt32(entry.getSize() + 36);
            raw.writeString("WAVEfmt ");
            raw.writeInt32(16);
            raw.writeInt16(1);
            raw.writeInt16(1);
            raw.writeInt32(entry.getSamplesPerSec());
            raw.writeInt32(entry.getSamplesPerSec() * 2);
            raw.writeInt16(2);
            raw.writeInt16(16);
            raw.writeString("data");
            raw.writeInt32(entry.getSize());
            readRaw(entry.getOffset(), entry.getSize(), raw);
        }
    }
    
    public void readPcm(int index, OutputStream output) throws IOException {
        SdtEntry entry = sdtFile.getEntries().get(index);
        readRaw(entry.getOffset(), entry.getSize(), output);
    }
    
    private void readRaw(int offset, int size, OutputStream output) throws IOException {
        try(FileInputStream fileInput = new FileInputStream(rawFile)){
            fileInput.skip(offset);
            copy(fileInput, output, size);
        }
    }

    private void copy(FileInputStream input, OutputStream output, int size) throws IOException {
        byte[] buffer = new byte[10];
        int read = 0;
        int length;
        while(read < size) {
            length = input.read(buffer, 0, Math.min(size - read, buffer.length));
            if(length > 0) {
                output.write(buffer, 0, length);
                read += length;
            }
        }
    }
}
