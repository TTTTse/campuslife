package com.graduationproject.campuslifeservice.News;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.graduationproject.campuslifecommon.constant.HtmlUtils;
import com.graduationproject.campuslifecommon.constant.HttpRequest;
import com.graduationproject.campuslifedao.newsDao.NewsDao;
import com.graduationproject.campuslifedao.newsDao.NewsVo;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-17 01:07
 **/

@Service
public class NewsServiceImpl implements NewService {

    @Autowired
    private NewsDao newsDao;
    @Override
    public List<NewsVo> news() {

        String params = "key=9aed463ebce109bae9995da97b7630da&num=4";
        String sr = HttpRequest.sendGet("http://api.tianapi.com/tiyu/index", params);
        JSONObject json = JSONObject.parseObject(sr);
        List list = (List) json.get("newslist");
        List<NewsVo> newsVoList = new ArrayList<>();
        for(int i = 0; i< list.size(); i++) {
            NewsVo newsVo = new NewsVo();
            JSONObject jsonObject = (JSONObject) list.get(i);
//            String ctime = (String) jsonObject.get("ctime");
//            String picUrl = (String) jsonObject.get("picUrl");
//            String source = (String) jsonObject.get("source");
//            String title = (String) jsonObject.get("title");
            newsVo.setId(i);
            newsVo.setCtime((String) jsonObject.get("ctime"));
            newsVo.setPicUrl((String) jsonObject.get("picUrl"));
            newsVo.setSource((String) jsonObject.get("source"));
            newsVo.setTitle((String) jsonObject.get("title"));
            try {
                ArrayList list1 = HtmlUtils.getContent((String) jsonObject.get("url"));
                newsVo.setContent(list1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            newsVoList.add(newsVo);
        }
        return newsVoList;
    }

    @Override
    public void setNews2Redis() {
        newsDao.delete("news");
        List<NewsVo> list = news();
        newsDao.setNews(list);
    }

//    public static void main(String[] args) {
//        String params = "key=9aed463ebce109bae9995da97b7630da&num=4";
//        String sr = HttpRequest.sendGet("http://api.tianapi.com/tiyu/index", params);
//        JSONObject json = JSONObject.parseObject(sr);
//        List list = (List) json.get("newslist");
//        List<NewsVo> newsVoList = new ArrayList<>();
//        for(int i = 0; i< list.size(); i++) {
//            NewsVo newsVo = new NewsVo();
//            JSONObject jsonObject = (JSONObject) list.get(i);
//            newsVo.setId(i);
//            newsVo.setCtime((String) jsonObject.get("ctime"));
//            newsVo.setPicUrl((URL) jsonObject.get("picUrl"));
//            newsVo.setSource((String) jsonObject.get("source"));
//            newsVo.setTitle((String) jsonObject.get("title"));
//            try {
//                ArrayList list1 = HtmlUtils.getContent((URL) jsonObject.get("url"));
//                newsVo.setContent(list);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            list.add(newsVo);
//        }
//        JSONObject jsonObject = (JSONObject) list.get(1);
//        System.out.println(list.get(1));
//    }
}
