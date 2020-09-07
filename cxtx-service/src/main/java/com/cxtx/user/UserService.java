package com.cxtx.user;

import com.cxtx.account.Account;
import com.cxtx.account.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountMapper accountMapper;

    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public User selectUserById(int user_id) {
        return userMapper.selectUserById(user_id);
    }

    @Transactional
    public void insertAccountAndUser(Account account, User user) {
        int user_id = insertUser(user);
        account.setUser_id(user_id);
        accountMapper.insertAccount(account);
    }


}
