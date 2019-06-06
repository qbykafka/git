package com.bin.mars.core;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class BaseController {

    @Resource
    protected HttpServletRequest httpServletRequest;

    @Resource
    protected HttpServletResponse httpServletResponse;


    protected HttpServletResponse getHttpServletResponse() {
        return httpServletResponse;
    }

    protected HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }

    protected HttpSession getSession(boolean create){
        return httpServletRequest.getSession(create);
    }

}
