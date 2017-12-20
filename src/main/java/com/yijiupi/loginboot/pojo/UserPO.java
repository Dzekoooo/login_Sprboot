package com.yijiupi.loginboot.pojo;


import java.io.Serializable;

/**
*@Author: ZhangZhe
*@Description PO实体类
*@Date: 2017/12/15
*/
public class UserPO implements Serializable{
    private Integer id;
    private String password;
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
