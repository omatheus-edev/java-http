package codes.matheus.codec.http1_1;

import codes.matheus.body.HttpBody;
import codes.matheus.element.request.HttpRequest;
import codes.matheus.element.request.RequestLine;
import codes.matheus.header.HttpHeader;
import codes.matheus.header.HttpHeaders;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Optional;

final class HttpRequest1_1 {
    public byte[] encode(@NotNull HttpRequest request) throws IOException {
        @NotNull ByteArrayOutputStream out = new ByteArrayOutputStream();

        out.write((request.getRequestLine() + "\r\n").getBytes());
        for (@NotNull HttpHeader header : request.getHeaders().allHeaders()) {
            out.write((header + "\r\n").getBytes());
        }
        out.write("\r\n".getBytes());

        if (request.hasBody()) {
            out.write(request.getBody().asBytes());
        }
        return out.toByteArray();
    }

    public @NotNull HttpRequest decode(@NotNull InputStream in) throws IOException {
        @NotNull BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        @NotNull RequestLine requestLine = RequestLine.parse(reader.readLine());
        @NotNull HttpHeaders headers = HttpHeaders.newEmptyHeaders();
        @NotNull String line;
        while (!(line = reader.readLine()).isEmpty()) {
            @NotNull String[] parts = line.split(":", 2);
            @NotNull String key = parts[0].trim();
            @NotNull String rawValue = parts[1].trim();

            if (HttpUtils.headersExceptions.contains(key)) {
                headers.add(key, rawValue);
            } else {
                for (@NotNull String value : rawValue.split(",")) {
                    headers.add(key, value.trim());
                }
            }
        }

        @Nullable HttpBody body = null;
        @NotNull Optional<String> contentLength = headers.first(HttpHeaders.Names.CONTENT_LENGTH);
        if (contentLength.isPresent()) {
            int length = Integer.parseInt(contentLength.get());
            char[] buffer = new char[length];
            reader.read(buffer, 0, length);
            body = HttpBody.create(new String(buffer));
        }
        return HttpRequest.create(requestLine, headers, body);
    }
}
