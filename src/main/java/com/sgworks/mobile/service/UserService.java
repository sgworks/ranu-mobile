package com.sgworks.mobile.service;

import com.sgworks.mobile.model.AppUser;


public interface UserService {

    public AppUser checkUserDetailsForLogin(AppUser appUser);
    public AppUser getUserDetails(String userId);
}
