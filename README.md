# msa
Spring Microservice Reference Implementation

## Journey
Keycloak  
password set wrongly, caused "address: ([("subsystem" => "metrics")]): java.lang.NullPointerException".  

Spring Cloud Gateway
The path are forward to the backend service. e.g. "/bin" -> "http://httpbin:80" will become "http://httpbin:80/bin"  

https://stackoverflow.com/questions/67268107/cannot-access-javax-servlet-filter-error-when-using-spring-security-with-sprin
Spring Cloud Gateway requires the Netty runtime provided by Spring Boot and Spring Webflux. It does not work in a traditional Servlet Container or when built as a WAR.  
Extending WebSecurityConfigurerAdapter is for servlet based applications.  
You should instead configure Spring Security for reactive applications.  

SpringSecurity is enabled when spring-boot-starter-security is included in pom.

Use CorsConfig to solve preflight 403 error

Cookie store in frontend, memory is the most secured option
https://wso2.com/blogs/thesource/securing-spas-best-practices/

Default preflight request will be sent only one, Access-Control-Max-Age will decide when it expiried.


