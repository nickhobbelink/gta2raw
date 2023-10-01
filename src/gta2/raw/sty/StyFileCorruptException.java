package gta2.raw.sty;

import java.io.IOException;

public class StyFileCorruptException extends IOException {
    private static final long serialVersionUID = 1L;

    public StyFileCorruptException() {
        super("Sty file corrupt");
    }

    public StyFileCorruptException(String message) {
        super(message);
    }
}
