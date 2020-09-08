package com.cxtx.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @RequestMapping("/alterInfo")
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
    @RequestMapping("/uploadImage")
    @ResponseBody
    public String uploadImage(@RequestParam("image") MultipartFile image) {
        String dirPath = "D:" + File.separator + "userImages";
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String filePath = null;
        try {
            //dirPath = ResourceUtils.getURL("classPath:").getPath() + "static" + File.separator + "userheads";
            filePath = dirPath + File.separator + image.getOriginalFilename();
            File file = new File(dirPath + File.separator + image.getOriginalFilename());
            image.transferTo(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath;
    }

    @RequestMapping("/toUpLoad")
    public String toUpLoad() {
        return "upload";
    }
}
