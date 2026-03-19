package codes.matheus.codec.http1_1;

import codes.matheus.body.HttpBody;
import codes.matheus.element.HttpStatus;
import codes.matheus.element.response.HttpResponse;
import codes.matheus.header.HttpHeader;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Optional;

final class HttpResponse1_1 {
    public byte[] encode(@NotNull HttpResponse response) throws IOException {
        @NotNull ByteArrayOutputStream out = new ByteArrayOutputStream();

        out.write((response.getVersion() + " " + response.getStatus().getCode() + " " + response.getStatus() + "\r\n").getBytes());
        for (@NotNull HttpHeader header : response.getHeaders().allHeaders()) {
            out.write((header + "\r\n").getBytes());
        }
        out.write("\r\n".getBytes());

        if (response.hasBody()) {
            out.write(response.getBody().asBytes());
        }
        return out.toByteArray();
    }

    public @NotNull HttpResponse decode(@NotNull InputStream in) throws IOException {
        @NotNull BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        @NotNull String[] responseLine = reader.readLine().split(" ", 3);
        @NotNull HttpVersion version = HttpVersion.ofString(responseLine[0]);
        @NotNull HttpStatus status = HttpStatus.fromCode(Integer.parseInt(responseLine[1]));

        @NotNull HttpHeaders headers = HttpHeaders.newEmptyHeaders();
        @NotNull String line;
        while (!(line = reader.readLine()).isEmpty()) {
            @NotNull String[] parts  = line.split(":", 2);
            @NotNull String key      = parts[0].trim();
            @NotNull String rawValue = parts[1].trim();

            if (HttpUtils.headersExceptions.contains(key.toLowerCase())) {
                headers.add(key, rawValue);
            } else {
                for (String value : rawValue.split(",")) {
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

        return HttpResponse.create(version, status, headers, body);
    }
}
