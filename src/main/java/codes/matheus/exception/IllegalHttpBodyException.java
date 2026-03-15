package codes.matheus.exception;

import org.jetbrains.annotations.NotNull;

public final class IllegalHttpBodyException extends RuntimeException {
    public IllegalHttpBodyException(@NotNull String message) {
        super(message);
    }
}
