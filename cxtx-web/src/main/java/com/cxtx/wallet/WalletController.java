package com.cxtx.wallet;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "获得钱包信息")
    @GetMapping(value = "/getWallet")
    public Wallet selectByUserId(HttpServletRequest request){
        int user_id = (int)request.getSession().getAttribute("user_id");
        return walletService.selectWalletByUserId(user_id);
    }

    @ApiOperation(value = "更新钱包信息")
    @GetMapping(value = "/updateBalance")
    public String updateBalance(double changedBalance, HttpServletRequest request){
        int user_id = (int)request.getSession().getAttribute("user_id");
        walletService.updateBalanceByUserId(user_id, changedBalance);
        return "success";
    }

}
