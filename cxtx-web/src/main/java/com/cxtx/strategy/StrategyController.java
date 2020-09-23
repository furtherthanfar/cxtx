package com.cxtx.strategy;

import com.cxtx.user.User;
import com.cxtx.user.UserService;
import com.cxtx.util.ContextUtil;
import com.cxtx.util.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lqk
 * @Date 2020/9/18
 * @Description
 */
@Api(tags = "攻略相关控制器")
@RestController
@RequestMapping(value = "/strategy")
public class StrategyController {

    @Autowired
    private StrategyService strategyService;
    @Autowired
    private UserService userService;
    @Autowired
    private ImageUtil imageUtil;

    // 文件上传开始
    public static String strategyImageDirPath = "strategyImages";


    @ApiOperation(value = "插入一个新的攻略")
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertStrategy(Date date, String content, HttpServletRequest request){
        Strategy strategy = ContextUtil.getBean("strategy", Strategy.class);
        int user_id = (int) request.getSession().getAttribute("user_id");
        User user = userService.selectUserById(user_id);
        strategy.build(0, date, content, user);
        strategyService.inertStrategy(strategy);
        return "success";
    }

    @ApiOperation(value = "查找出全部的攻略")
    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    public List<Strategy> selectAll(){
        return strategyService.selectAllStrategies();
    }

    @ApiOperation(value = "根据用户ID查找攻略")
    @RequestMapping(value = "/selectByUser", method = RequestMethod.GET)
    public List<Strategy> selectByUserId(HttpServletRequest request){
        int user_id = (int) request.getSession().getAttribute("user_id");
        return strategyService.selectStrategiesByUserId(user_id);
    }

    @ApiOperation(value = "根据攻略ID删除攻略")
    @GetMapping(value = "/deleteById")
    public String deleteById(String strategyId){
        int strategy_id = Integer.parseInt(strategyId);
        strategyService.deleteStrategyById(strategy_id);
        return "success";
    }

    @ApiOperation(value = "上传攻略图片")
    @PostMapping(value = "/uploadImage")
    public String upLoadImage(@RequestParam("image") MultipartFile image){
        // 检查图片格式
        if(!imageUtil.isImageLegal(image.getOriginalFilename())){
            return "图片格式不正确";
        }
        String filePath = null;
        String fileName = null;
        // 图片命名计数器
        AtomicInteger imageInteger = (AtomicInteger) ContextUtil.getBean("strategyImageInteger");
        try {
            String[] split = image.getOriginalFilename().split("\\.");
            // 获得图片编码名称 + 位置
            fileName = strategyImageDirPath + File.separator+  getStrategyImageName(imageInteger) + "." + split[split.length - 1];
            filePath = ImageUtil.PATH + File.separator + fileName;
            File file = new File(new File(filePath).getAbsolutePath());
            // 保存图片
            image.transferTo(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "upload\\imgs\\" + fileName;
    }

    @ApiOperation(value = "根据攻略ID查询攻略")
    @PostMapping(value = "/selectById")
    public Strategy selectById(int strategy_id){
        return strategyService.selectStrategyById(strategy_id);
    }


    /**
     * 获得图片编码
     *
     * @return
     */
    public String getStrategyImageName(AtomicInteger imageInteger) {
        int number = imageInteger.incrementAndGet();
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) ContextUtil.getBean("simpleDateFormat");
        Date date = (Date) ContextUtil.getBean("date");
        String numberString = String.format("%05d", number);
        String result = "strategyImage-" + simpleDateFormat.format(date) + numberString;
        return result;
    }

}
