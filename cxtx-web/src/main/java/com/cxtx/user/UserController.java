package com.cxtx.user;

import com.cxtx.util.ContextUtil;
import com.cxtx.util.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Api(tags = "用户信息相关控制器")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ImageUtil imageUtil;

    // 文件上传开始
    public static String userImageDirPath = "D:" + File.separator + "cxtx" + File.separator + "userImages";

    /**
     * 获得用户的全部信息
     * @param request
     * @return
     */
    @ApiOperation(value = "获得用户信息")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public User getUserInfo(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        User user = userService.selectUserById(user_id);
        return user;
    }

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
        // 检查图片格式
        if(!imageUtil.isImageLegal(image.getOriginalFilename())){
            return "图片格式不正确";
        }
        // 如果文件夹不存在，创建
        File dir = new File(userImageDirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        String filePath = null;
        // 图片命名计数器
        AtomicInteger imageInteger = (AtomicInteger) ContextUtil.getBean("headImageInteger");
        try {
            String[] split = image.getOriginalFilename().split("\\.");
            // 获得图片编码名称 + 位置
            filePath = userImageDirPath + File.separator + getHeadImageName(imageInteger) + "." +  split[split.length - 1];
            File file = new File(filePath);
            // 保存图片
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
    public String getHeadImageName(AtomicInteger imageInteger) {
        int number = imageInteger.incrementAndGet();
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) ContextUtil.getBean("simpleDateFormat");
        Date date = (Date) ContextUtil.getBean("date");
        String numberString = String.format("%05d", number);
        String result = "headerImage-" + simpleDateFormat.format(date) + numberString;
        return result;
    }


}
