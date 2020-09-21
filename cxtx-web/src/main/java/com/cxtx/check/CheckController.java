package com.cxtx.check;

import com.cxtx.account.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lqk
 * @Date 2020/9/20
 * @Description
 */
@Api(tags = "格式验证检查控制器")
@RestController
@RequestMapping(value = "/check")
public class CheckController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "检查用户帐号是否已存在")
    @GetMapping(value = "/checkUserName")
    public boolean checkUserName(String userName){
        if(accountService.selectAccountByUserName(userName) != null){
            return true;
        }
        return false;
    }


}
