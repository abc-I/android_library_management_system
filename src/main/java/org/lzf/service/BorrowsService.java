package org.lzf.service;

import org.lzf.bean.Books;
import org.lzf.bean.Borrows;
import org.lzf.dao.BorrowsDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author MI
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BorrowsService {
    private final BorrowsDao borrowsDao;
    private final SimpleDateFormat dateFormat;

    /**
     * 初始化
     */
    public BorrowsService(BorrowsDao borrowsDao) {
        this.borrowsDao = borrowsDao;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * 通过学生id查询借阅的书籍
     * @param stuId
     * 学生id
     * @return
     * 查询结果
     */
    public List<Borrows> searchBorrows(String stuId) {
        return borrowsDao.selectById(stuId);
    }

    /**
     * 管理界面显示所有借阅的书籍
     * @return
     * 返回查询结果
     */
    public List<Borrows> printBorrows() {
        return borrowsDao.selectAll();
    }

    /**
     * 添加借阅书籍
     * @param borrows
     * 传入借阅书籍的信息
     * @return
     * 返回是否成功
     */
    public boolean addBorrows(Borrows borrows) {
        Books books = borrowsDao.selectByName(borrows.getBorrowsBookName());
        borrows.setBorrowsBookId(books.getBookId());
        borrows.setBorrowsTime(dateFormat.format(new Date()));
        int x = borrowsDao.insert(borrows);
        return x == -2147482646;
    }

    /**
     * 归还书籍
     * @param borrows
     * 传入借阅书籍的信息
     * @return
     * 返回是否成功
     */
    public boolean addReturn(Borrows borrows) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("borrows_book_name",borrows.getBorrowsBookName());
        condition.put("borrows_stu_id",borrows.getBorrowsStuId());
        borrows.setReturnTime(dateFormat.format(new Date()));
        int x = borrowsDao.update(condition,borrows);
        return x == -2147482646;
    }
}
