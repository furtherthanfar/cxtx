package com.cxtx.account.service;

import com.cxtx.account.mapper.AccountMapper;
import com.cxtx.account.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    @Override
    public Account selectAccount(String userName, String passWord) {
        return accountMapper.selectAccount(userName, passWord);
    }
}
