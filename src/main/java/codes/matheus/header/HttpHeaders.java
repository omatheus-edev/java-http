package codes.matheus.header;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public interface HttpHeaders {
    static @NotNull HttpHeaders newEmptyHeaders() {
        return new HttpHeadersImpl();
    }

    static @NotNull HttpHeaders newHeaders(@NotNull String key, @NotNull String value) {
        return new HttpHeadersImpl().add(key, value);
    }

    @NotNull HttpHeaders add(@NotNull String key, @NotNull String value);

    @NotNull HttpHeaders add(@NotNull String key, @NotNull String @NotNull ... values);

    void remove(@NotNull String key);

    @NotNull String get(@NotNull String key);

    @NotNull HttpHeaders set(@NotNull String key, @NotNull String value);

    @NotNull Optional<String> first(@NotNull String key);

    @NotNull List<String> all(@NotNull String key);

    @NotNull List<HttpHeader> allHeaders();

    boolean contains(@NotNull String key);
}
