package org.lzf.dao;

import org.apache.ibatis.annotations.Param;
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

    /**
     * 根据传入的条件删除
     * @param borrows 传入删除的条件
     */
    void deleteByCondition(Borrows borrows);

    /**
     * 通过归还时间删除
     * @param returnTime 传入归还时间
     * @return 返回是否成功
     */
    int deleteByReturnTime(String returnTime);
}
