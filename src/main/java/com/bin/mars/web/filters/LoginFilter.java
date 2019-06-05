package com.bin.mars.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录拦截
 */

@WebFilter
public class LoginFilter implements Filter {
    /**
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = HttpServletRequest.class.cast(request);
        HttpServletResponse httpServletResponse = HttpServletResponse.class.cast(response);
        if (!"/".equals(httpServletRequest.getRequestURI())) {
            HttpSession session = httpServletRequest.getSession(false);
            if (session == null) //如果没有会话,则不能继续访问调回到首页
                httpServletResponse.sendRedirect("/");
        }
        chain.doFilter(request,response);
    }
}
