package org.lzf.service;

import org.lzf.bean.Books;
import org.lzf.dao.BooksDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 查询书籍逻辑运行
 * @author MI
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookService {

    private final BooksDao booksDao;

    public BookService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    /**
     * 通过书名查询
     * @param bookName
     * 前端查询的书名
     * @return
     * 返回的书
     */
    public List<Books> searchBookService(String bookName) {
        return booksDao.select(bookName);
    }
}
