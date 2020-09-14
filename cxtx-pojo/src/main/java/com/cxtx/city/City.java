package com.cxtx.city;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@Component
@Scope(value = "prototype")
public class City implements Serializable {
    // 城市在省份的 ID
    private int id;
    // 城市名称-主键
    private String city;
    // 省份 ID
    private int pid;


}
