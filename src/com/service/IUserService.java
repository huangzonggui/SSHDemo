package com.service;

import com.entity.UsersEntity;

import java.util.List;

/**
 * Created by hzg on 2017/2/11.
 */
public interface IUserService {
    List login(UsersEntity user);
    void add(UsersEntity user);

    UsersEntity find(int id);
}
