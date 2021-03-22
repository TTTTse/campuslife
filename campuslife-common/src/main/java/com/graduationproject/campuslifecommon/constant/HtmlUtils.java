package com.graduationproject.campuslifecommon.constant;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-21 23:56
 **/

public class HtmlUtils {

    public static void main(String[] args) {
        Document document = Jsoup.parse("https://news.china.com/international/1000/20210313/39375125.html");
        Elements rows = document.select("dic[class=chan_newsInfo_source]").get(0).select("span");
        if (rows.size() == 1) {
            System.out.println("没有结果");
        }else {
            System.out.println("--------------------------- 查询结果 ---------------------------");
            Element row = rows.get(1);
            System.out.println("暂存单号:" + row.text());
//            System.out.println("投保单号:" + row.select("td").get(1).text());
//            System.out.println("保单号:" + row.select("td").get(2).text());
//            System.out.println("投保人:" + row.select("td").get(3).text());
//            System.out.println("被保险人:" + row.select("td").get(4).text());
//            System.out.println("号牌号码:" + row.select("td").get(5).text());
//            System.out.println("车架号:" + row.select("td").get(6).text());
//            System.out.println("录单人:" + row.select("td").get(7).text());
//            System.out.println("投保日期:" + row.select("td").get(8).text());
//            System.out.println("暂存单状态:" + row.select("td").get(9).text());
//            System.out.println("状态：" + row.select("td").get(10).text());
            System.out.println("-----------------------------------------------------------------");
        }

    }
}
