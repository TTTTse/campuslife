package com.graduationproject.campuslifeweb.RedisController;

import com.graduationproject.campuslifedao.newsDao.NewsDao;
import com.graduationproject.campuslifedao.newsDao.NewsVo;
import com.graduationproject.campuslifeservice.News.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-04-01 22:33
 **/
@RestController
public class RedisController {

    @Autowired
    private NewsDao newsDao;

    @Autowired
    private NewService newService;

    @RequestMapping("/getNews")
    public List<NewsVo> getNews(){
        return newsDao.getNews("news");
    }

    @RequestMapping("/getStr")
    public  String getStr() {
        return newsDao.getString();
    }
    @RequestMapping("/setNews")
    public String setNews(){
        //newsDao.setStringRedisTemplate();
        newsDao.delete("news");
        List<NewsVo> list = newService.news();
        newsDao.setNews(list);
        return "添加成功";
    }
}
