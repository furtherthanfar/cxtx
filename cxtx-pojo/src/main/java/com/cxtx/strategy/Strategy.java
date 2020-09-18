package com.cxtx.strategy;

import com.cxtx.user.User;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author lqk
 * @Date 2020/9/18
 * @Description 攻略对应类
 */
@Data
@Component
@Scope(value = "prototype")
public class Strategy {

    // 攻略 ID
    private int id;
    // 攻略上传时间
    private Date time;
    // 攻略内容
    private String content;
    // 用户
    private User user;

    public void build(int id, Date time, String content, User user) {
        this.id = id;
        this.time = time;
        this.content = content;
        this.user = user;
    }
}
