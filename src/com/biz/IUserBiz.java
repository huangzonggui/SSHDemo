package com.biz;

import com.entity.UsersEntity;

import java.util.List;

/**
 * Created by hzg on 2017/2/11.
 */
public interface IUserBiz {
    public List login(UsersEntity user);
    public void add(UsersEntity user);

    UsersEntity find(int id);
}
