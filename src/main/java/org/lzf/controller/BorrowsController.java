package org.lzf.controller;

import org.lzf.bean.Borrows;
import org.lzf.service.BorrowsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author MI
 */
@Controller
public class BorrowsController {

    private final BorrowsService borrowsService;

    public BorrowsController(BorrowsService borrowsService) {
        this.borrowsService = borrowsService;
    }

    /**
     * 查询学生借阅的书籍
     * 返回List<Borrows>
     */
    @RequestMapping("/searchBorrows")
    public @ResponseBody List<Borrows> searchBorrows(String stuId) {
        return borrowsService.searchBorrows(stuId);
    }

    /**
     * 查询所有借阅的书籍
     * 返回List<Borrows>
     */
    @RequestMapping("/borrowsManagement")
    public @ResponseBody List<Borrows> printBorrows() {
        return borrowsService.printBorrows();
    }

    /**
     * 添加借阅的书籍
     * 返回boolean
     */
    @RequestMapping("/addBorrows")
    public @ResponseBody boolean addBorrows(Borrows borrows) {
        return borrowsService.addBorrows(borrows);
    }

    /**
     * 添加归还的书籍
     * 返回boolean
     */
    @RequestMapping("/addReturn")
    public @ResponseBody boolean addReturn(Borrows borrows) {
        return borrowsService.addReturn(borrows);
    }
}
