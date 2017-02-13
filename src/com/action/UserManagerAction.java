package com.action;

import com.service.IUserService;
import com.entity.UsersEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hzg on 2017/2/11.
 */
public class UserManagerAction extends ActionSupport {
    private String loginName;
    private String loginPwd;
    private String account;

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    IUserService userService;

    public void setUserBiz(IUserService userBiz) {
        this.userService = userBiz;
    }

    public String login() throws Exception {
        UsersEntity user = new UsersEntity();
        user.setAccount(loginName);
        user.setPassword(loginPwd);
        List list = userService.login(user);
        if (list.size() > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String add() {
        UsersEntity user = new UsersEntity();
        user.setAccount(account);
        user.setName(loginName);
        user.setPassword(loginPwd);
        userService.add(user);
        return NONE;
    }


}
