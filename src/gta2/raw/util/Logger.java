package gta2.raw.util;

public interface Logger {
    void error(String msg);
    void info(String string);
    void info(String format, Object... args);
}
