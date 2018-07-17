package com.ct.dao;

import com.ct.entity.User;
import com.ct.entity.UserExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseDao{
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);
 
    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
    List<User> selectByname(String username);
    User selectByuser(Map<String, Object> map);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}