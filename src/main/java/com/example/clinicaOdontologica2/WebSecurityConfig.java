package com.example.clinicaOdontologica2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html").hasRole("USER")
                .antMatchers("/turnos.html").hasRole("USER")

                .antMatchers("/alta-pacientes.html").hasRole("ADMIN")
                .antMatchers("/listPacientes.html").hasRole("ADMIN")
                .antMatchers("/alta-odontologos.html").hasRole("ADMIN")
                .antMatchers("/odontologos.html").hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .and()
                .logout();
    }
}
