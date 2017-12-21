package com.yijiupi.loginboot.interceptor;

import com.yijiupi.loginboot.controller.UserController;
import com.yijiupi.loginboot.pojo.UserPO;
import com.yijiupi.loginboot.pojo.UserVO;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.yijiupi.loginboot.util.CommonUtil.*;


/**
*@Author: ZhangZhe
*@Description  登录拦截器
*@Date: 2017/12/15
*/

public class UserInterceptor implements HandlerInterceptor{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        LOGGER.info("============================拦截器启动==============================");
        request.setAttribute("starttime",System.currentTimeMillis());
        //拦截请求
        Object obj = request.getSession().getAttribute(USER_STATE);
        if (null == obj){
            response.sendRedirect(request.getContextPath() + "/registerForm");
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView mv) throws Exception {
        LOGGER.info("===========================执行处理完毕=============================");
        long starttime = (long) request.getAttribute("starttime");
        request.removeAttribute("starttime");
        long endtime = System.currentTimeMillis();
        LOGGER.info("============请求地址："+request.getRequestURI()+"：处理时间：{}",(endtime-starttime)+"ms");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object handler, Exception e) throws Exception {
        LOGGER.info("============================拦截器关闭==============================");
    }
}
