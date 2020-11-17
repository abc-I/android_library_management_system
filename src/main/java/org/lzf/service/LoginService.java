package org.lzf.service;

import org.lzf.bean.Account;
import org.lzf.dao.LoginDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 登录逻辑运行
 * @author MI
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LoginService {

    private final LoginDao loginDao;

    /**
     * 初始化
     */
    public LoginService(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    /**
     * 验证登录密码、账号、权限
     * @param account
     * 传入账号对象
     * @return
     * 返回是否通过验证
     */
    public boolean login(Account account) {
        Account acc = loginDao.select(account.getAccount());
        return acc.getPassword().equals(account.getPassword())
                && acc.getPower().equals(account.getPower());
    }
}
