package com.lin.msa.service1;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests()
			.anyRequest().permitAll()
            .and()
            	.oauth2ResourceServer().jwt();
    }
 
    /*
    @Bean
	CorsConfigurationSource corsConfigurationSource() {
		final CorsConfiguration configuration = new CorsConfiguration();

		//configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
		//configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));

		// NOTE: setAllowCredentials(true) is important,
		// otherwise, the value of the 'Access-Control-Allow-Origin' header in the response
		// must not be the wildcard '*' when the request's credentials mode is 'include'.
		//configuration.setAllowCredentials(true);

		// NOTE: setAllowedHeaders is important!
		// Without it, OPTIONS preflight request will fail with 403 Invalid CORS request
		// "ajax" Header is for jQuery's ajax request 
		configuration.setAllowedHeaders(
				Arrays.asList("Authorization", "Accept", "Cache-Control", "Content-Type", "Origin", "ajax", "x-csrf-token", "x-requested-with"));

		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
	*/
}