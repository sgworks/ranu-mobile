package com.sgworks.mobile.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = RanuMobileRestURIConstants.userRootMappingURI)
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

}

