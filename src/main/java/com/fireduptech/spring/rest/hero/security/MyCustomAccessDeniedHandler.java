package com.fireduptech.spring.rest.hero.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;


public class MyCustomAccessDeniedHandler implements AccessDeniedHandler {


    @Override
    public void handle( final HttpServletRequest request, final HttpServletResponse response, final AccessDeniedException exception ) throws IOException, ServletException {

        response.getOutputStream().print( "Access to this resource is denied --- THIS IS FROM MY_CUSTOM_ACCESS_DENIED_HANDLER !" );
        response.setStatus( 403 );
        response.getWriter().flush();
    }

}

