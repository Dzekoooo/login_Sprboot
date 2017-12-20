package com.yijiupi.loginboot.controller;

import com.yijiupi.loginboot.pojo.UserVO;
import com.yijiupi.loginboot.service.UserService;
import com.yijiupi.loginboot.util.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.yijiupi.loginboot.util.CommonUtil.*;

/**
*@Author: ZhangZhe
*@Description  Controller层
*@Date: 13:49 2017/12/7
*/


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "login")
    public ModelAndView loginForm(ModelAndView mv){
        mv.setViewName(LOGIN);
        return mv;
    }

    @RequestMapping(value = "user/login")
    public ModelAndView login(@RequestParam(value = "name", required = false) String loginName,
                              @RequestParam(value = "pWord", required = false) String password,
                              HttpSession session, ModelAndView mv){
            String p1 = Md5.getMD5(password);
            UserVO userVO = userService.login(loginName, p1);
            if (null != userVO){
                session.setAttribute(USER_SESSION, userVO);
                mv.setViewName(SUCCESS);
                return mv;
            }
            mv.setViewName(LOGINFORM);
        return mv;
    }

    @RequestMapping(value = "register")
    public ModelAndView registerForm(ModelAndView mv){
        mv.setViewName(REGISTER);
        return mv;
    }

    @RequestMapping(value = "user/register")
    public ModelAndView register(@RequestParam(value = "name", required = false)  String userName,
                                 @RequestParam(value = "userPass", required = false) String password,
                                @RequestParam(value = "userPass1", required = false) String password1,
                         ModelAndView mv) {
        //判断用户名是否存在
        UserVO userVO = userService.checkUser(userName);
        if (null != userVO){
            mv.setViewName(REGISTERFORM);
            return mv;
        }
        boolean result = userService.validate(userName, password, password1);
        System.out.println(result);
        //验证通过则直接跳转登录，否则跳转注册页面重新注册
        if (false != result){
            String p = Md5.getMD5(password);
            boolean registerResult = userService.register(userName, p);
            if (false != registerResult){
                mv.addObject("注册成功，直接登录");
                mv.setViewName(LOGIN);
                return mv;
            }
            mv.addObject("注册信息失败，请重新注册");
            mv.setViewName(REGISTERFORM);
            return mv;
        }
        mv.setViewName(REGISTERFORM);
        return mv;
    }
}
