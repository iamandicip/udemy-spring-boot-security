package com.eazybytes.filter;

import jakarta.servlet.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingAfterFilter implements Filter {
    private final Logger logger =
            Logger.getLogger(AuthoritiesLoggingAfterFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication) {
            logger.info("User: " + authentication.getName() + " is authenticated and has the authorities " +
                    authentication.getAuthorities());
        }
        chain.doFilter(request, response);
    }

}
