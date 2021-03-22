package com.graduationproject.campuslifeservice.News;


import com.graduationproject.campuslifedao.newsDao.NewsVo;

import java.util.List;

public interface NewService {
    List<NewsVo> news();
}
