package org.lzf.dao;

import org.apache.ibatis.annotations.Param;
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

    /**
     * 通过书籍id查询书籍
     * @param bookId 传入书籍id
     * @return 返回书籍信息
     */
    Books selectById(String bookId);

    /**
     * 添加书籍信息
     * @param books
     * 传入书籍表信息
     * @return
     * 返回 boolean
     */
    int insert(Books books);

    /**
     * 删除书籍
     * @param books 传入书籍名或书籍id
     * @return 返回 boolean
     */
    int deleteByCondition(Books books);

    /**
     * 修改书籍信息
     * @param oldId 旧的书籍id
     * @param books 修改的书籍信息
     * @return 返回 boolean
     */
    int updateById(@Param("oldId") String oldId, @Param("books") Books books);
}
