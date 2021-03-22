package com.graduationproject.campuslifedao.userDao;

import lombok.*;

import javax.persistence.Column;
import java.sql.Date;

/**
 * @program: campuslife
 * @description: 实体类
 * @author: ttttse
 * @create: 2021-03-07 23:33
 **/
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WechatUserVo {
    private Integer id;

    private String openId;

    private String nickName;

    private Integer gender;

    private String language;

    private String province;

    private String city;

    private String country;

    private String avatarUrl;

    private String unionId;

    private String sessionKey;

    private Date create_date;

    private Date update_date;
}
