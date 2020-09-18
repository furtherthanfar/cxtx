package com.cxtx.province;

import com.cxtx.city.City;
import com.cxtx.util.RedisNameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceDao provinceDao;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    
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
        String key = RedisNameConfig.PRE + "Provinces" + RedisNameConfig.SUF_STRING;
        redisTemplate.setKeySerializer(RedisNameConfig.STRING_REDIS_SERIALIZER);
        List<Province> provinces = (List<Province>) redisTemplate.opsForValue().get(key);
        // DCL，防止穿透
        if(provinces == null){
            synchronized (this){
                provinces = (List<Province>) redisTemplate.opsForValue().get(key);
                if(provinces == null){
                    provinces = provinceDao.selectAllProvinces();
                    redisTemplate.opsForValue().set(key, provinces);
                }
            }
        }
        return provinces;
    }
}
