package com.firelord.test.core.fw.spring.db.mybatis.dao.mapper;


import com.firelord.test.core.fw.spring.db.mybatis.dao.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}