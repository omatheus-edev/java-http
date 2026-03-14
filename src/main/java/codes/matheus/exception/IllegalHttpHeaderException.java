package codes.matheus.exception;

import org.jetbrains.annotations.NotNull;

public final class IllegalHttpHeaderException extends RuntimeException {
    public IllegalHttpHeaderException(@NotNull String message) {
        super(message);
    }
}
