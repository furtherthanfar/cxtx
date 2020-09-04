package com.cxtx.account.service;

import com.cxtx.account.pojo.Account;

public interface AccountService {

    public void insertAccount(Account account);

    public Account selectAccount(String userName,String passWord);
}
