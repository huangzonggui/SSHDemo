package com.dao;

import com.entity.UsersEntity;

import java.util.List;

/**
 * Created by hzg on 2017/2/11.
 */
public interface IUserDAO {
    List search(UsersEntity user);

    void add(UsersEntity user);

    UsersEntity findById(int id);
}
