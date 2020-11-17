package org.lzf.bean;

import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author MI
 */
@Service
public class Student implements Serializable {
    /**
     * @stuId
     * 学生id
     */
    private String stuId;
    /**
     * @stuName
     * 学生姓名
     */
    private String stuName;
    /**
     * @gender
     * 学生性别
     */
    private String gender;
    /**
     * @clazz
     * 学生班级
     */
    private String clazz;
    /**
     * @mjor
     * 学生专业
     */
    private String major;
    /**
     * @college
     * 学生学院
     */
    private String college;
    /**
     * @stuTelephone
     * 学生电话
     */
    private String stuTelephone;

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getStuTelephone() {
        return stuTelephone;
    }

    public void setStuTelephone(String stuTelephone) {
        this.stuTelephone = stuTelephone;
    }
}
