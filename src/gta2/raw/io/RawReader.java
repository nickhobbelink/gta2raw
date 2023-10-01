package gta2.raw.io;

import java.io.IOException;

public interface RawReader<T> {
    public T read(RawInputStream input) throws IOException;
}
