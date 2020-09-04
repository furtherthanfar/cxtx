package com.cxtx.account.mapper;

import com.cxtx.account.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMapper {

    public void insertAccount(Account account);

    public Account selectAccount(@Param("userName")String userName, @Param("passWord")String passWord);

}
