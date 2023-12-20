package com.hamrorestaurant.hamrorestaurant.repository;

import com.hamrorestaurant.hamrorestaurant.entity.UserInfoEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserInfoRepoImpl extends AbstractAppDBRepository implements UserInfoRepository{

    private static final Logger logger = LoggerFactory.getLogger(UserInfoRepoImpl.class);

    @Override
    public void saveOrUpdate(UserInfoEntity userInfo) {
        try{
            getSession().saveOrUpdate(userInfo);
        }catch (HibernateException e){
            logger.error("Exception at create userInfo", e);
        }
    }

    @Override
    public List<UserInfoEntity> findAllUsers() {
       try {
           return getSession().createQuery("SELECT a FROM a", UserInfoEntity.class).getResultList();
       }catch (HibernateException e){
           logger.error("Exception getting UserInfoEntity from db");
       }
       return null;
    }

    @Override
    public UserInfoEntity findUserById(int userId) {
        try {
            Criteria criteria = getSession().createCriteria(UserInfoEntity.class);
            criteria.add(Restrictions.eq("userId", userId));
            return (UserInfoEntity) criteria.uniqueResult();
        }catch (HibernateException e){
            logger.error("Exception at findByUserId");
            throw e;
        }
    }
}
