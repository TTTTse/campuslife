package com.graduationproject.campuslifeservice.News;


import com.graduationproject.campuslifedao.newsDao.NewsVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public interface NewService {
    List<NewsVo> news();

    void setNews2Redis();
}
