package com.cxtx.site;

import com.cxtx.util.RedisNameConfig;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    @Autowired
    private SiteMapper siteMapper;
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 查询所有的景点，带有缓存
     *
     * @return
     */
    public List<Site> selectAllSites() {
        // String 序列化
        String key = RedisNameConfig.PRE + "AllSites" + RedisNameConfig.SUF_STRING;
        redisTemplate.setKeySerializer(RedisNameConfig.STRING_REDIS_SERIALIZER);
        List<Site> allSite = null;
        allSite = (List<Site>) redisTemplate.opsForValue().get(key);
        if (allSite == null) {
            synchronized (this) {
                allSite = (List<Site>) redisTemplate.opsForValue().get(key);
                if (allSite == null) {
                    allSite = siteMapper.selectAllSites();
                    redisTemplate.opsForValue().set(key, allSite);
                }
            }
        }
        return allSite;
    }

    /**
     * 根据景区ID查找景区-带缓存
     *
     * @param site_id
     * @return
     */
    public Site selectSiteById(int site_id) {
        // Redis 的 Key
        String key = RedisNameConfig.PRE + "AllSites" + RedisNameConfig.SUF_HASH;
        // Redis 的 Field
        String hashKey = String.valueOf(site_id);
        redisTemplate.setKeySerializer(RedisNameConfig.STRING_REDIS_SERIALIZER);
        redisTemplate.setHashKeySerializer(RedisNameConfig.STRING_REDIS_SERIALIZER);
        Site site = null;
        site = (Site) redisTemplate.opsForHash().get(key, hashKey);
        if(site == null){
            synchronized (this){
                if(site == null){
                    site = siteMapper.selectSiteById(site_id);
                    redisTemplate.opsForHash().put(key, hashKey, site);
                }
            }
        }

        return site;
    }

    /**
     * 根据景区ID查找景区的全部图片
     *
     * @param site_id
     * @param rowBounds
     * @return
     */
    public List<SitePicture> selectPicturesBySiteId(@Param("site_id") int site_id, RowBounds rowBounds) {
        return siteMapper.selectPicturesBySiteId(site_id, new RowBounds(0, 10000));
    }


    /**
     * 根据景区ID查找景区的一个图片
     *
     * @param site_id
     * @param rowBounds
     * @return
     */
    public List<SitePicture> select1PicturesBySiteId(int site_id, RowBounds rowBounds) {
        return siteMapper.selectPicturesBySiteId(site_id, new RowBounds(0, 1));
    }


    /**
     * 插入一个新的Site
     *
     * @param site
     * @return
     */
    public int insertSite(Site site) {
        return siteMapper.insertSite(site);
    }
}
