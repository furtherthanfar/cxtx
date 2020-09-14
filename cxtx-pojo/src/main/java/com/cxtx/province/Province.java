package com.cxtx.province;

import com.cxtx.city.City;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Data
@Component
@Scope(value = "prototype")
public class Province implements Serializable {
    // 省份ID
    private int pid;
    // 省份名称
    private String province;
    // 包含的城市
    private List<City> cities;

}
