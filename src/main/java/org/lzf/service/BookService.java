package org.lzf.service;

import org.lzf.bean.Books;
import org.lzf.bean.Borrows;
import org.lzf.dao.BooksDao;
import org.lzf.dao.BorrowsDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    private final Borrows borrows;

    public BookService(BooksDao booksDao, BorrowsDao borrowsDao, Borrows borrows) {
        this.booksDao = booksDao;
        this.borrowsDao = borrowsDao;
        this.borrows = borrows;
    }

    /**
     * 通过书名查询
     *
     * @param bookName 前端查询的书名
     * @return 返回的书
     */
    public List<Books> searchBookService(String bookName) {
        return booksDao.select(bookName);
    }

    public List<Books> bookManagement() {
        return booksDao.selectAll();
    }

    public boolean addBook(Books books) {
        int x = booksDao.insert(books);
        return x == -2147482646;
    }

    public boolean deleteBook(Books books) {
        if (books.getBookId() != null) {
            borrows.setBorrowsBookId(books.getBookId());
            borrows.setBorrowsBookName(books.getBookName());
            borrowsDao.deleteByCondition(borrows);
            int x = booksDao.deleteByCondition(books);
            return x == -2147482646;
        }
        return false;
    }

    public boolean updateBook(String oldId, Books books) {
        int x = booksDao.updateById(oldId, books);
        return x == -2147482646;
    }
}
