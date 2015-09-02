package com.sgworks.mobile.dao;

import com.sgworks.mobile.model.AppUser;

/**
 * Created by sgobinda on 22-08-2015.
 */
public interface UserDao {

    public AppUser checkUserDetailsForLogin(AppUser appUser);
    public AppUser getUserDetails(String userId);
}
