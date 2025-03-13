package com.easybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests) ->
                        requests.requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
                                .requestMatchers("/notices", "/contacts", "/register").permitAll()
                );
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }

    /*
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            /*
            Approach 1 withDefaultPasswordEncoder
            UserDetails admin = User.withDefaultPasswordEncoder()
                    .username("admin")
                    .password("admin")
                    .authorities("admin")
                    .build();
            UserDetails user = User.withDefaultPasswordEncoder()
                    .username("user")
                    .password("user")
                    .authorities("read")
                    .build();

      //        Approach 2 NoOpPasswordEncoder
            UserDetails admin = User.withUsername("admin")
                    .password("admin")
                    .authorities("admin")
                    .build();
            UserDetails user = User.withUsername("user")
                    .password("user")
                    .authorities("read")
                    .build();

            return new InMemoryUserDetailsManager(admin, user);
        }
    */
/*
    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
