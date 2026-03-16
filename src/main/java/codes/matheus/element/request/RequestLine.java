package codes.matheus.element.request;

import codes.matheus.element.Method;
import codes.matheus.exception.HttpRequestParseException;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.util.Objects;

public final class RequestLine {
    public static @NotNull RequestLine parse(@NotNull String requestLine) {
        if (requestLine.isBlank()) throw new HttpRequestParseException("request line cannot be blank");
        @NotNull String[] parts = requestLine.split(" ");
        if (parts.length != 3) throw new HttpRequestParseException("request line must include the method, path and version");

        return new RequestLine(Method.valueOf(parts[0]), URI.create(parts[1]), HttpVersion.ofString(parts[2]));
    }

    private final @NotNull Method method;
    private final @NotNull URI uri;
    private final @NotNull HttpVersion version;

    public RequestLine(@NotNull Method method, @NotNull URI uri, @NotNull HttpVersion version) {
        this.method = method;
        this.uri = uri;
        this.version = version;
    }

    public @NotNull Method getMethod() {
        return method;
    }

    public @NotNull URI getUri() {
        return uri;
    }

    public @NotNull HttpVersion getVersion() {
        return version;
    }

    @Override
    public @NotNull String toString() {
        return method + " " + uri + " " + version;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        RequestLine that = (RequestLine) object;
        return method == that.method && Objects.equals(uri, that.uri) && version == that.version;
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, uri, version);
    }
}
