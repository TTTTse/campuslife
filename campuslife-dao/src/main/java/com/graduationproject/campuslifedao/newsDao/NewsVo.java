package com.graduationproject.campuslifedao.newsDao;

import lombok.*;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-03-17 01:01
 **/

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class NewsVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private String picUrl;

    private String ctime;

    private String title;

    private String source;

    private List content;

}
