# msa
Spring Microservice Reference Implementation

## Journey
Keycloak  
password set wrongly, caused "address: ([("subsystem" => "metrics")]): java.lang.NullPointerException".  

create react-app
https://scalac.io/blog/user-authentication-keycloak-1/
Major OIDC servers all provide client library, so it is the best choice to use verdor library instead of generic one
Thinking about that problem is good, but in reality it's easy to mitigate. You can make all keycloak specific logic in a single file so it's easy to change out. Plus how likely are things to change. If you spend weeks now to prevent something that might take hours years from now it may not be worth it
npm install -g create-react-app
create-react-app keycloak-react
npm start

	"react-router-dom": "^5.2.0",
    "keycloak-js": "15.0.2"

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


