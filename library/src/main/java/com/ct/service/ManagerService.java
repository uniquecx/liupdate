package com.ct.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ct.entity.Manager;
import com.ct.entity.ManagerExample;

public interface ManagerService {
	  int countByExample(ManagerExample example);

	    int deleteByExample(ManagerExample example);

	    int deleteByPrimaryKey(Integer managerid);

	    int insert(Manager record);

	    int insertSelective(Manager record);

	    List<Manager> selectByExample(ManagerExample example);

	    Manager selectByPrimaryKey(Integer managerid);

	    int updateByExampleSelective(@Param("record") Manager record, @Param("example") ManagerExample example);

	    int updateByExample(@Param("record") Manager record, @Param("example") ManagerExample example);

	    int updateByPrimaryKeySelective(Manager record);

	    int updateByPrimaryKey(Manager record);

}
