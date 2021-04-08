package com.graduationproject.campuslifedao.Post;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: campuslife
 * @description: 动态消息结果类
 * @author: ttttse
 * @create: 2021-04-05 18:24
 **/
@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PostVo {

    private Long id;

    private Integer userId;

    private String content;

    private Date createTime;

    private String tagId;

    private Integer likeNum;

    private Integer commentNum;

    private Integer collectionNum;

    private String imgUrl;

    private String location;
}
