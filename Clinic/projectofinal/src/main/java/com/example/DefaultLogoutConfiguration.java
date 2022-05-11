package com.example;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

public class DefaultLogoutConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .addLogoutHandler(new SecurityContextLogoutHandler())
                );
    }
}
