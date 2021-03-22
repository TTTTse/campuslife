package com.graduationproject.campuslifeservice.wechatUser;

import com.graduationproject.campuslifedao.userDao.WechatUser;
import com.graduationproject.campuslifedao.userDao.WechatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-07 17:31
 **/

@Service("wechatUserService")
public class WechatUserServiceImpl implements WechatUserService {

    @Autowired
    WechatUserRepository wechatUserRepository;

    @Override
    public List<WechatUser> findAll() {
        List<WechatUser> wechatUsers;
        wechatUsers = wechatUserRepository.findAll();
        return wechatUsers;
    }

    @Override
    public WechatUser findByOpenId(String openId) {
        WechatUser wechatUser = wechatUserRepository.findByOpenId(openId);
        return wechatUser;
    }


    @Override
    public String save(WechatUser wechatUser) {
        wechatUserRepository.save(wechatUser);
        return "ok";
    }

    @Override
    public int updateByOpenId(String openId, String sessionKey) {
        int i = wechatUserRepository.updateByOpenID(openId, sessionKey);
        return i;
    }
}
