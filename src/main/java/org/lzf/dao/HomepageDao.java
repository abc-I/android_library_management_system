package org.lzf.dao;

import org.lzf.bean.Student;
import org.springframework.stereotype.Repository;

/**
 * @author MI
 */
@Repository
public interface HomepageDao {
    /**
     * 通过学生id查询学生信息
     * @param stuId
     * 学生id
     * @return
     * 返回学生对象
     */
    Student selectById(String stuId);
}
