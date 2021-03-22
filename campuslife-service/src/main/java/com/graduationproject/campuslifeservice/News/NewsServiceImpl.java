package com.graduationproject.campuslifeservice.News;

import com.alibaba.fastjson.JSONObject;
import com.graduationproject.campuslifecommon.constant.HttpRequest;
import com.graduationproject.campuslifedao.newsDao.NewsVo;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-17 01:07
 **/

public class NewsServiceImpl implements NewService {
    @Override
    public List<NewsVo> news() {

        String params = "?key=" + "9aed463ebce109bae9995da97b7630da" + "&num=" + "4";
        String sr = HttpRequest.sendGet("http://api.tianapi.com/tiyu/index", params);
        JSONObject json = JSONObject.parseObject(sr);
        return null;
    }

    public static void main(String[] args) {
        String params = "key=9aed463ebce109bae9995da97b7630da&num=4";
        String sr = HttpRequest.sendGet("http://api.tianapi.com/tiyu/index", params);
        JSONObject json = JSONObject.parseObject(sr);
        List list = (List) json.get("newslist");
        JSONObject jsonObject = (JSONObject) list.get(0);
        System.out.println(jsonObject);
    }
}
