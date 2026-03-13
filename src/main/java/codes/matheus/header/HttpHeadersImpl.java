package codes.matheus.header;

import codes.matheus.exception.IllegalHttpHeaderException;
import org.jetbrains.annotations.NotNull;

import java.util.*;

final class HttpHeadersImpl implements HttpHeaders {

    private final @NotNull List<HttpHeader> headers = new ArrayList<>();

    @Override
    public @NotNull HttpHeaders add(@NotNull String key, @NotNull String value) {
        headers.stream()
                .filter(header -> header.getKey().equals(key))
                .findFirst()
                .ifPresentOrElse(
                        header -> header.add(value),
                        () -> headers.add(HttpHeader.create(key, value)));
        return this;
    }

    @Override
    public @NotNull HttpHeaders add(@NotNull String key, @NotNull String @NotNull ... values) {
        headers.stream()
                .filter(header -> header.getKey().equals(key))
                .findFirst()
                .ifPresentOrElse(
                        header -> Arrays.stream(values).forEach(header::add),
                        () -> headers.add(HttpHeader.create(key, values)));
        return this;
    }


    @Override
    public void remove(@NotNull String key) {
        headers.removeIf(header -> header.getKey().equals(key));
    }

    @Override
    public @NotNull String get(@NotNull String key) {
        return headers.stream()
                .filter(header -> header.getKey().equals(key))
                .map(header -> header.getValues().toString())
                .findFirst()
                .orElseThrow(() -> new IllegalHttpHeaderException("header not found: " + key ));
    }

    @Override
    public @NotNull HttpHeaders set(@NotNull String key, @NotNull String value) {
        remove(key);
        headers.add(HttpHeader.create(key, value));
        return this;
    }

    @Override
    public @NotNull Optional<String> first(@NotNull String key) {
        return headers.stream()
                .filter(header -> header.getKey().equals(key))
                .flatMap(header -> header.getValues().stream())
                .findFirst();
    }

    @Override
    public @NotNull List<String> all(@NotNull String key) {
        return headers.stream()
                .filter(header -> header.getKey().equals(key))
                .flatMap(header -> header.getValues().stream())
                .toList();
    }

    @Override
    public @NotNull List<HttpHeader> allHeaders() {
        return Collections.unmodifiableList(headers);
    }

    @Override
    public boolean contains(@NotNull String key) {
        return headers.stream().anyMatch(header -> header.getKey().equals(key));
    }
}
