package com.cxtx.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     *  如果是充值，增加积分
     * @param user_id
     * @param changedBalance
     */
    @Transactional
    public void updateBalanceByUserId(int user_id, double changedBalance) {
        // 更新余额
        walletMapper.updateBalanceByUserId(user_id, changedBalance);
        if(changedBalance > 0){
            // 更新信誉积分
            walletMapper.updateScoreByUserId(user_id, (int)changedBalance * 100);
        }
    }
}
