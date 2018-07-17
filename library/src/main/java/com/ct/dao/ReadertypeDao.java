package com.ct.dao;

import com.ct.entity.Readertype;
import com.ct.entity.ReadertypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReadertypeDao extends BaseDao {
    int countByExample(ReadertypeExample example);

    int deleteByExample(ReadertypeExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Readertype record);

    int insertSelective(Readertype record);

    List<Readertype> selectByExample(ReadertypeExample example);

    Readertype selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Readertype record, @Param("example") ReadertypeExample example);

    int updateByExample(@Param("record") Readertype record, @Param("example") ReadertypeExample example);

    int updateByPrimaryKeySelective(Readertype record);

    int updateByPrimaryKey(Readertype record);
}