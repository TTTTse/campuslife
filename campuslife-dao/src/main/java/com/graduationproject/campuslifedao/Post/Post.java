package com.graduationproject.campuslifedao.Post;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @program: campuslife
 * @description: 动态消息实体类
 * @author: ttttse
 * @create: 2021-04-05 16:42
 **/
@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date createTime;

    @Column(name = "tagId")
    private String tagId;

    @Column(name = "like_num")
    private Integer likeNum;

    @Column(name = "commont_num")
    private Integer commentNum;

    @Column(name = "collection_num")
    private Integer collectionNum;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "locaiton")
    private String location;
}
