package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .inMemoryAuthentication()
            .withUser("user")
            .password("user")
            .authorities("ROLE_USER")
            .and()
            .withUser("root")
            .password("root")
            .authorities("ROLE_ADMIN");


    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/products")
                .hasAnyRole("ADMIN")
                .antMatchers( HttpMethod.GET,"/products")
                .hasAnyRole("USER","ADMIN")
                .antMatchers("/", "/**")
                .access("permitAll")
                .antMatchers("/restaurants")
                .hasAnyRole("ADMIN")
                .and()
                .formLogin();
    }
}



