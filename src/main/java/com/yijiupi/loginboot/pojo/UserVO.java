package com.yijiupi.loginboot.pojo;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
*@Author: ZhangZhe
*@Description VO实体类
*@Date: 2017/12/15
*/
public class UserVO implements Serializable{
    private Integer id;

    @NotNull
    @Size(min = 3, max = 8)
    private String userName;

    @NotNull
    @Size(min = 3, max = 8)
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
