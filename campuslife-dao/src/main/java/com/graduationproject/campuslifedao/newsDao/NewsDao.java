package com.graduationproject.campuslifedao.newsDao;

import com.graduationproject.campuslifedao.newsDao.NewsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-04-01 22:24
 **/

@Repository
public class NewsDao {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valueOperations;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> objectObjectValueOperations;

    public boolean setNews(List<NewsVo> newsVo) {
        objectObjectValueOperations.set("news", newsVo);
        return true;
    }

    public void setStringRedisTemplate() {
        valueOperations.set("xx", "yy");
    }
    public String getString() {
        return valueOperations.get("xx");
    }
    public List<NewsVo> getNews(String key) {
        List<NewsVo> newsVo = (List<NewsVo>) objectObjectValueOperations.get(key);
        return newsVo;
    }

    public void delete(String key) {
        objectObjectValueOperations.getOperations().delete(key);
    }
}
