package com.mdc.tester.mdc_tester.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/mock")
public class MockController {

    private static final Logger logger = LoggerFactory.getLogger(MockController.class);

    @GetMapping("/health")
    public Mono<ResponseEntity<Map<String, Object>>> health() {
        logger.info("Health check endpoint called");
        
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("service", "mdc-tester");
        
        return Mono.just(ResponseEntity.ok(response));
    }

    @GetMapping("/users/{id}")
    public Mono<ResponseEntity<Map<String, Object>>> getUser(@PathVariable Long id) {
        logger.info("Get user endpoint called with id: {}", id);
        
        Map<String, Object> user = new HashMap<>();
        user.put("id", id);
        user.put("name", "Mock User " + id);
        user.put("email", "user" + id + "@example.com");
        user.put("createdAt", LocalDateTime.now().toString());
        
        return Mono.just(ResponseEntity.ok(user));
    }

    @PostMapping("/users")
    public Mono<ResponseEntity<Map<String, Object>>> createUser(@RequestBody Map<String, Object> userRequest) {
        logger.info("Create user endpoint called with request: {}", userRequest);
        
        Map<String, Object> response = new HashMap<>();
        response.put("id", System.currentTimeMillis());
        response.put("name", userRequest.get("name"));
        response.put("email", userRequest.get("email"));
        response.put("createdAt", LocalDateTime.now().toString());
        response.put("message", "User created successfully");
        
        return Mono.just(ResponseEntity.ok(response));
    }

    @GetMapping("/data")
    public Mono<ResponseEntity<Map<String, Object>>> getMockData() {
        return Mono.just("workflow-start")
                    .doOnNext(step -> logger.info("Step 1: Workflow initiated - {}", step))
                    .flatMap(step -> processDataValidation(step))
                    .doOnNext(step -> logger.info("Step 2: Data validation completed - {}", step))
                    .flatMap(step -> fetchExternalData(step))
                    .doOnNext(step -> logger.info("Step 3: External data fetched - {}", step))
                    .flatMap(step -> transformData(step))
                    .doOnNext(step -> logger.info("Step 4: Data transformation completed - {}", step))
                    .flatMap(step -> enrichData(step))
                    .doOnNext(step -> logger.info("Step 5: Data enrichment completed - {}", step))
                    .flatMap(step -> finalizeResponse(step))
                    .doOnNext(step -> logger.info("Step 6: Response finalized - {}", step))
                    .map(step -> {
                        logger.info("Workflow completed successfully");
                        
                        Map<String, Object> data = new HashMap<>();
                        data.put("workflowId", System.currentTimeMillis());
                        data.put("steps", java.util.Arrays.asList("validation", "fetch", "transform", "enrich", "finalize"));
                        data.put("step", step);
                        data.put("status", "completed");
                        data.put("timestamp", LocalDateTime.now().toString());
                        data.put("message", "Mock workflow executed successfully");
                        
                        return ResponseEntity.ok(data);
                    });
    }

    private Mono<String> processDataValidation(String step) {
        logger.info("Processing data validation for step: {}", step);
        return Mono.just("validation-complete")
                .delayElement(java.time.Duration.ofMillis(100))
                .doOnNext(result -> logger.info("Data validation result: {}", result));
    }

    private Mono<String> fetchExternalData(String step) {
        logger.info("Fetching external data for step: {}", step);
        return Mono.just("external-data-fetched")
                .delayElement(java.time.Duration.ofMillis(150))
                .doOnNext(result -> logger.info("External data fetch result: {}", result));
    }

    private Mono<String> transformData(String step) {
        logger.info("Transforming data for step: {}", step);
        return Mono.just("transformation-complete")
                .delayElement(java.time.Duration.ofMillis(200))
                .doOnNext(result -> logger.info("Data transformation result: {}", result));
    }

    private Mono<String> enrichData(String step) {
        logger.info("Enriching data for step: {}", step);
        return Mono.just("enrichment-complete")
                .delayElement(java.time.Duration.ofMillis(100))
                .doOnNext(result -> logger.info("Data enrichment result: {}", result));
    }

    private Mono<String> finalizeResponse(String step) {
        logger.info("Finalizing response for step: {}", step);
        return Mono.just("finalization-complete")
                .delayElement(java.time.Duration.ofMillis(50))
                .doOnNext(result -> logger.info("Response finalization result: {}", result));
    }
}
