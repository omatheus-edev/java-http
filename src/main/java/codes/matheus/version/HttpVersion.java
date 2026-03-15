package codes.matheus.version;

import codes.matheus.exception.IllegalHttpVersionException;
import org.jetbrains.annotations.NotNull;

public enum HttpVersion {
    V1_1(1, 1),
    V2(2, 0),
    V3(3, 0);

    public static @NotNull HttpVersion ofString(@NotNull String version) {
        @NotNull String s = version.endsWith(".0") ? version.substring(0, version.length() - 2) : version;

        return switch (s) {
            case "HTTP/1.1" -> V1_1;
            case "HTTP/2" -> V2;
            case "HTTP/3" -> V3;
            default -> throw new IllegalHttpVersionException("unsupported http version: " + version);
        };
    }

    private final int major;
    private final int minor;

    HttpVersion(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    @Override
    public @NotNull String toString() {
        return (major < 2) ? "HTTP/" + major + "." + minor : "HTTP/" + major;
    }
}
