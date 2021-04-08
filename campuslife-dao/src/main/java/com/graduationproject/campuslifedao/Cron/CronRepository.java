package com.graduationproject.campuslifedao.Cron;

import com.graduationproject.campuslifedao.userDao.WechatUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("ALL")
public interface CronRepository extends JpaRepository<Cron, Integer> {

    Cron findByCronId(String cronId);

}
