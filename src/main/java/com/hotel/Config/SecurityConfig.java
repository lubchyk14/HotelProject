package com.hotel.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder =User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("Olga").password("123").roles("MANAGER"))
                .withUser(userBuilder.username("Dana").password("123").roles("USER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home").hasAnyRole("MANAGER","USER")
                .antMatchers("/manager/**").hasRole("MANAGER")
                .antMatchers("/user/**").hasAnyRole("MANAGER","USER")
//                .anyRequest()
//                .authenticated()
                .and()
                .formLogin()
                    .loginPage("/loginPage")
                    .loginProcessingUrl("/authenticateUser")
                    .permitAll()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDenied")
                .and()
                    .logout()
                    .permitAll();

    }
}
