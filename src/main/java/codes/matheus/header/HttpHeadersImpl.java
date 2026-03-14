package codes.matheus.header;

import codes.matheus.exception.IllegalHttpHeaderException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

final class HttpHeadersImpl implements HttpHeaders {

    private final @NotNull Map<String, HttpHeader> headers = new HashMap<>();

    @Override
    public @NotNull HttpHeaders add(@NotNull String key, @NotNull String value) {
        headers.compute(key, (k, header) -> {
           if (header != null) {
               header.add(value);
               return header;
           }
           return HttpHeader.create(key, value);
        });
        return this;
    }

    @Override
    public @NotNull HttpHeaders add(@NotNull String key, @NotNull String @NotNull ... values) {
        headers.compute(key, (k, header) -> {
            if (header != null) {
                Arrays.stream(values).forEach(header::add);
                return header;
            }
            return HttpHeader.create(key, values);
        });
        return this;
    }

    @Override
    public void remove(@NotNull String key) {
        headers.remove(key);
    }

    @Override
    public @NotNull String get(@NotNull String key) {
        @Nullable HttpHeader header = headers.get(key);
        if (header == null) throw new IllegalHttpHeaderException("header not found: " + key);
        return String.join(", ", header.getValues());
    }

    @Override
    public @NotNull HttpHeaders set(@NotNull String key, @NotNull String value) {
        headers.put(key, HttpHeader.create(key, value));
        return this;
    }

    @Override
    public @NotNull HttpHeaders set(@NotNull String key, @NotNull String @NotNull ... values) {
        headers.put(key, HttpHeader.create(key, values));
        return this;
    }

    @Override
    public @NotNull Optional<String> first(@NotNull String key) {
        return Optional.ofNullable(headers.get(key))
                .flatMap(header -> header.getValues().stream().findFirst());
    }

    @Override
    public @NotNull List<String> all(@NotNull String key) {
        @Nullable HttpHeader header = headers.get(key);
        if (header == null) throw new IllegalHttpHeaderException("header not found: " + key);
        return header.getValues();
    }

    @Override
    public @NotNull List<HttpHeader> allHeaders() {
        return List.copyOf(headers.values());
    }

    @Override
    public boolean contains(@NotNull String key) {
        return headers.containsKey(key);
    }
}
