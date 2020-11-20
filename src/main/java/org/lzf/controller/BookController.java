package org.lzf.controller;

import org.lzf.bean.Books;
import org.lzf.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 查询书籍控制器
 * @author MI
 */
@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 查询书籍
     * 传入书名，或部分书名
     * 返回 List<Book>
     */
    @RequestMapping("/searchBook")
    public @ResponseBody List<Books> searchBookController(String bookName){
        return bookService.searchBookService(bookName);
    }

    /**
     * 书籍管理界面，显示书籍
     * 不用传数据
     * 返回 List<Books>
     */
    @RequestMapping("/bookManagement")
    public @ResponseBody List<Books> bookManagement() {
        return bookService.bookManagement();
    }

    /**
     * 添加书籍信息
     * 传入书籍表信息
     * 返回 boolean
     */
    @RequestMapping("/addBook")
    public @ResponseBody boolean addBook(Books books){
        return bookService.addBook(books);
    }

    /**
     * 删除书籍
     * 传入书籍名或书籍id
     * 返回 boolean
     */
    @RequestMapping("/deleteBook")
    public @ResponseBody boolean deleteBook(Books books) {
        return bookService.deleteBook(books);
    }

    /**
     * 修改书籍信息
     * 传入旧的id，修改的书籍信息
     * 返回 boolean
     */
    @RequestMapping("/updateBook")
    public @ResponseBody boolean updateBook(String oldId, Books books) {
        return bookService.updateBook(oldId, books);
    }
}