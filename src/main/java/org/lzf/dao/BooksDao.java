package org.lzf.dao;

import org.lzf.bean.Books;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 查询书籍信息
 *
 * @author MI
 */
@Repository
public interface BooksDao {
    /**
     * 查询书籍表
     * @param bookName
     * 前端传书名
     * @return
     * 将查询到的书籍信息封装进Books类
     */
    List<Books> select(String bookName);

    /**
     * 查询所有书籍
     * @return
     * 将查询结果封装
     */
    List<Books> selectAll();

    int insert(Books books);

    int deleteByCondition(Books books);

    int updateById(String oldId, Books books);
}
