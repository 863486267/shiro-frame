package com.common.shiroframe.entity;

/**
 * Created by Mr.John on 2018/11/22 20:55.
 **/


public class UserEntity {
    private int id;
    private String userName;
    private String Password;
    private int power;
    private String salt;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", Password='" + Password + '\'' +
                ", power=" + power +
                ", salt='" + salt + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
