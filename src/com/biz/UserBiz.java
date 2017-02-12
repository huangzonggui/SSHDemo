package com.biz;

import com.dao.IUserDAO;
import com.dao.impl.UserDaoImpl;
import com.entity.UsersEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hzg on 2017/2/11.
 */
@Transactional
public class UserBiz implements IUserBiz {

    private IUserDAO userDAO;

    public void setUserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List login(UsersEntity user) {
        return userDAO.search(user);
    }

    @Override
    public void add(UsersEntity user) {
        IUserDAO dao=new UserDaoImpl();
        dao.add(user);
    }

    @Override
    public UsersEntity find(int id) {
        IUserDAO dao=new UserDaoImpl();
        return dao.findById(id);
    }
}
