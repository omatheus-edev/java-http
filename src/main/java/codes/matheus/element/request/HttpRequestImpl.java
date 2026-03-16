package codes.matheus.element.request;

import codes.matheus.body.HttpBody;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

final class HttpRequestImpl implements HttpRequest {
    private final @NotNull RequestLine requestLine;
    private final @NotNull HttpHeaders headers;
    private final @Nullable HttpBody body;

    HttpRequestImpl(@NotNull RequestLine requestLine, @NotNull HttpHeaders headers, @Nullable HttpBody body) {
        this.requestLine = requestLine;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public @NotNull RequestLine getRequestLine() {
        return requestLine;
    }

    @Override
    public @NotNull HttpVersion getVersion() {
        return requestLine.getVersion();
    }

    @Override
    public @NotNull HttpHeaders getHeaders() {
        return headers;
    }

    @Override
    public @Nullable HttpBody getBody() {
        return body;
    }

    @Override
    public @NotNull String toString() {
        return "HttpRequestImpl{" +
                "requestLine=" + requestLine +
                ", headers=" + headers +
                ", body=" + (body != null ? body.asString() : "empty") +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        HttpRequestImpl that = (HttpRequestImpl) object;
        return Objects.equals(requestLine, that.requestLine) && Objects.equals(headers, that.headers) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestLine, headers, body);
    }
}
