package hello.jwt_example.common.util;

import hello.jwt_example.domain.member.Member;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtTokenUtil {
    private final SecretKey secretKey;

    public JwtTokenUtil() {
        this.secretKey = Jwts.SIG.HS256.key().build();
    }

    public String generateAccessToken(Member member) {
        Date now = new Date();
        return Jwts.builder()
                .subject(member.getEmail())
                .issuedAt(now)
                .expiration(createExpireDate(now,1000 * 60 * 5))
                .signWith(secretKey)
                .compact();
    }

    public String generateRefreshToken(Member member) {
        Date now = new Date();
        return Jwts.builder()
                .subject(member.getEmail())
                .issuedAt(now)
                .expiration(createExpireDate(now, 1000 * 60 * 10))
                .signWith(secretKey)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);

            return true;
        } catch (JwtException | NullPointerException exception) {
            return false;
        }
    }

    private Date createExpireDate(Date now, long expireDate) {
        return new Date(now.getTime() + expireDate);
    }
}
