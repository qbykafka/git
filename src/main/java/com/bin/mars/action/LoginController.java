package com.bin.mars.action;

import com.bin.mars.action.dto.User;
import com.bin.mars.core.BaseController;
import com.bin.mars.core.Response;
import com.bin.mars.dao.UserDao;
import com.bin.mars.entity.TsUser;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController extends BaseController {

    @Resource
    private UserDao userDao;

    @ResponseBody
    @RequestMapping("/login.do")
    public Response login(@RequestBody User user){

        Response response = Response.newInstance();

        if (user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            response.setMessage("用户名或密码不为空");
        }else{
            /**
             * 获取session，如果session存在,则利用session里面用户信息进行验证
             * 如果当前session用户不存在用户信息，则进行数据库验证
             * 然后将用户信息保存到session
             * 如果session不存在，直接用数据库验证，验证成功创建session并保存用户信息
             */
            HttpSession session = getSession(false);
            /**
             * 做这一步是为了防止用户反复登录
             */
            if (session != null) {
                if (user.equals(session.getAttribute(user.getUsername()))) {
                    response.setSuccess(true);
                    response.setMessage("登录成功");
                }
            }else {
                TsUser tsUser = new TsUser();
                tsUser.setId(2);
                tsUser.setUsername(user.getUsername());
                tsUser.setPassword(user.getPassword());
                //已查询到，验证成功
                if (userDao.exists(Example.of(tsUser))){
                    session = getSession(true);
                    session.setAttribute(user.getUsername(),user);
                    response.setSuccess(true);
                    response.setMessage("登录成功");
                }else{
                    response.setMessage("用户名或密码不错误");
                }

            }
        }

        return response;
    }

    /**
     * 退出
     */
    @RequestMapping("/logout.do")
    public void logout() throws IOException {
        //获取session
        HttpSession session = getSession(false);
        if (session != null)
            session.invalidate();
        getHttpServletResponse().sendRedirect("/");
    }


}
