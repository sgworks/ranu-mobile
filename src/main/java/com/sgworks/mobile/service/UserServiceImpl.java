package com.sgworks.mobile.service;

import com.sgworks.mobile.dao.UserDao;
import com.sgworks.mobile.model.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("userService")
@Transactional
public class UserServiceImpl implements UserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public AppUser checkUserDetailsForLogin(AppUser appUser) {
        return userDao.checkUserDetailsForLogin(appUser);
    }

    @Override
    public AppUser getUserDetails(String userId) {
        return null;
    }
}
