package fr.dawan.myskills.constants;

public class SecurityConstants {
    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME_VALIDATION = 7200000; //2 hours
    public static final long EXPIRATION_TIME_ADMIN = 86400000; // 24 hours
    public static final long EXPIRATION_TIME_USER = 604800000; // 1 week
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}