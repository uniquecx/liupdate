package com.ct.dao;

import com.ct.entity.Reader;
import com.ct.entity.ReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReaderDao extends BaseDao {
    int countByExample(ReaderExample example);

    int deleteByExample(ReaderExample example);

    int deleteByPrimaryKey(Integer readerid);

    int insert(Reader record);

    int insertSelective(Reader record);

    List<Reader> selectByExample(ReaderExample example);

    Reader selectByPrimaryKey(Integer readerid);

    int updateByExampleSelective(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByExample(@Param("record") Reader record, @Param("example") ReaderExample example);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
    //分页
    List<Reader> selectForPage(ReaderExample example);
}