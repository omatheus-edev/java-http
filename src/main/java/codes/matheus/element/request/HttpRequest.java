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
    static @NotNull Builder builder() {
        return new HttpRequestImpl.Builder();
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

    interface Builder {

        @NotNull Builder post();

        @NotNull Builder get();

        @NotNull Builder delete();

        @NotNull Builder put();

        @NotNull Builder patch();

        @NotNull Builder head();

        @NotNull Builder options();

        @NotNull Builder trace();

        @NotNull Builder connect();

        @NotNull Builder uri(@NotNull String uri);

        @NotNull Builder version(@NotNull HttpVersion version);

        @NotNull Builder header(@NotNull String key, @NotNull String value);

        @NotNull Builder header(@NotNull String key, @NotNull String @NotNull ... values);

        @NotNull Builder headers(@NotNull HttpHeaders headers);

        @NotNull Builder body(@NotNull HttpBody body);

        @NotNull Builder body(@NotNull String body);

        @NotNull Builder body(byte[] body);

        @NotNull HttpRequest build();
    }
}
