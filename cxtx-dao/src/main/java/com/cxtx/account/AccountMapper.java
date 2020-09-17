package com.cxtx.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountMapper {

    public int insertAccount(Account account);

    public Account selectAccount(@Param("userName")String userName, @Param("passWord")String passWord);

    public void updatePassWord(@Param("account_id") int account_id,@Param("passWord") String passWord);

    public Account selectAccountByUserId(int user_id);
}
