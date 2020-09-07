package com.cxtx.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;


    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }


    public Account selectAccount(String userName, String passWord) {
        return accountMapper.selectAccount(userName, passWord);
    }
}
