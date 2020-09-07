package com.cxtx.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountMapper {

    public int insertAccount(Account account);

    public Account selectAccount(@Param("userName")String userName, @Param("passWord")String passWord);

}
