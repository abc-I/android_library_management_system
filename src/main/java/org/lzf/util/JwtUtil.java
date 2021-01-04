package org.lzf.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author MI
 */
public class JwtUtil {
    private static final String TOKEN_SECRET = UUID.randomUUID().toString();
    public static String token (String username,String password){
        String token;
        try {
            Algorithm algorithm = Algorithm.HMAC256(username + password + TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>(2);
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("password",password).withExpiresAt(new Date(System.currentTimeMillis()+(30*60*100000)))
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    public static boolean verify(String token,String username,String password){
        try {
            Algorithm algorithm = Algorithm.HMAC256(username + password + TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        }catch (Exception e){
            return  false;
        }
    }

    public static void main(String[] args) {
        String username ="zhangSan";
        String password = "123";
        String token = token(username,password);
        System.out.println(token);
        boolean b = verify(token, username, password);
        System.out.println(b);
    }
}
