package codes.matheus.exception;

import org.jetbrains.annotations.NotNull;

public final class IllegalHttpRequestException extends RuntimeException {
    public IllegalHttpRequestException(@NotNull String message) {
        super(message);
    }
}
