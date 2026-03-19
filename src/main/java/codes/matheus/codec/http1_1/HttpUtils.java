package codes.matheus.codec.http1_1;

import codes.matheus.header.HttpHeaders;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

final class HttpUtils {
    private HttpUtils() {
        throw new UnsupportedOperationException("this class don't be instantiated");
    }

    static final @NotNull Set<String> headersExceptions = Set.of(
            HttpHeaders.Names.SET_COOKIE,
            HttpHeaders.Names.DATE,
            HttpHeaders.Names.EXPIRES,
            HttpHeaders.Names.LAST_MODIFIED,
            HttpHeaders.Names.IF_MODIFIED_SINCE,
            HttpHeaders.Names.IF_UNMODIFIED_SINCE,
            HttpHeaders.Names.RETRY_AFTER
    );
}
