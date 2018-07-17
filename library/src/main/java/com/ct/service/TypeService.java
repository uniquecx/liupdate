package com.ct.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ct.entity.Type;
import com.ct.entity.TypeExample;

public interface TypeService {
	 int countByExample(TypeExample example);

	    int deleteByExample(TypeExample example);

	    int deleteByPrimaryKey(Integer typenumber);

	    int insert(Type record);

	    int insertSelective(Type record);

	    List<Type> selectByExample(TypeExample example);

	    Type selectByPrimaryKey(Integer typenumber);

	    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

	    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

	    int updateByPrimaryKeySelective(Type record);

	    int updateByPrimaryKey(Type record);

}
