package com.yijiupi.loginboot.service;

import com.yijiupi.loginboot.pojo.UserVO;
/**
*@Author: ZhangZhe
*@Description 服务支持层
*@Date: 15:30 2017/12/15
*/


public interface UserService {

    /**
     * 实现登录
     *
     * @param loginName
     * @param password
     * @return UserVO
     */
    UserVO login(String loginName, String password);


    /**
     * 注册
     *
     * @param userName
     * @param password
     * @return boolean
     */
    boolean register(String userName, String password);


    /**
     * 检查用户名是否存在
     *
     * @param userName
     * @return UserVO
     */
    UserVO checkUser(String userName);


    /**
     * 校验
     *
     * @param userName
     * @param password
     * @param password1
     * @return boolean
     */
    boolean validate(String userName, String password, String password1);

}
