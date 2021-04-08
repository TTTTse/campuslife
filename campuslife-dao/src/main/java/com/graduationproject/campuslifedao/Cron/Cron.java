package com.graduationproject.campuslifedao.Cron;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @program: campuslife
 * @description: cron实体类
 * @author: ttttse
 * @create: 2021-04-01 21:13
 **/
@Entity
@Setter
@Getter
@Data
@NoArgsConstructor
@Table(name = "cron")
public class Cron {

    @Id
    @Column(name = "cron_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cronId;

    @Column(name = "cron")
    private String cron;
}
