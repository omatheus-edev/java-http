package codes.matheus.header;

import codes.matheus.exception.IllegalHttpHeaderException;
import org.jetbrains.annotations.NotNull;

import java.util.*;

final class HttpHeaderImpl implements HttpHeader {
    private final @NotNull String key;
    private final @NotNull List<String> values = new ArrayList<>();

    HttpHeaderImpl(@NotNull String key, @NotNull String value) {
        if (key.isBlank()) throw new IllegalHttpHeaderException("header key cannot be blank");
        if (value.isBlank()) throw new IllegalHttpHeaderException("header value cannot be blank");
        this.key = key;
        this.values.add(value);
    }

    HttpHeaderImpl(@NotNull String key, @NotNull String @NotNull ... values) {
        if (key.isBlank()) throw new IllegalHttpHeaderException("header key cannot be blank");
        if (Arrays.stream(values).anyMatch(String::isBlank)) throw new IllegalHttpHeaderException("header values cannot be blank");
        this.key = key;
        this.values.addAll(Arrays.asList(values));
    }

    @Override
    public @NotNull String getKey() {
        return key;
    }

    @Override
    public @NotNull List<String> getValues() {
        return Collections.unmodifiableList(values);
    }

    @Override
    public @NotNull HttpHeader add(@NotNull String value) {
        values.add(value);
        return this;
    }

    @Override
    public @NotNull String toString() {
        return key + ": " + String.join(", ", values);
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        HttpHeaderImpl that = (HttpHeaderImpl) object;
        return Objects.equals(key, that.key) && Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, values);
    }
}
