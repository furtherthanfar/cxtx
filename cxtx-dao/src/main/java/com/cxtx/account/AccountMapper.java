package com.cxtx.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountMapper {

    /**
     * 新增账户
     * @param account
     * @return
     */
    public int insertAccount(Account account);

    /**
     * 查找账户
     * @param userName
     * @param passWord
     * @return
     */
    public Account selectAccount(@Param("userName")String userName, @Param("passWord")String passWord);

    /**
     * 修改密码
     * @param account_id
     * @param passWord
     */
    public void updatePassWord(@Param("account_id") int account_id,@Param("passWord") String passWord);

    /**
     * 根据用户ID查找账户
     * @param user_id
     * @return
     */
    public Account selectAccountByUserId(int user_id);

    /**
     * 查找有没有这个userName的账户
     * @param userName
     * @return
     */
    public String selectAccountByUserName(String userName);
}
