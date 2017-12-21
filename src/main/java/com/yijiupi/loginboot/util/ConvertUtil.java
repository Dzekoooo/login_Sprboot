package com.yijiupi.loginboot.util;

import com.yijiupi.loginboot.pojo.UserPO;
import com.yijiupi.loginboot.pojo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*@Author: ZhangZhe
*@Description VO与PO相互转换工具
*@Date: 2017/12/21 10:37
*/

public class ConvertUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConvertUtil.class);
    /**
     *
     * @param userVO
     * @return userPO
     */
    public static UserPO convertToPO(UserVO userVO){
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
    public static UserVO convertToVO(UserPO userPO){
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
