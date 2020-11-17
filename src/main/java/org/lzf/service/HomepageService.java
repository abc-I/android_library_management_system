package org.lzf.service;

import org.lzf.bean.Student;
import org.lzf.dao.HomepageDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 个人主页
 * @author MI
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HomepageService {

    private final HomepageDao homepageDao;

    public HomepageService(HomepageDao homepageDao) {
        this.homepageDao = homepageDao;
    }

    /**
     * 获取学生信息
     * @param stuId
     * 传入学生id
     * @return
     * 返回学生信息
     */
    public Student getMessage(String stuId) {
        return homepageDao.selectById(stuId);
    }
}
