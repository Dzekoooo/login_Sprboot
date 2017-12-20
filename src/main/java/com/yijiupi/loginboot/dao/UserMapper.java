package com.yijiupi.loginboot.dao;


import com.yijiupi.loginboot.pojo.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
*@Author: ZhangZhe
*@Description Mapper映射接口
*@Date: 2017/12/15
*/
@Mapper
@Repository
public interface UserMapper {
    /**
     * 登录
     * @param loginName
     * @param password
     * @return UserPO
     */
    UserPO login(@Param("loginName") String loginName,
                 @Param("password") String password);


    /**
     * 注册
     *
     * @param userPO
     * @return boolean
     */
    boolean register(UserPO userPO);


    /**
     * 判断用户是否被注册
     *
     * @param userName
     * @return UserPO
     */
    UserPO checkUser(@Param("userName") String userName);

}
