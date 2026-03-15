package codes.matheus.exception;

import org.jetbrains.annotations.NotNull;

public final class IllegalHttpVersionException extends RuntimeException {
    public IllegalHttpVersionException(@NotNull String message) {
        super(message);
    }
}
