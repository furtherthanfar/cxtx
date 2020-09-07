package com.cxtx.account;

public class Account {

    private String userName;
    private String passWord;
    private int user_id;

    public Account() {
    }

    public Account(String userName, String passWord, int user_id) {
        this.userName = userName;
        this.passWord = passWord;
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
