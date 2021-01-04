package org.lzf.controller;

import org.lzf.bean.Borrows;
import org.lzf.bean.Student;
import org.lzf.service.BorrowsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
     * 传入学生id
     * 返回 List<Borrows>
     */
    @RequestMapping("/searchBorrows")
    public @ResponseBody List<Borrows> searchBorrows(Student student) {
        System.out.println(student.getStuId());
        return borrowsService.searchBorrows(student.getStuId());
    }

    /**
     * 查询所有借阅的书籍
     * 不用传入数据
     * 返回 List<Borrows>
     */
    @RequestMapping("/borrowsManagement")
    public @ResponseBody List<Borrows> printBorrows() {
        return borrowsService.printBorrows();
    }

    /**
     * 查询归还记录
     * 不用传数据
     * 返回 List<Borrows>
     */
    @RequestMapping("/printReturn")
    public @ResponseBody List<Borrows> printReturn() {
        return borrowsService.printReturn();
    }

    /**
     * 添加借阅的书籍
     * 传入借阅书籍信息
     * 返回 boolean
     */
    @RequestMapping("/addBorrows")
    public @ResponseBody boolean addBorrows(Borrows borrows) {
        return borrowsService.addBorrows(borrows);
    }

    /**
     * 添加归还的书籍
     * 传入归还的书籍信息
     * 返回 boolean
     */
    @RequestMapping("/addReturn")
    public @ResponseBody boolean addReturn(Borrows borrows) {
        return borrowsService.addReturn(borrows);
    }
}