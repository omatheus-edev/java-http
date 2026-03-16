package codes.matheus.element;

import codes.matheus.body.HttpBody;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface HttpMessage {
    @NotNull HttpVersion getVersion();

    @NotNull HttpHeaders getHeaders();

    @Nullable HttpBody getBody();

    default boolean hasBody() {
        return getBody() != null && !getBody().isEmpty();
    }
}
