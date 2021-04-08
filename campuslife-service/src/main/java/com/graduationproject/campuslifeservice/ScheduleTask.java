package com.graduationproject.campuslifeservice;

import com.alibaba.druid.util.StringUtils;
import com.graduationproject.campuslifedao.Cron.Cron;
import com.graduationproject.campuslifedao.Cron.CronRepository;
import com.graduationproject.campuslifedao.Cron.CronVo;
import com.graduationproject.campuslifeservice.News.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalDateTime;

/**
 * @program: campuslife
 * @description: 定时任务类
 * @author: ttttse
 * @create: 2021-04-01 20:48
 **/

@Configuration
public class ScheduleTask implements SchedulingConfigurer {

    @Autowired
    private CronRepository cronRepository;

    @Autowired
    private NewService newService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        scheduledTaskRegistrar.addTriggerTask(
                () -> newService.setNews2Redis(),
                triggerContext -> {
                    Cron cronVo = cronRepository.findByCronId("1");
                    String cron = cronVo.getCron();
                    if (StringUtils.isEmpty(cron)) {
                        cron = "0/5 * * * * ?";
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }
}
