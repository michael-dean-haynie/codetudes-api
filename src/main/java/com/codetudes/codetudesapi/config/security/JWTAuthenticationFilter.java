package com.codetudes.codetudesapi.config.security;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import com.auth0.jwt.JWT;
import org.springframework.stereotype.Component;

import static com.codetudes.codetudesapi.config.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final long EXPIRATION_TIME = TimeUnit.DAYS.toMillis(1);

    private Environment env;

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, Environment env) {
        this.authenticationManager = authenticationManager;
        this.env = env;
//        this.setFilterProcessesUrl("/api/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
            // try to get credentials from request header
            String authorization = req.getHeader(HEADER_STRING);
            if (null != authorization && authorization.startsWith("Basic")){

                String base64Credentials = authorization.replace("Basic ", "").trim();
                String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));

                String[] values = credentials.split(":",2);
                String username = values[0];
                String password = values[1];

                return authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                username,
                                password,
                                new ArrayList<>())
                );
            }
            else {
                throw new RuntimeException("Could not authenticate with given credentials.");
            }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        System.out.println(env.getProperty("jwt.private-secret"));
        System.out.println(env.getProperty("jwt.private-secret").getBytes());


        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC512(env.getProperty("jwt.private-secret").getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
