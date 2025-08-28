package com.mdc.tester.mdc_tester.config;

import org.springframework.context.annotation.Configuration;

import io.micrometer.context.ContextRegistry;
import org.slf4j.MDC;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class PropConfig {

    private static final Logger logger = LoggerFactory.getLogger(PropConfig.class);

    @PostConstruct
    public void registerMDC() {
        ContextRegistry.getInstance().registerThreadLocalAccessor(
            "path",
            () -> MDC.get("path"),
            (path) -> {
                logger.debug("Setting MDC context map: {}", path);
                if (path == null) {
                    logger.debug("MDC path is null");
                    return;
                }
                MDC.put("path", path);
            },
            () -> MDC.remove("path")
        );
        ContextRegistry.getInstance().registerThreadLocalAccessor(
            "host",
            () -> MDC.get("host"),
            (host) -> {
                logger.debug("Setting MDC context map host: {}", host);
                if (host == null) {
                    logger.debug("MDC context map host is null");
                    return;
                }
                MDC.put("host", host);
            },
            () -> MDC.remove("host")
        );
        ContextRegistry.getInstance().registerThreadLocalAccessor(
            "method",
            () -> MDC.get("method"),
            (method) -> {
                logger.debug("Setting MDC context map method: {}", method);
                if (method == null) {
                    logger.debug("MDC context map method is null");
                    return;
                }
                MDC.put("method", method);
            },
            () -> MDC.remove("method")
        );
        // ContextRegistry.getInstance().registerThreadLocalAccessor(
        //     "traceId",
        //     () -> {
        //         String traceId = MDC.get("traceId");
        //         logger.info("Getting MDC context map traceId: {}", traceId);
        //         return traceId;
        //     },
        //     (traceId) -> {
        //         logger.debug("Setting MDC context map traceId: {}", traceId);
        //         if (traceId == null) {
        //             logger.debug("MDC context map traceId is null");
        //             return;
        //         }
        //         MDC.put("traceId", traceId);
        //     },
        //     () -> MDC.remove("traceId")
        // );
        // ContextRegistry.getInstance().registerThreadLocalAccessor(
        //     "spanId",
        //     () -> {
        //         String spanId = MDC.get("spanId");
        //         logger.info("Getting MDC context map spanId: {}", spanId);
        //         return spanId;
        //     },
        //     (spanId) -> {
        //         logger.debug("Setting MDC context map: {}", spanId);
        //         if (spanId == null) {
        //             logger.debug("MDC context map is null");
        //             return;
        //         }
        //         MDC.put("spanId", spanId);
        //     },
        //     () -> MDC.remove("spanId")
        // );
    }
}
