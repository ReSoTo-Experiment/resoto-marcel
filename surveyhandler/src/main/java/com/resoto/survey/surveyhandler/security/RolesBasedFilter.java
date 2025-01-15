package com.resoto.survey.surveyhandler.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class RolesBasedFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Example: Check if the request URI is for a protected REST endpoint
        if (request.getRequestURI().startsWith("/surveys")) {
            var authentication = SecurityContextHolder.getContext().getAuthentication();

            //todo filter here.
        }

        // If all checks pass, continue the request to the REST controller
        filterChain.doFilter(request, response);
    }
}