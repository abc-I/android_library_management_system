package org.lzf.controller;

import org.lzf.bean.Student;
import org.lzf.service.HomepageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取主页信息
 * @author MI
 */
@Controller
public class HomepageController {

    private final HomepageService homepageService;

    public HomepageController(HomepageService homepageService) {
        this.homepageService = homepageService;
    }

    /**
     * 查询学生信息
     * 传入学生id
     * 返回Student对象
     */
    @RequestMapping("/homepage")
    public @ResponseBody Student getMessage(String stuId){
        return homepageService.getMessage(stuId);
    }
}