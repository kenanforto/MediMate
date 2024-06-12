package com.medimate.SpringCloudGateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class JwtConfig {

    private static final String AUTHORITIES_KEY = "roles";

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.secret}")
    private String secret;

    @Value("${security.jwt.expiration}")
    private Integer expiration;


    public Key getSigningKey()
    {
        byte[] keyBytes=this.secret.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
    public String generateToken(UserDetails user)
    {
        Claims claims=Jwts.claims().setSubject(user.getUsername());
        claims.put(AUTHORITIES_KEY,user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(",")));
//        claims.put("UserId",user.getUserId());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration*600))
                .signWith(getSigningKey(),SignatureAlgorithm.HS256)
                .compact();

    }
    public Claims extractAllClaims(String token)
    {
        Claims claims;
        try
        {
            claims=Jwts.parserBuilder()
                    .setSigningKey(getSigningKey())
                    .build().parseClaimsJws(token)
                    .getBody();
        }
        catch (Exception e)
        {
            claims=null;
        }
        return claims;
    }
    public Date getExpirationDate(String token)
    {
        return extractAllClaims(token).getExpiration();
    }
    public Boolean isTokenExpired(String token)
    {
        return getExpirationDate(token).before(new Date());
    }
    public String getUsernameFromToken(String token)
    {
        return extractAllClaims(token).getSubject();
    }

    public Boolean validateToken(String token) {
        if (!isTokenExpired(token)){
            extractAllClaims(token);
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getUsername(String token)
    {
        Claims claims=extractAllClaims(token);
        return claims.getSubject();
    }
    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSecret() {
        return secret;
    }

    public Authentication getAuthentication(String token) {
        Claims claims=extractAllClaims(token);
        Object authoritiesClaim=claims.get(AUTHORITIES_KEY);
        Collection<? extends GrantedAuthority> authorities=authoritiesClaim==null
                ? AuthorityUtils.NO_AUTHORITIES
                :AuthorityUtils.commaSeparatedStringToAuthorityList(authoritiesClaim.toString());
        return new UsernamePasswordAuthenticationToken(getUsername(token),token,authorities);
    }
}
