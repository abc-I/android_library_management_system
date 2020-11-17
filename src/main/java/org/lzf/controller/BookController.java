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
     * 查询书籍，返回List<Book>
     */
    @RequestMapping("/searchBook")
    public @ResponseBody List<Books> searchBookController(String bookName){
        return bookService.searchBookService(bookName);
    }
}
