package com.nexura.agendaSegurosBackend.Config.Security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import java.io.IOException;
import java.io.PrintWriter;

public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {
    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter out = response.getWriter();
        out.println("{ codigo: No autorizado   Error: "+authException.getMessage()+" }");
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Seguridad");
        super.afterPropertiesSet();
    }
}
