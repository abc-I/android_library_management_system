package org.lzf.dao;

import org.lzf.bean.Account;
import org.springframework.stereotype.Repository;

/**
 * 登录dao层接口
 * @author MI
 */
@Repository
public interface LoginDao {
    /**
     * 通过账号查询账号、密码、全限
     *
     * @param account
     * 前端传入的账号
     * @return
     * 查询账号，查询结果封装如Account
     */
    Account select(String account);
}
