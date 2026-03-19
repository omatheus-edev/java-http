package codes.matheus.codec;

import codes.matheus.element.request.HttpRequest;
import codes.matheus.element.response.HttpResponse;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

public interface HttpCodec {
    @NotNull HttpVersion version();

    byte[] encodeRequest(@NotNull HttpRequest request) throws IOException;

    byte[] encodeResponse(@NotNull HttpResponse response) throws IOException;

    @NotNull HttpRequest decodeRequest(@NotNull InputStream in) throws IOException;

    @NotNull HttpResponse decodeResponse(@NotNull InputStream in) throws IOException;
}
