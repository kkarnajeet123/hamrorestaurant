package com.hamrorestaurant.hamrorestaurant.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractAppDBRepository {
    @Autowired
    private SessionFactory appDbSessionFactory;

    protected Session getSession(){
        return appDbSessionFactory.getCurrentSession();
    }

    public void persist(Object entity){
        getSession().persist(entity);
    }

    public void delete(Object entity){
        getSession().delete(entity);
    }
}
