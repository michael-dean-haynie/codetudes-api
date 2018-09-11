package com.codetudes.codetudesapi.config.security;

import java.util.concurrent.TimeUnit;

public class SecurityConstants {
    public static final long EXPIRATION_TIME = TimeUnit.DAYS.toMillis(1);
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
//    public static final String SIGN_UP_URL = "/users/sign-up";
}