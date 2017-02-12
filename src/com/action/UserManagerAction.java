package com.action;

import com.biz.IUserBiz;
import com.entity.UsersEntity;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by hzg on 2017/2/11.
 */
public class UserManagerAction extends ActionSupport {
    private String loginName;
    private String loginPwd;

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

    IUserBiz userBiz;

    public void setUserBiz(IUserBiz userBiz) {
        this.userBiz = userBiz;
    }

    @Override
    public String execute() throws Exception {
        UsersEntity user=new UsersEntity();
        user.setAccount(loginName);
        user.setPassword(loginPwd);
        List list=userBiz.login(user);
        if (list.size() > 0) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
