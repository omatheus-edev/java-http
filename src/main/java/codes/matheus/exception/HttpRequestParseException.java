package codes.matheus.exception;

import org.jetbrains.annotations.NotNull;

public final class HttpRequestParseException extends RuntimeException {
    public HttpRequestParseException(@NotNull String message) {
        super(message);
    }
}
