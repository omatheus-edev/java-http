package codes.matheus.http1_1;

import codes.matheus.body.HttpBody;
import codes.matheus.codec.HttpCodec;
import codes.matheus.codec.http1_1.HttpCodec1_1;
import codes.matheus.element.HttpStatus;
import codes.matheus.element.Method;
import codes.matheus.element.request.HttpRequest;
import codes.matheus.element.response.HttpResponse;
import codes.matheus.header.HttpHeaders;
import codes.matheus.version.HttpVersion;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

final class HttpTest {
    private final @NotNull HttpCodec codec = new HttpCodec1_1();
    private @NotNull InputStream toStream(@NotNull String raw) {
        return new ByteArrayInputStream(raw.getBytes());
    }

    @Nested
    final class Requests {
        @Test
        void encodeRequest() throws IOException {
            @NotNull String body = "{\"name\": \"john\"}";
            @NotNull HttpRequest request = HttpRequest.builder()
                    .post("/users")
                    .header(HttpHeaders.Names.HOST, "localhost:8080")
                    .header(HttpHeaders.Names.CONTENT_TYPE, HttpHeaders.Values.APPLICATION_JSON)
                    .body(body)
                    .build();

            @NotNull String encoded = new String(codec.encodeRequest(request));
            @NotNull String expected = "POST /users HTTP/1.1\r\nHost: localhost:8080\r\nContent-Type: application/json\r\nContent-Length: " + body.length() + "\r\n\r\n" + body;

            assertTrue(encoded.startsWith("POST /users HTTP/1.1\r\n"));
            assertTrue(request.hasBody());
            assertEquals(expected, encoded);
        }

        @Test
        void decodeRequest() throws IOException {
            @NotNull String body = "{\"name\": \"john\"}";
            @NotNull String raw = "POST /users HTTP/1.1\r\nHost: localhost:8080\r\nContent-Type: application/json\r\nContent-Length: " + body.length() + "\r\n\r\n" + body;
            @NotNull HttpRequest request = codec.decodeRequest(toStream(raw));

            assertEquals(Method.POST, request.getMethod());
            assertEquals("/users", request.getPath());
            assertEquals(HttpVersion.V1_1, request.getVersion());
            assertEquals("localhost:8080", request.getHeaders().get(HttpHeaders.Names.HOST));
            assertTrue(request.hasBody());
            assertEquals(body, request.getBody().asString());
        }
    }

    @Nested
    final class Responses {
        @Test
        void encodeResponse() throws IOException {
            @NotNull HttpHeaders headers = HttpHeaders.newHeaders(HttpHeaders.Names.HOST, "localhost:8080")
                    .add(HttpHeaders.Names.ACCEPT, "bytes");
            @NotNull HttpResponse response = HttpResponse.create(HttpVersion.V1_1, HttpStatus.OK, headers, HttpBody.empty());

            @NotNull String encoded = new String(codec.encodeResponse(response));
            @NotNull String expected = "HTTP/1.1 200 OK\r\nHost: localhost:8080\r\nAccept: bytes\r\n\r\n";

            assertTrue(encoded.startsWith("HTTP/1.1 200 OK\r\n"));
            assertFalse(response.hasBody());
            assertEquals(expected, encoded);
        }

        @Test
        void decodeResponse() throws IOException {
            @NotNull String raw = "HTTP/1.1 200 OK\r\nHost: localhost:8080\r\nAccept: bytes\r\n\r\n";
            @NotNull HttpResponse response = codec.decodeResponse(toStream(raw));

            assertEquals(HttpVersion.V1_1, response.getVersion());
            assertEquals(HttpStatus.OK, response.getStatus());
            assertFalse(response.hasBody());
        }
    }
}
