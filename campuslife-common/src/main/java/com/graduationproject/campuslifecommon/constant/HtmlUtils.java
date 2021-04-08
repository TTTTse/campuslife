package com.graduationproject.campuslifecommon.constant;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-21 23:56
 **/

public class HtmlUtils {

    public static ArrayList<String> getContent(
            String url) throws IOException {
        Document document = Jsoup.connect(url).get();
        //String title = document.head().getElementsByTag("title").text().split("_")[0];
        Elements elements = document.body().getElementsByClass("article-content");
        ArrayList<String> list = new ArrayList<String>();
        for (Element s:elements.select("p")) {
            if (s.text() == "") {
                list.add(s.select("img").attr("src"));
            } else {
                list.add(s.text());
            }
        }
        return list;
    }

}
