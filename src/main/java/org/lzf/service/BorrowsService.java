package org.lzf.service;

import org.lzf.bean.Books;
import org.lzf.bean.Borrows;
import org.lzf.dao.BooksDao;
import org.lzf.dao.BorrowsDao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

/**
 * @author MI
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BorrowsService {
    private final BorrowsDao borrowsDao;
    private final Calendar calendar = Calendar.getInstance();
    private final BooksDao booksDao;

    /**
     * 初始化
     */
    public BorrowsService(BorrowsDao borrowsDao,BooksDao booksDao) {
        this.booksDao = booksDao;
        this.borrowsDao = borrowsDao;
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
        return borrowsDao.selectByReturnTime(true);
    }

    /**
     * 查询归还记录界面，显示所有借阅的书籍
     * 不用传入数据
     * @return 返回 List<Borrows>
     */
    public List<Borrows> printReturn() {
        return borrowsDao.selectByReturnTime(false);
    }

    /**
     * 添加借阅书籍
     * @param borrows
     * 传入借阅书籍id、借阅学生的id
     * @return
     * 返回是否成功
     */
    public boolean addBorrows(Borrows borrows) {
        // 按照要借阅的书籍id查询书籍
        Books books = booksDao.selectById(borrows.getBorrowsBookId());
        // 封装获取到的书籍名
        borrows.setBorrowsBookName(books.getBookName());
        // 封装当前年月日
        borrows.setBorrowsTime(
                calendar.get(Calendar.YEAR) + "-"
                        + (calendar.get(Calendar.MONTH) + 1) + "-"
                        + calendar.get(Calendar.DATE)
        );
        // 插入借阅书籍信息
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
        // 封装删除条件
        Map<String, Object> condition = new HashMap<>(2);
        condition.put("borrows_book_id",borrows.getBorrowsBookId());
        condition.put("borrows_stu_id",borrows.getBorrowsStuId());
        // 封装还书时间
        borrows.setReturnTime(
                calendar.get(Calendar.YEAR) + "-"
                        + (calendar.get(Calendar.MONTH) + 1) + "-"
                        + calendar.get(Calendar.DATE)
        );

        // 删除一年前的借阅记录
        borrowsDao.deleteByReturnTime(
                (calendar.get(Calendar.YEAR) - 1) + "-"
                    + (calendar.get(Calendar.MONTH) + 1) + "-"
                    + calendar.get(Calendar.DATE)
        );
        // 添加还书时间
        int x = borrowsDao.update(condition,borrows);
        return x == -2147482646;
    }
}
