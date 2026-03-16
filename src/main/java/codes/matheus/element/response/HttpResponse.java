package codes.matheus.element.response;

import codes.matheus.body.HttpBody;
import codes.matheus.element.HttpMessage;
import codes.matheus.element.HttpStatus;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface HttpResponse extends HttpMessage {
    static @NotNull HttpResponse create(@NotNull HttpVersion version, @NotNull HttpStatus status, @NotNull HttpHeaders headers, @Nullable HttpBody body) {
        return new HttpResponseImpl(version, status, headers, body);
    }

    @NotNull HttpStatus getStatus();

    @Override
    @NotNull HttpVersion getVersion();

    @Override
    @NotNull HttpHeaders getHeaders();

    @Override
    @Nullable HttpBody getBody();
}
