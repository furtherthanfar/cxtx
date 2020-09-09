package com.cxtx.user;

import com.cxtx.account.Account;
import com.cxtx.account.AccountMapper;
import com.cxtx.util.ContextUtil;
import com.cxtx.wallet.Wallet;
import com.cxtx.wallet.WalletMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private WalletMapper walletMapper;


    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public User selectUserById(int user_id) {
        return userMapper.selectUserById(user_id);
    }

    public void alterInfo(User user){
        userMapper.alterUserInfo(user);
    }

    /**
     * 插入一个新的用户，初始化钱包
     * @param account
     * @param user
     */
    @Transactional
    public void insertAccountAndUser(Account account, User user) {
        int user_id = insertUser(user);
        account.setUser_id(user.getId());
        accountMapper.insertAccount(account);
        Wallet wallet = (Wallet) ContextUtil.getBean("wallet");
        wallet.setBalance(0);
        wallet.setScore(0);
        wallet.setUser_id(user.getId());
        walletMapper.insertWallet(wallet);
    }

}
