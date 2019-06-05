package com.bin.mars.action;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class BaseController {

    @Autowired
    protected HttpServletRequest httpServletRequest;


    protected HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    protected HttpSession getSession(){
        return httpServletRequest.getSession();
    }

}
