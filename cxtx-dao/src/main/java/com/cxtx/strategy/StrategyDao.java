package com.cxtx.strategy;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lqk
 * @Date 2020/9/18
 * @Description 攻略相关的数据库接口
 */
@Mapper
@Repository
public interface StrategyDao {

    /**
     * 插入一个新的攻略
     * @param strategy
     * @return
     */
    public int inertStrategy(Strategy strategy);

    /**
     * 查找所有的攻略
     * @return
     */
    public List<Strategy> selectAllStrategies();


    /**
     * 根据用户ID 查询攻略
     * @param user_id
     * @return
     */
    public List<Strategy> selectStrategiesByUserId(int user_id);

}
