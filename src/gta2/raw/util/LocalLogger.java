package gta2.raw.util;

public class LocalLogger implements Logger {
    @Override
    public void error(String msg) {
        System.err.println(msg);
    }

    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void info(String format, Object... args) {
        System.out.println(String.format(format, args));
    }
}
