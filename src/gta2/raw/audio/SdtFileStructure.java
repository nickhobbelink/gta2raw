package gta2.raw.audio;

import java.util.List;

/**
 * @author Nick Hobbelink
 * Represents a parsed GTA2 SDT file
 */
public class SdtFileStructure {
    private final List<SdtEntry> entries;
    
    public SdtFileStructure(List<SdtEntry> entries) {
        this.entries = entries;
    }
    
    public List<SdtEntry> getEntries() {
        return entries;
    }
}
