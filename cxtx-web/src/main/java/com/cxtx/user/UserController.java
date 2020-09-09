package com.cxtx.user;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

@Api(tags = "用户信息相关控制器")
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "headImageInteger")
    private AtomicInteger atomicInteger;
    @Autowired
    private UserService userService;

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "/alterInfo", method = RequestMethod.POST)
    @ResponseBody
    public String alterInfo(@RequestBody User user) {
        userService.alterInfo(user);
        return "success";
    }

    /**
     * 上传用户头像
     *
     * @param image
     * @return
     */
    @ApiOperation(value = "上传用户头像")
    @RequestMapping(value = "/uploadHeadImage", method = RequestMethod.POST)
    @ResponseBody
    public String uploadHeadImage(@RequestParam("image") MultipartFile image) {
        String dirPath = "D:" + File.separator + "userImages";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String filePath = null;
        try {
            //dirPath = ResourceUtils.getURL("classPath:").getPath() + "static" + File.separator + "userheads";
            filePath = dirPath + File.separator + getHeadImageName();
            File file = new File(filePath);
            image.transferTo(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }


    /**
     * 获得头像的编码
     *
     * @return
     */
    public String getHeadImageName() {
        int number = atomicInteger.incrementAndGet();
        String numberString = String.format("%010d", number);
        String result = "headerImage-" + numberString;
        return result;
    }


}
