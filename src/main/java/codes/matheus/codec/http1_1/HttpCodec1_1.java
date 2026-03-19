package codes.matheus.codec.http1_1;

import codes.matheus.codec.HttpCodec;
import codes.matheus.element.request.HttpRequest;
import codes.matheus.element.response.HttpResponse;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

public final class HttpCodec1_1 implements HttpCodec {
    private final @NotNull HttpRequest1_1 req1_1 = new HttpRequest1_1();
    private final @NotNull HttpResponse1_1 resp1_1 = new HttpResponse1_1();

    @Override
    public @NotNull HttpVersion version() {
        return HttpVersion.V1_1;
    }

    @Override
    public byte[] encodeRequest(@NotNull HttpRequest request) throws IOException {
        return req1_1.encode(request);
    }

    @Override
    public byte[] encodeResponse(@NotNull HttpResponse response) throws IOException {
        return resp1_1.encode(response);
    }

    @Override
    public @NotNull HttpRequest decodeRequest(@NotNull InputStream in) throws IOException {
        return req1_1.decode(in);
    }

    @Override
    public @NotNull HttpResponse decodeResponse(@NotNull InputStream in) throws IOException {
        return resp1_1.decode(in);
    }
}
