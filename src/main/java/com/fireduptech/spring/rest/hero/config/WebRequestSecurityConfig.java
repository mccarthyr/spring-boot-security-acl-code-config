package com.fireduptech.spring.rest.hero.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import com.fireduptech.spring.rest.hero.security.MyRestAuthenticationEntryPoint;
import com.fireduptech.spring.rest.hero.security.MyAuthenticationSuccessHandler;
import com.fireduptech.spring.rest.hero.security.MyAuthenticationFailureHandler;
import com.fireduptech.spring.rest.hero.security.MyLogoutSuccessHandler;


@Configuration
@EnableWebSecurity
public class WebRequestSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    MyRestAuthenticationEntryPoint myRestAuthenticationEntryPoint;

    @Autowired
    MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    MyLogoutSuccessHandler myLogoutSuccessHandler;


    @Override
    protected void configure( HttpSecurity http ) throws Exception {

        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and().formLogin().successHandler( myAuthenticationSuccessHandler )
                .and().formLogin().failureHandler( myAuthenticationFailureHandler )
                .and().logout().logoutSuccessHandler( myLogoutSuccessHandler )
                .and().logout().deleteCookies( "JSESSIONID" )
                .and().exceptionHandling().authenticationEntryPoint( myRestAuthenticationEntryPoint );

    }

}
