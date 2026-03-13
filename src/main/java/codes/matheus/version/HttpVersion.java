package codes.matheus.version;

import org.jetbrains.annotations.NotNull;

public enum HttpVersion {
    V1_1(1, 1),
    V2(2, 0),
    V3(3, 0);

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
