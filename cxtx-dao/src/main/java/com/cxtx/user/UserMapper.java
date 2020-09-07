package com.cxtx.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    /**
     * 新加入一个 User
     * @param user
     * @return
     */
    public int insertUser(User user);

    /**
     * 根据 ID 查找一个User
     * @param user_id
     * @return
     */
    public User selectUserById(int user_id);
}
