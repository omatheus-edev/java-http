package codes.matheus.element.request;

import codes.matheus.body.HttpBody;
import codes.matheus.element.HttpMessage;
import codes.matheus.element.Method;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;

public interface HttpRequest extends HttpMessage {
    static @NotNull HttpRequest create(@NotNull RequestLine requestLine, @NotNull HttpHeaders headers, @Nullable HttpBody body) {
        return new HttpRequestImpl(requestLine, headers, body);
    }

    static @NotNull HttpRequest create(@NotNull Method method, @NotNull URI uri, @NotNull HttpVersion version, @NotNull HttpHeaders headers, @Nullable HttpBody body) {
        return new HttpRequestImpl(new RequestLine(method, uri, version), headers, body);
    }

    @NotNull RequestLine getRequestLine();

    default @NotNull Method getMethod() {
        return getRequestLine().getMethod();
    }

    default @NotNull URI getUri() {
        return getRequestLine().getUri();
    }

    default @NotNull String getPath() {
        return getUri().getPath();
    }

    default @NotNull Optional<String> getQueryParam(@NotNull String name) {
        @Nullable String query = getRequestLine().getUri().getQuery();
        if (query == null) return Optional.empty();
        return Arrays.stream(query.split("&"))
                .filter(p -> p.startsWith(name + "="))
                .map(p -> p.split("=", 2)[1])
                .findFirst();
    }

    @Override
    @NotNull HttpVersion getVersion();

    @Override
    @NotNull HttpHeaders getHeaders();

    @Override
    @Nullable HttpBody getBody();
}
