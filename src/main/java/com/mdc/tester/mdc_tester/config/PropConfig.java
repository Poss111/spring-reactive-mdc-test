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
            "traceId",
            () -> MDC.get("traceId"),
            (path) -> {
                logger.debug("Setting MDC context map: {}", path);
                if (path == null) {
                    logger.debug("MDC context map is null");
                    return;
                }
                MDC.put("traceId", path);
            },
            () -> MDC.remove("traceId")
        );
        ContextRegistry.getInstance().registerThreadLocalAccessor(
            "spanId",
            () -> MDC.get("spanId"),
            (path) -> {
                logger.debug("Setting MDC context map: {}", path);
                if (path == null) {
                    logger.debug("MDC context map is null");
                    return;
                }
                MDC.put("spanId", path);
            },
            () -> MDC.remove("spanId")
        );
    }
}
