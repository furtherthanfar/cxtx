package com.cxtx.user;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@Scope(scopeName = "prototype")
public class User {

    private int id;
    private String nickName;
    private String gender;
    private Date birth;
    private String description;
    private String phoneNumber;
    private String email;
    private String career;
    private String realName;
    private String cityName;

    /*Getter & Setter & toString*/

    public void build(int id, String nickName, String gender, Date birth, String description, String phoneNumber, String email, String career, String realName, String cityName) {
        this.id = id;
        this.nickName = nickName;
        this.gender = gender;
        this.birth = birth;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.career = career;
        this.realName = realName;
        this.cityName = cityName;
    }


}
