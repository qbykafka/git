package com.bin.mars.action;

import com.bin.mars.core.Response;
import com.bin.mars.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController extends BaseController{

    @ResponseBody
    @RequestMapping(value = "/login.do")
    public Response login(@RequestBody User user){
        Response response = Response.newInstance();
        valid(user,response);
        return response;
    }

    //验证
    private  void valid(User user,Response response){
        if (user == null || StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
            response.setMessage("用户名或密码不为空");
            return;
        }
        HttpSession session = getSession();
    }
}
