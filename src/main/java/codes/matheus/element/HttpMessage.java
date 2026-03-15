package codes.matheus.element;

import codes.matheus.body.HttpBody;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;

public interface HttpMessage {
    @NotNull HttpVersion getVersion();

    @NotNull HttpHeaders getHeaders();

    @NotNull HttpBody getBody();
}
