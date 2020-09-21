package com.cxtx.account;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AccountService {

    @Autowired
    private AccountMapper accountMapper;


    /**
     * 插入一个新的账户
     * @param account
     */
    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    /**
     * 根据帐号密码查找帐号
     * @param userName 登陆账号
     * @param passWord 登录密码
     * @return
     */
    public Account selectAccount(String userName, String passWord) {
        return accountMapper.selectAccount(userName, passWord);
    }

    /**
     * 根据账号ID更新密码
     * @param account_id 账户ID
     * @param passWord  新的密码
     */
    public void updatePassWord(@Param("account_id") int account_id, @Param("password") String passWord){
        accountMapper.updatePassWord(account_id, passWord);
    }

    /**
     * 根据用户ID查找账户
     * @param user_id 用户ID
     * @return
     */
    public Account selectAccountByUserId(int user_id){
        return accountMapper.selectAccountByUserId(user_id);
    }

    /**
     * 查找有没有这个userName的账户
     * @return
     */
    public String selectAccountByUserName(String userName){
        return  accountMapper.selectAccountByUserName(userName);
    }
}
