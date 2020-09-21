package com.cxtx.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lqk
 * @Date 2020/9/18
 * @Description
 */
@Service
public class StrategyService {

    @Autowired
    private StrategyDao strategyDao;

    /**
     * 插入一个新的攻略
     * @param strategy
     * @return
     */
    public int inertStrategy(Strategy strategy){
        return strategyDao.inertStrategy(strategy);
    }

    /**
     * 查找所有的攻略
     * @return
     */
    public List<Strategy> selectAllStrategies(){
        return strategyDao.selectAllStrategies();

    }


    /**
     * 根据用户ID 查询攻略
     * @param user_id
     * @return
     */
    public List<Strategy> selectStrategiesByUserId(int user_id){
        return strategyDao.selectStrategiesByUserId(user_id);
    }

    /**
     * 根据攻略ID删除攻略
     * @param strategy_id
     */
    public void deleteStrategyById(int strategy_id){
        strategyDao.deleteStrategyById(strategy_id);
    }
}
