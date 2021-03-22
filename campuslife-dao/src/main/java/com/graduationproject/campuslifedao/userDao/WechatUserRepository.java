package com.graduationproject.campuslifedao.userDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@SuppressWarnings("ALL")
public interface WechatUserRepository extends JpaRepository<WechatUser,Integer> {

    WechatUser findByOpenId(String openId);

    @Transactional
    @Modifying
    @Query(value = "update we_chat_user set session_key =: sessionKey where open_id := openId", nativeQuery = true)
    int updateByOpenID(String openId, String sessionKey);
}
