package codes.matheus.body;

import codes.matheus.exception.IllegalHttpBodyException;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;

final class HttpBodyImpl implements HttpBody {
    private final byte[] body;
    private final int length;

    public HttpBodyImpl(byte[] body) {
        this.body = body;
        this.length = body.length;
    }

    public HttpBodyImpl(@NotNull InputStream stream) {
        try {
            this.body = stream.readAllBytes();
            this.length = body.length;
        } catch (IOException e) {
            throw new IllegalHttpBodyException("invalid body: " + e);
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public byte[] asBytes() {
        return body;
    }

    @Override
    public @NotNull String asString() {
        return new String(body, StandardCharsets.UTF_8);
    }

    @Override
    public @NotNull InputStream asStream() {
        return new ByteArrayInputStream(body);
    }

    @Override
    public boolean isEmpty() {
        return body.length == 0;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        HttpBodyImpl httpBody = (HttpBodyImpl) object;
        return length == httpBody.length && Objects.deepEquals(body, httpBody.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(body), length);
    }
}
