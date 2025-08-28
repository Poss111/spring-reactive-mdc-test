# Testing out Spring MDC

## Guides

- https://github.com/pivovarit/articles/blob/4739753b3600319796588efc47cbb0309dcc129c/java-reactor-context-propagation/src/main/java/com/pivovarit/reactor/E4_ReactorContextMDCAutomatic.java#L22
- https://medium.com/@ia_taras/end-to-end-tracing-in-spring-webflux-with-mdc-8b39dc6b34bd

## Actual Output

```text
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.5)

{"@timestamp":"2025-08-27T19:57:46.348-0500","@version":"1","message":"Starting MdcTesterApplication using Java 21.0.6 with PID 23036 (/Users/poss/Projects/mdc-tester/build/classes/java/main started by poss in /Users/poss/Projects/mdc-tester)","logger_name":"com.mdc.tester.mdc_tester.MdcTesterApplication","thread_name":"restartedMain","level":"INFO","level_value":20000}
{"@timestamp":"2025-08-27T19:57:46.353-0500","@version":"1","message":"No active profile set, falling back to 1 default profile: \"default\"","logger_name":"com.mdc.tester.mdc_tester.MdcTesterApplication","thread_name":"restartedMain","level":"INFO","level_value":20000}
{"@timestamp":"2025-08-27T19:57:46.369-0500","@version":"1","message":"Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable","logger_name":"org.springframework.boot.devtools.env.DevToolsPropertyDefaultsPostProcessor","thread_name":"restartedMain","level":"INFO","level_value":20000}
{"@timestamp":"2025-08-27T19:57:46.369-0500","@version":"1","message":"For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'","logger_name":"org.springframework.boot.devtools.env.DevToolsPropertyDefaultsPostProcessor","thread_name":"restartedMain","level":"INFO","level_value":20000}
{"@timestamp":"2025-08-27T19:57:47.002-0500","@version":"1","message":"Exposing 1 endpoint beneath base path '/actuator'","logger_name":"org.springframework.boot.actuate.endpoint.web.EndpointLinksResolver","thread_name":"restartedMain","level":"INFO","level_value":20000}
{"@timestamp":"2025-08-27T19:57:47.124-0500","@version":"1","message":"LiveReload server is running on port 35729","logger_name":"org.springframework.boot.devtools.autoconfigure.OptionalLiveReloadServer","thread_name":"restartedMain","level":"INFO","level_value":20000}
{"@timestamp":"2025-08-27T19:57:47.183-0500","@version":"1","message":"Netty started on port 8080 (http)","logger_name":"org.springframework.boot.web.embedded.netty.NettyWebServer","thread_name":"restartedMain","level":"INFO","level_value":20000}
{"@timestamp":"2025-08-27T19:57:47.196-0500","@version":"1","message":"Started MdcTesterApplication in 1.116 seconds (process running for 1.426)","logger_name":"com.mdc.tester.mdc_tester.MdcTesterApplication","thread_name":"restartedMain","level":"INFO","level_value":20000}
{"@timestamp":"2025-08-27T19:57:49.557-0500","@version":"1","message":"Step 1: Workflow initiated - workflow-start","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"reactor-http-nio-2","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:49.558-0500","@version":"1","message":"Processing data validation for step: workflow-start","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"reactor-http-nio-2","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:49.661-0500","@version":"1","message":"Data validation result: validation-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-1","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:49.661-0500","@version":"1","message":"Step 2: Data validation completed - validation-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-1","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:49.661-0500","@version":"1","message":"Fetching external data for step: validation-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-1","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:49.817-0500","@version":"1","message":"External data fetch result: external-data-fetched","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-2","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:49.817-0500","@version":"1","message":"Step 3: External data fetched - external-data-fetched","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-2","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:49.817-0500","@version":"1","message":"Transforming data for step: external-data-fetched","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-2","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.023-0500","@version":"1","message":"Data transformation result: transformation-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-3","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.024-0500","@version":"1","message":"Step 4: Data transformation completed - transformation-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-3","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.024-0500","@version":"1","message":"Enriching data for step: transformation-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-3","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.130-0500","@version":"1","message":"Data enrichment result: enrichment-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-4","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.133-0500","@version":"1","message":"Step 5: Data enrichment completed - enrichment-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-4","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.134-0500","@version":"1","message":"Finalizing response for step: enrichment-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-4","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.188-0500","@version":"1","message":"Response finalization result: finalization-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-5","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.189-0500","@version":"1","message":"Step 6: Response finalized - finalization-complete","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-5","level":"INFO","level_value":20000,"path":"/api/mock/data"}
{"@timestamp":"2025-08-27T19:57:50.189-0500","@version":"1","message":"Workflow completed successfully","logger_name":"com.mdc.tester.mdc_tester.controller.MockController","thread_name":"parallel-5","level":"INFO","level_value":20000,"path":"/api/mock/data"}
```