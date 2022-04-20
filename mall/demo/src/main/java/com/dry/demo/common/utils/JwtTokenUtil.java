package com.dry.demo.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成和解析jwt的工具类
 */
@Slf4j
@Component
public class JwtTokenUtil {
    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 从 token 获取登录用户名 username
     */
    public String getUsernameFromToken(String token){
        String username = null;
        try{
            Claims claims = getClaimsFromToken(token);
            // subject 就是所谓用户名 sub
            username = claims.getSubject();
        }catch (Exception e){
            log.info("token解析用户名失败：{}", token);
        }
        return username;
    }

    /**
     * 从 token 中获取 payload
     * (不知道什么鬼，用 claims 来表示 payload)
     */
    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret) // 解密需要密钥
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e){
            log.info("JWT格式验证失败：{}", token);
        }
        return claims;
    }

    /**
     * 判断 token 是否 仍然有效
     * @param token       客户端传入的token
     * @param userDetails 从数据库中查询出来的用户信息
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUsernameFromToken(token);
        // token 解析获得 username 是否和userDetails封装的相同，且token 没有过期
        return username.equals(userDetails.getUsername()) && (!isTokenExpired(token));
    }

    /**
     * 判断 token 是否可以被刷新
     */
    public boolean canRefresh(String token){
        return !isTokenExpired(token);
    }

    /**
     * 刷新 token 时间
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        claims.put(CLAIM_KEY_CREATED, new Date());
        //根据刷新后的claims重新生成token
        return generateToken(claims);
    }

    /**
     * 根据用户信息 生成 token
     */
    public String generateToken(UserDetails userDetails){
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 根据 payload(claims) 生成 token
     */
    private String generateToken(Map<String, Object> claims){
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成过期时间，毫秒 millis
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 从 token 获取 过期时间
     */
    private Date getExpiredDateFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }
    /**
     * 验证 token 是否 过期
     */
    private boolean isTokenExpired(String token){
        Date expiredDate = getExpiredDateFromToken(token);
        return expiredDate.before(new Date());
    }
}
