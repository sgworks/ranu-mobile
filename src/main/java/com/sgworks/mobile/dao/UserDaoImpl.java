package com.sgworks.mobile.dao;

import com.sgworks.mobile.model.AppUser;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<String, AppUser> implements UserDao{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public AppUser checkUserDetailsForLogin(AppUser appUser) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", appUser.getUsername()));
        criteria.add(Restrictions.eq("password", appUser.getPassword()));
        return (AppUser)criteria.uniqueResult();
    }

    @Override
    public AppUser getUserDetails(String userId) {
        return getByKey(userId);
    }
}
