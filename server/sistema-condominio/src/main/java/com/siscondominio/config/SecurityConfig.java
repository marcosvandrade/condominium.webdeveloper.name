package com.siscondominio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        //TODO --> buscar usario no banco de dados
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user123").roles("USER") // noop - use NoOpPasswordEncoder since PasswordEncoder is built as a DelegatingPasswordEncoder
                .and()
                .withUser("admin").password("{noop}admin123").roles("USER","ADMIN");                
    }
}