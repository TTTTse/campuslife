package com.graduationproject.campuslifeweb.express.Controller;

import com.graduationproject.campuslifecommon.response.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-10 01:02
 **/
@RestController
public class ExpressController {

//    @PostMapping("express")
//    public ResponseResult express(@RequestParam(value = "快递单号") Long num) {
//public static void main(String[] args) {
//    String host = "http://gwgp-65bmfhhrext.n.bdcloudapi.com/";// 【1】请求地址 支持http 和 https 及 WEBSOCKET
//        String path = "/express/query";// 【2】后缀
//        String appcode = "d3c0e831e8f54674a5094d0a14b578b5"; // 【3】开通服务后 买家中心-查看AppCode
//        String no = "SF1309960727501"; // 【4】请求参数，详见文档描述
//        String type = "auto"; //  【4】请求参数，不知道可不填 95%能自动识别
//        String urlSend = host + path + "?no=" + no + "&type=" + type; // 【5】拼接请求链接
//        try {
//            URL url = new URL(urlSend);
//            HttpURLConnection httpURLCon = (HttpURLConnection) url.openConnection();
//            httpURLCon.setRequestProperty("Authorization", "APPCODE " + appcode);// 格式Authorization:APPCODE
//            // (中间是英文空格)
//            int httpCode = httpURLCon.getResponseCode();
//            if (httpCode == 0) {
//                String json = read(httpURLCon.getInputStream());
//                System.out.println("正常请求计费(其他均不计费)");
//                System.out.println("获取返回的json:");
//                System.out.print(json);
//                //return ResponseResult.builder().data(json).build();
//            } else {
//                Map<String, List<String>> map = httpURLCon.getHeaderFields();
//                String error = map.get("X-Ca-Error-Message").get(0);
//                if (httpCode == 400 && error.equals("Invalid AppCode `not exists`")) {
//                    System.out.println("AppCode错误 ");
//                } else if (httpCode == 400 && error.equals("Invalid Url")) {
//                    System.out.println("请求的 Method、Path 或者环境错误");
//                } else if (httpCode == 400 && error.equals("Invalid Param Location")) {
//                    System.out.println("参数错误");
//                } else if (httpCode == 403 && error.equals("Unauthorized")) {
//                    System.out.println("服务未被授权（或URL和Path不正确）");
//                } else if (httpCode == 403 && error.equals("Quota Exhausted")) {
//                    System.out.println("套餐包次数用完 ");
//                } else {
//                    System.out.println("参数名错误 或 其他错误");
//                    System.out.println(error);
//                }
//            }
//        } catch (MalformedURLException e) {
//            System.out.println("URL格式错误");
//        } catch (UnknownHostException e) {
//            System.out.println("URL地址错误");
//        } catch (Exception e) {
//            // 打开注释查看详细报错异常信息
//            // e.printStackTrace();
//        }
//    }
//
//            /*
//             * 读取返回结果
//             */
//            private static String read(InputStream is) throws IOException {
//                StringBuffer sb = new StringBuffer();
//                BufferedReader br = new BufferedReader(new InputStreamReader(is));
//                String line = null;
//                while ((line = br.readLine()) != null) {
//                    line = new String(line.getBytes(), "utf-8");
//                    sb.append(line);
//                }
//                br.close();
//                return sb.toString();
//            }
        }