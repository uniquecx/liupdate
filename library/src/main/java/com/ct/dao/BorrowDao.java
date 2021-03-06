package com.ct.dao;

import com.ct.entity.Borrow;
import com.ct.entity.BorrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowDao extends BaseDao {
    int countByExample(BorrowExample example);

    int deleteByExample(BorrowExample example);

    int deleteByPrimaryKey(Integer bid);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    List<Borrow> selectByExample(BorrowExample example);

    Borrow selectByPrimaryKey(Integer bid);

    int updateByExampleSelective(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByExample(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);
    //
    List<Borrow> selectForPage(BorrowExample example);
}