package com.graduationproject.campuslifedao.userDao;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

/**
 * @program: campuslife
 * @description: 微信用户实体类
 * @author: ttttse
 * @create: 2021-03-07 16:12
 **/
@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@Table(name = "we_chat_user")
public class WechatUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "open_id")
    private String openId;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "language")
    private String language;

    @Column(name = "province")
    private String province;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(name = "union_id")
    private String unionId;

    @Column(name = "session_key")
    private String sessionKey;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "update_date")
    private Date update_date;
}
