package com.ct.dao;

import com.ct.entity.Book;
import com.ct.entity.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookDao extends BaseDao {
    int countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(Integer bookid);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(Integer bookid);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);
    //分页查询
   List<Book> selectForPage(BookExample example);
}