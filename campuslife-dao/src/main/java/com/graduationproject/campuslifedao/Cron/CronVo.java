package com.graduationproject.campuslifedao.Cron;

import lombok.*;

/**
 * @program: campuslife
 * @description:
 * @author: ttttse
 * @create: 2021-04-01 21:16
 **/

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CronVo {

    private String cronId;

    private String cron;
}
