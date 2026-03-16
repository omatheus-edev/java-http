package codes.matheus.element.request;

import codes.matheus.body.HttpBody;
import codes.matheus.element.Method;
import codes.matheus.exception.IllegalHttpRequestException;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
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

    static final class Builder implements HttpRequest.Builder {
        private @Nullable Method method;
        private @Nullable URI uri;
        private @NotNull HttpVersion version = HttpVersion.V1_1;
        private @NotNull HttpHeaders headers = HttpHeaders.newEmptyHeaders();
        private @Nullable HttpBody body;

        @Override
        public HttpRequest.@NotNull Builder uri(@NotNull String uri) {
            this.uri = URI.create(uri);
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder post() {
            this.method = Method.POST;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder get() {
            this.method = Method.GET;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder delete() {
            this.method = Method.DELETE;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder put() {
            this.method = Method.PUT;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder patch() {
            this.method = Method.PATCH;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder head() {
            this.method = Method.GET;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder options() {
            this.method = Method.OPTIONS;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder trace() {
            this.method = Method.TRACE;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder connect() {
            this.method = Method.CONNECT;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder version(@NotNull HttpVersion version) {
            this.version = version;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder header(@NotNull String key, @NotNull String value) {
            headers.add(key, value);
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder header(@NotNull String key, @NotNull String @NotNull ... values) {
            headers.add(key, values);
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder headers(@NotNull HttpHeaders headers) {
            this.headers = headers;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder body(@NotNull HttpBody body) {
            this.body = body;
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder body(@NotNull String body) {
            this.body = HttpBody.create(body);
            return this;
        }

        @Override
        public HttpRequest.@NotNull Builder body(byte[] body) {
            this.body = HttpBody.create(body);
            return this;
        }

        @Override
        public @NotNull HttpRequest build() {
            if (method == null) throw new IllegalHttpRequestException("method is required");
            if (uri == null) throw new IllegalHttpRequestException("uri is required");
            return new HttpRequestImpl(new RequestLine(method, uri, version), headers, body);
        }
    }
}
