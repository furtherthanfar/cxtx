package com.cxtx.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {
    @Autowired
    private WalletMapper walletMapper;

    /**
     * 插入一个新的钱包
     *
     * @param wallet
     * @return
     */
    public int insertWallet(Wallet wallet) {
        return walletMapper.insertWallet(wallet);
    }

    /**
     * 根据用户id查找到钱包
     *
     * @param user_id
     * @return
     */
    public Wallet selectWalletByUserId(int user_id) {
        return walletMapper.selectWalletByUserId(user_id);
    }

    /**
     * 根据用户id和变化的金额，更新钱包余额
     *
     * @param user_id
     * @param changedBalance
     */
    public void updateBalanceByUserId(int user_id, double changedBalance) {
        walletMapper.updateBalanceByUserId(user_id, changedBalance);
    }
}
