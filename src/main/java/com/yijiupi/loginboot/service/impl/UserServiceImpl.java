package com.yijiupi.loginboot.service.impl;

import com.yijiupi.loginboot.controller.UserController;
import com.yijiupi.loginboot.dao.UserMapper;
import com.yijiupi.loginboot.pojo.UserPO;
import com.yijiupi.loginboot.pojo.UserVO;
import com.yijiupi.loginboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.yijiupi.loginboot.util.CommonUtil.*;

/**
*@Author: ZhangZhe
*@Description 实现映射接口
*@Date: 2017/12/15 15:48
*/

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVO login(String name, String password) {
        //登录
        LOGGER.info("进入login方法");
        UserPO userPO = userMapper.login(name, password);
        return convertToVO(userPO);
    }

    @Override
    public boolean register(String name, String password) {
        LOGGER.info("进入register方法");
        UserPO userPO = new UserPO();
        userPO.setUserName(name);
        userPO.setPassword(password);
        return userMapper.register(userPO);
    }

    @Override
    public UserVO checkUser(String name) {
        LOGGER.info("进入checkUser方法");
        UserPO userPO = userMapper.checkUser(name);
        return convertToVO(userPO);
    }

    @Override
    public boolean validate(String name, String password, String password1) {
        LOGGER.info("进入validate方法");
        boolean result = ((name.length() >= MIN_LENGTH && name.length() <= MAX_LENGTH) && (password.length() >= MIN_LENGTH
                && password.length() <= MAX_LENGTH) && password.equals(password1));
        return result;
    }

    /**
     *
     * @param userVO
     * @return userPO
     */
    private UserPO convertToPO(UserVO userVO){
        LOGGER.info("将PO转化成PO");
        if (null == userVO){
            return null;
        }
        UserPO userPO = new UserPO();
        userPO.setUserName(userVO.getUserName());
        userPO.setPassword(userVO.getPassword());
        return userPO;
    }

    /**
     *
     * @param userPO
     * @return userVO
     */
    private UserVO convertToVO(UserPO userPO){
        LOGGER.info("将VO转成PO");
        if (null == userPO){
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setId(userPO.getId());
        userVO.setUserName(userPO.getUserName());
        userVO.setPassword(userPO.getPassword());
        return userVO;
    }


}
