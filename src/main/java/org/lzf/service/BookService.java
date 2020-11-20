package org.lzf.service;

import org.lzf.bean.Books;
import org.lzf.bean.Borrows;
import org.lzf.dao.BooksDao;
import org.lzf.dao.BorrowsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查询书籍逻辑运行
 *
 * @author MI
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class BookService {

    private final BooksDao booksDao;
    private final BorrowsDao borrowsDao;

    public BookService(BooksDao booksDao, BorrowsDao borrowsDao) {
        this.booksDao = booksDao;
        this.borrowsDao = borrowsDao;
    }

    /**
     * 查询书籍
     * 传入书名，或部分书名
     * 返回 List<Book>
     */
    public List<Books> searchBookService(String bookName) {
        // 通过空格分割字符串
        String[] name = bookName.split(" ");

        // 创建List，存储查询出的Books
        List<Books> list = new ArrayList<>();

        // 遍历书籍名的关键字，查询包含关键字的书籍
        for (String s : name) {
            list.addAll(booksDao.select(s));
        }

        return list;
    }

    /**
     * 书籍管理界面，显示书籍
     * 不用传数据
     * 返回 List<Books>
     */
    public List<Books> bookManagement() {
        // 查询所有未归还的书籍
        return booksDao.selectAll();
    }

    /**
     * 添加书籍信息
     * 传入书籍信息
     * 返回 boolean
     */
    public boolean addBook(Books books) {
        int x = booksDao.insert(books);
        return x == -2147482646;
    }

    /**
     * 删除书籍
     * 传入书籍id
     * 返回 boolean
     */
    public boolean deleteBook(Books books) {
        Borrows borrows = new Borrows();
        if (books.getBookId() != null) {
            borrows.setBorrowsBookId(books.getBookId());
            borrows.setBorrowsBookName(books.getBookName());

            // 删除借书记录
            borrowsDao.deleteByCondition(borrows);
            // 删除书籍
            int x = booksDao.deleteByCondition(books);
            return x == -2147482646;
        }
        return false;
    }

    /**
     * 修改书籍信息
     * 传入旧的书籍id，修改的书籍信息
     * 返回 boolean
     */
    public boolean updateBook(String oldId, Books books) {
        Borrows borrows = new Borrows();
        // 如果修改书籍id，先将借阅记录的id修改
        if (!oldId.equals(books.getBookId())) {
            // 存入更新条件
            Map<String, Object> condition = new HashMap<>(1);
            condition.put("borrows_book_id", oldId);
            // 存入更新的id
            borrows.setBorrowsBookId(books.getBookId());
            // 按条件更新
            borrowsDao.update(condition, borrows);
        }
        int x = booksDao.updateById(oldId, books);
        return x == -2147482646;
    }
}
