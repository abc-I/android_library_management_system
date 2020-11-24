package org.lzf.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.lzf.bean.Account;
import org.lzf.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 登录控制器
 *
 * @author MI
 */
@Controller
@CrossOrigin
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 登录验证
     * 返回boolean
     */
    @RequestMapping("/login")
    public @ResponseBody
    boolean login(@RequestBody Account account) {
        return loginService.login(account);
    }

    @RequestMapping("/test")
    public @ResponseBody String test() {
        Algorithm algorithm = Algorithm.HMAC256(UUID.randomUUID().toString());
        Map<String, Object> map = new HashMap<>();
        map.put("type", "JWT");
        map.put("alg", "HS256");
        String token = JWT.create().withHeader(map).withClaim("account", "123").withClaim("password", "23").sign(algorithm);
        return token;
    }

    @GetMapping("/inet")
    public @ResponseBody String getInet(){
        return "INET";
    }
}