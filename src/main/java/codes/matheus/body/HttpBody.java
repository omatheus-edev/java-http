package codes.matheus.body;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public interface HttpBody {
    static @NotNull HttpBody create(@NotNull String body) {
        return new HttpBodyImpl(body.getBytes(StandardCharsets.UTF_8));
    }

    static @NotNull HttpBody create(byte[] body) {
        return new HttpBodyImpl(body);
    }

    static @NotNull HttpBody create(@NotNull InputStream stream) {
        return new HttpBodyImpl(stream);
    }

    int length();

    byte[] asBytes();

    @NotNull String asString();

    @NotNull InputStream asStream();

    boolean isEmpty();
}
