package org.lzf.bean;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 用于接收sql的查询账号的结果
 *
 * @author MI
 */
@Service
public class Account implements Serializable {
    /**
     * @account
     * 账号
     */
    private String account;
    /**
     * @password
     * 密码
     */
    private String password;
    /**
     * @power
     * 权限
     */
    private String power;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
