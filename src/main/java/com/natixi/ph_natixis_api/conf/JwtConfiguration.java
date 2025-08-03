package com.natixi.ph_natixis_api.conf;

import com.natixi.ph_natixis_api.model.JwtProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JwtConfiguration {

    private static final String[] SWAGGER = {
            "/v2/api-docs", "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
            "/configuration/security", "/swagger-ui.html", "/webjars/**",
            "/v3/api-docs/**", "/swagger-ui/**"
    };

    private final JwtProperties jwtProperties;

    public JwtConfiguration(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> {})
                .addFilterAfter(new JwtSecurity(jwtProperties), UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(SWAGGER).permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
