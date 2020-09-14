package com.cxtx.province;

import com.cxtx.city.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProvinceDao {

    public List<City> selectCitiesByPid(int pid);

    public List<Province> selectAllProvinces();
}
