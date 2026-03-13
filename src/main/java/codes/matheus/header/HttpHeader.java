package codes.matheus.header;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface HttpHeader {
    static @NotNull HttpHeader create(@NotNull String key, @NotNull String value) {
        return new HttpHeaderImpl(key, value);
    }

    static @NotNull HttpHeader create(@NotNull String key, @NotNull String ... values) {
        return new HttpHeaderImpl(key, values);
    }

    @NotNull String getKey();

    @NotNull List<String> getValues();

    @NotNull HttpHeader add(@NotNull String value);
}
