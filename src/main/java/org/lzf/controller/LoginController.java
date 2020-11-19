package org.lzf.controller;

import org.lzf.bean.Account;
import org.lzf.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @author MI
 */
@Controller
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
    public @ResponseBody boolean login(Account account){
        System.out.println(account);
        return loginService.login(account);
    }
}
