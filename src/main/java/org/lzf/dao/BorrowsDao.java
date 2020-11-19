package org.lzf.dao;

import org.apache.ibatis.annotations.Param;
import org.lzf.bean.Books;
import org.lzf.bean.Borrows;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 借阅查询
 * @author MI
 */
@Repository
public interface BorrowsDao {
    /**
     * 查询id
     * @param stuId
     * 传入的学生id
     * @return
     * 返回查询的结果
     */
    List<Borrows> selectById(String stuId);

    /**
     * 查询所有借阅
     * @param b
     * 判断是否以返回时间为空查询
     * @return
     * 返回
     */
    List<Borrows> selectByReturnTime(Boolean b);

    /**
     * 通过书名查询
     * @param borrowsBookName
     * 传入的书名
     * @return
     * 返回查询结果
     */
    Books selectByName(String borrowsBookName);

    /**
     * 插入信息
     * @param borrows
     * 传入参数
     * @return
     * 返回信息
     */
    int insert(Borrows borrows);

    /**
     * 更新信息
     * @param condition
     * 传入条件
     * @param borrows
     * 传入修改值
     * @return
     * 返回信息
     */
    int update(@Param("condition") Map<String,Object> condition, @Param("borrows") Borrows borrows);

    void deleteByCondition(Borrows borrows);

    int deleteByReturnTime(String returnTime);
}
