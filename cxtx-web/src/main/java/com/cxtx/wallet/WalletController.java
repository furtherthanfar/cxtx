package com.cxtx.wallet;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lqk
 * @Date 2020/9/22
 * @Description
 */
@Api(tags = "钱包相关控制器")
@RestController
@RequestMapping(value = "/wallet")
public class WalletController {

    @Autowired
    private WalletService walletService;

    @GetMapping(value = "/getWallet")
    public Wallet selectByUserId(HttpServletRequest request){
        int user_id = (int)request.getSession().getAttribute("user_id");
        return walletService.selectWalletByUserId(user_id);
    }

    @GetMapping(value = "/updateBalance")
    public String updateBalance(int changedBalance, HttpServletRequest request){
        int user_id = (int)request.getSession().getAttribute("user_id");
        walletService.updateBalanceByUserId(user_id, changedBalance);
        return "success";
    }

}
