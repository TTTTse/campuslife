package com.graduationproject.campuslifeservice.wechatUser;

import com.graduationproject.campuslifedao.userDao.WechatUser;

import java.util.List;

public interface WechatUserService {

    List<WechatUser> findAll();

    WechatUser findByOpenId(String openId);

    String save(WechatUser wechatUser);

    int updateByOpenId(String openId, String sessionKey);
}
