package codes.matheus.element.response;

import codes.matheus.body.HttpBody;
import codes.matheus.element.HttpStatus;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

final class HttpResponseImpl implements HttpResponse {
    private final @NotNull HttpVersion version;
    private final @NotNull HttpStatus status;
    private final @NotNull HttpHeaders headers;
    private final @Nullable HttpBody body;

    HttpResponseImpl(@NotNull HttpVersion version, @NotNull HttpStatus status, @NotNull HttpHeaders headers, @Nullable HttpBody body) {
        this.version = version;
        this.status = status;
        this.headers = headers;
        this.body = body;
    }

    @Override
    public @NotNull HttpVersion getVersion() {
        return version;
    }

    @Override
    public @NotNull HttpStatus getStatus() {
        return status;
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
    public String toString() {
        return "HttpResponseImpl{" +
                "version=" + version +
                ", status=" + status +
                ", headers=" + headers +
                ", body=" + (body != null ? body.asString() : "empty") +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        HttpResponseImpl that = (HttpResponseImpl) object;
        return version == that.version && status == that.status && Objects.equals(headers, that.headers) && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, status, headers, body);
    }
}
