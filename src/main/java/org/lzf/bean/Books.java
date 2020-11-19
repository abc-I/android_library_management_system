package org.lzf.bean;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 用于接收sql的查询书籍的结果
 *
 * @author MI
 */
@Service
public class Books implements Serializable {
    /**
     * @bookId
     * 书籍id
     */
    private String bookId;
    /**
     * @bookName
     * 书名
     */
    private String bookName;
    /**
     * @author
     * 作者
     */
    private String author;
    /**
     * @classifying
     * 分类
     */
    private String classifying;
    /**
     * @price
     * 价格
     */
    private double price;
    /**
     * @size
     * 总数
     */
    private int size;
    /**
     * @part
     * 未借的书数量
     */
    private int part;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClassifying() {
        return classifying;
    }

    public void setClassifying(String classifying) {
        this.classifying = classifying;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }
}
