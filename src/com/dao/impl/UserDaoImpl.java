package com.dao.impl;

import com.dao.IUserDAO;
import com.entity.UsersEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hzg on 2017/2/11.
 */
@Transactional
public class UserDaoImpl implements IUserDAO {
    SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private HibernateTemplate hibernateTemplate;

//    @Resource
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        System.out.println("setHibernateTemplate");
        this.hibernateTemplate = hibernateTemplate;
        System.out.println(hibernateTemplate);
    }

    @Override
    public List search(UsersEntity user) {
        List list = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            //Criteria 提供了 add(Criterion criterion) 方法来添加查询条件。
            Criteria c = session.createCriteria(UsersEntity.class);
            Example example = Example.create(user);
            c.add(example);
            list = c.list();
            /*list = session.createCriteria(UsersEntity.class)
                    .add(Example.create(user))
                    .list();*/
//            System.out.println("hahah"+hibernateTemplate.get(UsersEntity.class, 0));
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        return list;
    }

    @Override
    public void add(UsersEntity user) {
        //用hibernateTemplate
//        System.out.println(sessionFactory);
//        hibernateTemplate = new HibernateTemplate(sessionFactory);
        System.out.println(hibernateTemplate);
        hibernateTemplate.save(user);
    }

    @Override
    public UsersEntity findById(int id) {
        System.out.println(hibernateTemplate);
        UsersEntity user = hibernateTemplate.get(UsersEntity.class, id);
        return user;
    }
}
