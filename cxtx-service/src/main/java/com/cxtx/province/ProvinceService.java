package com.cxtx.province;

import com.cxtx.city.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private RedisTemplate redisTemplate;

    private final static String PRE = "CXTX:";
    private final static String SUF = ":STRING";
    /**
     * 根据省份ID查找出省的城市
     * @param pid
     * @return
     */
    private List<City> selectCitiesByPid(int pid){
        return provinceDao.selectCitiesByPid(pid);
    }

    /**
     * 查找所有的省
     * @return
     */
    public List<Province> selectAllProvinces(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        List<Province> provinces = (List<Province>) redisTemplate.opsForValue().get(PRE + "provinces" + SUF);
        // DCL，防止穿透
        if(provinces == null){
            synchronized (this){
                provinces = (List<Province>) redisTemplate.opsForValue().get(PRE + "provinces" + SUF);
                if(provinces == null){
                    provinces = provinceDao.selectAllProvinces();
                    redisTemplate.opsForValue().set(PRE + "provinces" + SUF, provinces);
                }
            }
        }
        return provinces;
    }
}
