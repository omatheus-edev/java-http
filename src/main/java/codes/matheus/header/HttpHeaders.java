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

    static @NotNull HttpHeaders newHeaders(@NotNull String key, @NotNull String @NotNull ... values) {
        return new HttpHeadersImpl().add(key, values);
    }

    @NotNull HttpHeaders add(@NotNull String key, @NotNull String value);

    @NotNull HttpHeaders add(@NotNull String key, @NotNull String @NotNull ... values);

    void remove(@NotNull String key);

    @NotNull String get(@NotNull String key);

    @NotNull HttpHeaders set(@NotNull String key, @NotNull String value);

    @NotNull HttpHeaders set(@NotNull String key, @NotNull String @NotNull ... values);

    @NotNull Optional<String> first(@NotNull String key);

    @NotNull List<String> all(@NotNull String key);

    @NotNull List<HttpHeader> allHeaders();

    boolean contains(@NotNull String key);

    class Names {
        private Names() {
            throw new UnsupportedOperationException("this class cannot be instantiated");
        }

        public static final @NotNull String ACCEPT = "Accept";
        public static final @NotNull String ACCEPT_CH = "Accept-CH";
        public static final @NotNull String ACCEPT_ENCODING = "Accept-Encoding";
        public static final @NotNull String ACCEPT_LANGUAGE = "Accept-Language";
        public static final @NotNull String ACCEPT_PATCH = "Accept-Patch";
        public static final @NotNull String ACCEPT_POST = "Accept-Post";
        public static final @NotNull String ACCEPT_RANGES = "Accept-Ranges";
        public static final @NotNull String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
        public static final @NotNull String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
        public static final @NotNull String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
        public static final @NotNull String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
        public static final @NotNull String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
        public static final @NotNull String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
        public static final @NotNull String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
        public static final @NotNull String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
        public static final @NotNull String ACTIVATE_STORAGE_ACCESS = "Activate-Storage-Access";
        public static final @NotNull String AGE = "Age";
        public static final @NotNull String ALLOW = "Allow";
        public static final @NotNull String ALT_SVC = "Alt-Svc";
        public static final @NotNull String ALT_USED = "Alt-Used";
        public static final @NotNull String AUTHORIZATION = "Authorization";
        public static final @NotNull String AVAILABLE_DICTIONARY = "Available-Dictionary";
        public static final @NotNull String CACHE_CONTROL = "Cache-Control";
        public static final @NotNull String CLEAR_SITE_DATA = "Clear-Site-Data";
        public static final @NotNull String CONNECTION = "Connection";
        public static final @NotNull String CONTENT_DIGEST = "Content-Digest";
        public static final @NotNull String CONTENT_DISPOSITION = "Content-Disposition";
        public static final @NotNull String CONTENT_ENCODING = "Content-Encoding";
        public static final @NotNull String CONTENT_LANGUAGE = "Content-Language";
        public static final @NotNull String CONTENT_LENGTH = "Content-Length";
        public static final @NotNull String CONTENT_LOCATION = "Content-Location";
        public static final @NotNull String CONTENT_RANGE = "Content-Range";
        public static final @NotNull String CONTENT_SECURITY_POLICY = "Content-Security-Policy";
        public static final @NotNull String CONTENT_SECURITY_POLICY_REPORT_ONLY = "Content-Security-Policy-Report-Only";
        public static final @NotNull String CONTENT_TYPE = "Content-Type";
        public static final @NotNull String COOKIE = "Cookie";
        public static final @NotNull String CRITICAL_CH = "Critical-CH";
        public static final @NotNull String CROSS_ORIGIN_EMBEDDER_POLICY = "Cross-Origin-Embedder-Policy";
        public static final @NotNull String CROSS_ORIGIN_EMBEDDER_POLICY_REPORT_ONLY = "Cross-Origin-Embedder-Policy-Report-Only";
        public static final @NotNull String CROSS_ORIGIN_OPENER_POLICY = "Cross-Origin-Opener-Policy";
        public static final @NotNull String CROSS_ORIGIN_RESOURCE_POLICY = "Cross-Origin-Resource-Policy";
        public static final @NotNull String DATE = "Date";
        public static final @NotNull String DICTIONARY_ID = "Dictionary-ID";
        public static final @NotNull String EARLY_DATA = "Early-Data";
        public static final @NotNull String ECT = "ECT";
        public static final @NotNull String ETAG = "ETag";
        public static final @NotNull String EXPECT = "Expect";
        public static final @NotNull String EXPIRES = "Expires";
        public static final @NotNull String FORWARDED = "Forwarded";
        public static final @NotNull String FROM = "From";
        public static final @NotNull String HOST = "Host";
        public static final @NotNull String IDEMPOTENCY_KEY = "Idempotency-Key";
        public static final @NotNull String IF_MATCH = "If-Match";
        public static final @NotNull String IF_MODIFIED_SINCE = "If-Modified-Since";
        public static final @NotNull String IF_NONE_MATCH = "If-None-Match";
        public static final @NotNull String IF_RANGE = "If-Range";
        public static final @NotNull String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
        public static final @NotNull String INTEGRITY_POLICY = "Integrity-Policy";
        public static final @NotNull String INTEGRITY_POLICY_REPORT_ONLY = "Integrity-Policy-Report-Only";
        public static final @NotNull String KEEP_ALIVE = "Keep-Alive";
        public static final @NotNull String LAST_MODIFIED = "Last-Modified";
        public static final @NotNull String LINK = "Link";
        public static final @NotNull String LOCATION = "Location";
        public static final @NotNull String MAX_FORWARDS = "Max-Forwards";
        public static final @NotNull String NEL = "NEL";
        public static final @NotNull String NO_VARY_SEARCH = "No-Vary-Search";
        public static final @NotNull String ORIGIN = "Origin";
        public static final @NotNull String ORIGIN_AGENT_CLUSTER = "Origin-Agent-Cluster";
        public static final @NotNull String PERMISSIONS_POLICY = "Permissions-Policy";
        public static final @NotNull String PREFER = "Prefer";
        public static final @NotNull String PREFERENCE_APPLIED = "Preference-Applied";
        public static final @NotNull String PRIORITY = "Priority";
        public static final @NotNull String PROXY_AUTHENTICATE = "Proxy-Authenticate";
        public static final @NotNull String PROXY_AUTHORIZATION = "Proxy-Authorization";
        public static final @NotNull String RANGE = "Range";
        public static final @NotNull String REFERER = "Referer";
        public static final @NotNull String REFERRER_POLICY = "Referrer-Policy";
        public static final @NotNull String REFRESH = "Refresh";
        public static final @NotNull String REPORTING_ENDPOINTS = "Reporting-Endpoints";
        public static final @NotNull String REPR_DIGEST = "Repr-Digest";
        public static final @NotNull String RETRY_AFTER = "Retry-After";
        public static final @NotNull String RTT = "RTT";
        public static final @NotNull String SAVE_DATA = "Save-Data";
        public static final @NotNull String SEC_CH_PREFERS_COLOR_SCHEME = "Sec-CH-Prefers-Color-Scheme";
        public static final @NotNull String SEC_CH_PREFERS_REDUCED_MOTION = "Sec-CH-Prefers-Reduced-Motion";
        public static final @NotNull String SEC_CH_PREFERS_REDUCED_TRANSPARENCY = "Sec-CH-Prefers-Reduced-Transparency";
        public static final @NotNull String SEC_CH_UA = "Sec-CH-UA";
        public static final @NotNull String SEC_CH_UA_ARCH = "Sec-CH-UA-Arch";
        public static final @NotNull String SEC_CH_UA_BITNESS = "Sec-CH-UA-Bitness";
        public static final @NotNull String SEC_CH_UA_FORM_FACTORS = "Sec-CH-UA-Form-Factors";
        public static final @NotNull String SEC_CH_UA_FULL_VERSION_LIST = "Sec-CH-UA-Full-Version-List";
        public static final @NotNull String SEC_CH_UA_MOBILE = "Sec-CH-UA-Mobile";
        public static final @NotNull String SEC_CH_UA_MODEL = "Sec-CH-UA-Model";
        public static final @NotNull String SEC_CH_UA_PLATFORM = "Sec-CH-UA-Platform";
        public static final @NotNull String SEC_CH_UA_PLATFORM_VERSION = "Sec-CH-UA-Platform-Version";
        public static final @NotNull String SEC_CH_UA_WOW64 = "Sec-CH-UA-WoW64";
        public static final @NotNull String SEC_CH_VIEWPORT_HEIGHT = "Sec-CH-Viewport-Height";
        public static final @NotNull String SEC_CH_VIEWPORT_WIDTH = "Sec-CH-Viewport-Width";
        public static final @NotNull String SEC_CH_WIDTH = "Sec-CH-Width";
        public static final @NotNull String SEC_FETCH_DEST = "Sec-Fetch-Dest";
        public static final @NotNull String SEC_FETCH_MODE = "Sec-Fetch-Mode";
        public static final @NotNull String SEC_FETCH_SITE = "Sec-Fetch-Site";
        public static final @NotNull String SEC_FETCH_STORAGE_ACCESS = "Sec-Fetch-Storage-Access";
        public static final @NotNull String SEC_FETCH_USER = "Sec-Fetch-User";
        public static final @NotNull String SEC_GPC = "Sec-GPC";
        public static final @NotNull String SEC_PURPOSE = "Sec-Purpose";
        public static final @NotNull String SEC_WEBSOCKET_ACCEPT = "Sec-WebSocket-Accept";
        public static final @NotNull String SEC_WEBSOCKET_EXTENSIONS = "Sec-WebSocket-Extensions";
        public static final @NotNull String SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
        public static final @NotNull String SEC_WEBSOCKET_PROTOCOL = "Sec-WebSocket-Protocol";
        public static final @NotNull String SEC_WEBSOCKET_VERSION = "Sec-WebSocket-Version";
        public static final @NotNull String SERVER = "Server";
        public static final @NotNull String SERVER_TIMING = "Server-Timing";
        public static final @NotNull String SERVICE_WORKER = "Service-Worker";
        public static final @NotNull String SERVICE_WORKER_ALLOWED = "Service-Worker-Allowed";
        public static final @NotNull String SERVICE_WORKER_NAVIGATION_PRELOAD = "Service-Worker-Navigation-Preload";
        public static final @NotNull String SET_COOKIE = "Set-Cookie";
        public static final @NotNull String SET_LOGIN = "Set-Login";
        public static final @NotNull String SOURCE_MAP = "SourceMap";
        public static final @NotNull String SPECULATION_RULES = "Speculation-Rules";
        public static final @NotNull String STRICT_TRANSPORT_SECURITY = "Strict-Transport-Security";
        public static final @NotNull String SUPPORTS_LOADING_MODE = "Supports-Loading-Mode";
        public static final @NotNull String TE = "TE";
        public static final @NotNull String TIMING_ALLOW_ORIGIN = "Timing-Allow-Origin";
        public static final @NotNull String TRAILER = "Trailer";
        public static final @NotNull String TRANSFER_ENCODING = "Transfer-Encoding";
        public static final @NotNull String UPGRADE = "Upgrade";
        public static final @NotNull String UPGRADE_INSECURE_REQUESTS = "Upgrade-Insecure-Requests";
        public static final @NotNull String USE_AS_DICTIONARY = "Use-As-Dictionary";
        public static final @NotNull String USER_AGENT = "User-Agent";
        public static final @NotNull String VARY = "Vary";
        public static final @NotNull String VIA = "Via";
        public static final @NotNull String WANT_CONTENT_DIGEST = "Want-Content-Digest";
        public static final @NotNull String WANT_REPR_DIGEST = "Want-Repr-Digest";
        public static final @NotNull String WWW_AUTHENTICATE = "WWW-Authenticate";
        public static final @NotNull String X_CONTENT_TYPE_OPTIONS = "X-Content-Type-Options";
        public static final @NotNull String X_DNS_PREFETCH_CONTROL = "X-DNS-Prefetch-Control";
        public static final @NotNull String X_FORWARDED_FOR = "X-Forwarded-For";
        public static final @NotNull String X_FORWARDED_HOST = "X-Forwarded-Host";
        public static final @NotNull String X_FORWARDED_PROTO = "X-Forwarded-Proto";
        public static final @NotNull String X_FRAME_OPTIONS = "X-Frame-Options";
        public static final @NotNull String X_PERMITTED_CROSS_DOMAIN_POLICIES = "X-Permitted-Cross-Domain-Policies";
        public static final @NotNull String X_POWERED_BY = "X-Powered-By";
        public static final @NotNull String X_ROBOTS_TAG = "X-Robots-Tag";
        public static final @NotNull String X_XSS_PROTECTION = "X-XSS-Protection";
    }

    class Values {
        private Values() {
            throw new UnsupportedOperationException("this class cannot be instantiated");
        }

        // Content-Type
        public static final @NotNull String APPLICATION_JSON = "application/json";
        public static final @NotNull String APPLICATION_XML = "application/xml";
        public static final @NotNull String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";
        public static final @NotNull String APPLICATION_OCTET_STREAM = "application/octet-stream";
        public static final @NotNull String APPLICATION_PDF = "application/pdf";
        public static final @NotNull String APPLICATION_ZIP = "application/zip";
        public static final @NotNull String MULTIPART_FORM_DATA = "multipart/form-data";
        public static final @NotNull String TEXT_HTML = "text/html; charset=utf-8";
        public static final @NotNull String TEXT_PLAIN = "text/plain; charset=utf-8";
        public static final @NotNull String TEXT_CSS = "text/css";
        public static final @NotNull String TEXT_JAVASCRIPT = "text/javascript";
        public static final @NotNull String TEXT_XML = "text/xml";
        public static final @NotNull String IMAGE_PNG = "image/png";
        public static final @NotNull String IMAGE_JPEG = "image/jpeg";
        public static final @NotNull String IMAGE_GIF = "image/gif";
        public static final @NotNull String IMAGE_SVG = "image/svg+xml";
        public static final @NotNull String IMAGE_WEBP = "image/webp";

        // Connection
        public static final @NotNull String KEEP_ALIVE = "keep-alive";
        public static final @NotNull String CLOSE = "close";
        public static final @NotNull String UPGRADE = "Upgrade";

        // Transfer-Encoding / Content=Encoding
        public static final @NotNull String CHUNKED = "chunked";
        public static final @NotNull String GZIP = "gzip";
        public static final @NotNull String DEFLATE = "deflate";
        public static final @NotNull String BR = "br";
        public static final @NotNull String IDENTITY = "identity";

        // Cache-Control
        public static final @NotNull String NO_CACHE = "no-cache";
        public static final @NotNull String NO_STORE = "no-store";
        public static final @NotNull String NO_TRANSFORM = "no-transform";
        public static final @NotNull String ONLY_IF_CACHED = "only-if-cached";
        public static final @NotNull String MUST_REVALIDATE = "must-revalidate";
        public static final @NotNull String MUST_UNDERSTAND = "must-understand";
        public static final @NotNull String PRIVATE = "private";
        public static final @NotNull String PUBLIC = "public";
        public static final @NotNull String IMMUTABLE = "immutable";

        // All
        public static final @NotNull String ACCEPT_ALL = "*/*";
        public static final @NotNull String ENCODING_ALL = "*";
        public static final @NotNull String CORS_ALL = "*";

        // Cross-Origin
        public static final @NotNull String SAME_ORIGIN = "same-origin";
        public static final @NotNull String SAME_SITE = "same-site";
        public static final @NotNull String CROSS_ORIGIN = "cross-origin";

        // Referrer-Policy
        public static final @NotNull String NO_REFERRER = "no-referrer";
        public static final @NotNull String NO_REFERRER_WHEN_DOWNGRADE = "no-referrer-when-downgrade";
        public static final @NotNull String STRICT_ORIGIN = "strict-origin";
        public static final @NotNull String STRICT_ORIGIN_WHEN_CROSS_ORIGIN = "strict-origin-when-cross-origin";
        public static final @NotNull String UNSAFE_URL = "unsafe-url";
        public static final @NotNull String ORIGIN = "origin";

        // TE
        public static final @NotNull String TRAILERS = "trailers";

        // Upgrade
        public static final @NotNull String WEBSOCKET = "websocket";
        public static final @NotNull String HTTP_2 = "h2";
        public static final @NotNull String HTTP_2_CLEARTEXT = "h2c";

        // Sec-Fetch-Mode
        public static final @NotNull String NAVIGATE = "navigate";
        public static final @NotNull String CORS = "cors";
        public static final @NotNull String NO_CORS = "no-cors";
        public static final @NotNull String WEBSOCKET_MODE = "websocket";

        // Sec-Fetch-Dest
        public static final @NotNull String DOCUMENT = "document";
        public static final @NotNull String SCRIPT = "script";
        public static final @NotNull String STYLE = "style";
        public static final @NotNull String IMAGE = "image";
        public static final @NotNull String FONT = "font";
        public static final @NotNull String WORKER = "worker";
        public static final @NotNull String EMPTY = "empty";

        // Prefer
        public static final @NotNull String RESPOND_ASYNC = "respond-async";
        public static final @NotNull String RETURN_MINIMAL = "return=minimal";
        public static final @NotNull String RETURN_REPRESENTATION = "return=representation";

        // X-Frame-Options
        public static final @NotNull String DENY = "DENY";
        public static final @NotNull String SAMEORIGIN = "SAMEORIGIN";

        // X-Content-Type-Options
        public static final @NotNull String NOSNIFF = "nosniff";
    }
}
