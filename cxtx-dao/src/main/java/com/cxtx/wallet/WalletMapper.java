package com.cxtx.wallet;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WalletMapper {

    /**
     * 插入一个新的钱包
     * @param wallet
     * @return
     */
    public int insertWallet(Wallet wallet);

    /**
     * 根据用户id查找到钱包
     * @param user_id
     * @return
     */
    public Wallet selectWalletByUserId(int user_id);


    /**
     * 根据用户id和变化的金额，更新钱包余额
     * @param user_id
     * @param changedBalance
     */
    public void updateBalanceByUserId(int user_id, double changedBalance);


    /**
     * 根据用户id和变化的信誉分数，更新钱包信誉分数
     * @param user_id
     * @param changedScore
     */
    public void updateScoreByUserId(int user_id, int changedScore);

}
