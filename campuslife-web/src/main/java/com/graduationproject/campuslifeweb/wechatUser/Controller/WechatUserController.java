package com.graduationproject.campuslifeweb.wechatUser.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.graduationproject.campuslifecommon.constant.AESUtils;
import com.graduationproject.campuslifecommon.constant.HttpRequest;
import com.graduationproject.campuslifecommon.response.ResponseResult;
import com.graduationproject.campuslifedao.userDao.WechatUser;
import com.graduationproject.campuslifedao.userDao.WechatUserVo;
import com.graduationproject.campuslifeservice.wechatUser.WechatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-07 18:48
 **/

@RestController
@RequestMapping("user")
public class WechatUserController {

    @Autowired
    private WechatUserService wechatUserService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseResult login(@RequestBody JSONObject userInfo) {
        System.out.println(userInfo);
        LinkedHashMap user = (LinkedHashMap) userInfo.get("userInfo");
        String code = (String) user.get("code");
        if (null == code || code.length() == 0) {
            return ResponseResult.builder().code(20001L).build();
        }

        String appId = "wxcfd0727920c6a276";
        String appSecret = "96ef82cea7af39c8487607663f176b4b";
        String grant_type = "authorization_code";


        String params = "appid=" + appId + "&secret=" + appSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        JSONObject json = JSONObject.parseObject(sr);
        WechatUser wechatUser = new WechatUser();
        String session_key = json.get("session_key").toString();
        String openid = (String) json.get("openid");
        if (wechatUserService.findByOpenId(openid) != null) {
            wechatUserService.updateByOpenId(openid, session_key);
            return ResponseResult.builder().code(20000L).build();
        }
        wechatUser.setOpenId(openid);
        wechatUser.setSessionKey(session_key);
        wechatUser.setGender((Integer) user.get("gender"));
        wechatUser.setProvince((String) user.get("province"));
        wechatUser.setCountry((String) user.get("country"));
        wechatUser.setAvatarUrl((String) user.get("avatarUrl"));
        wechatUser.setLanguage((String) user.get("language"));
        wechatUser.setCity((String) user.get("city"));
        wechatUser.setNickName((String) user.get("nickName"));
        wechatUserService.save(wechatUser);
        return ResponseResult.builder().data(openid).code(20000L).build();
    }

//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public ResponseResult save(@RequestBody HashMap<String, String>  user) {
//        WechatUser wechatUser = new WechatUser();
//        wechatUser.setNickName(user.get("nickName"));
//        wechatUser.setLanguage(user.get("language"));
//        wechatUser.setCity(user.get("city"));
//        wechatUser.setAvatarUrl(user.get("avatarUrl"));
//        wechatUser.setCountry(user.get("country"));
//        wechatUser.setProvince(user.get("province"));
//        wechatUser.setGender(user.get("gender"));
//        wechatUserService.save(wechatUser);
//        System.out.println(user);
//        return ResponseResult.builder().data("保存成功").build();
//    }

}
