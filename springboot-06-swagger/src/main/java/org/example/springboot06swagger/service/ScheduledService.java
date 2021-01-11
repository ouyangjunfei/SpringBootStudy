package org.example.springboot06swagger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledService.class);

    /*
    Cron表达式由7个部分组成，各部分用空格隔开，例如0 0 12 ? * WED（每星期三下午12:00 执行）
    Cron表达式的7个部分从左到右代表的含义如下
    Seconds Minutes Hours Day-of-Month Month Day-of-Week Year
    其中Year是可选的

    * ：代表整个时间段.
    / ：表示每多长时间执行一次
    0/15表示每隔15分钟执行一次,“0”表示为从“0”分开始；
    3/20表示每隔20分钟执行一次，“3”表示从第3分钟开始执行
    ? ：表示每月的某一天，或第几周的某一天
    L ：“6L”表示“每月的最后一个星期五”
    W：表示为最近工作日
    如“15W”放在每月（day-of-month）字段上表示为“到本月15日最近的工作日”
    #：是用来指定“的”每月第n个工作日
    "6#3"或者"FRI#3":在每周（day-of-week）中表示“每月第三个星期五”

    字段名                 允许的值                        允许的特殊字符
    秒                    0-59                            , - * /
    分                    0-59                            , - * /
    小时                  0-23                            , - * /
    日                    1-31                            , - * ? / L W C
    月                    1-12 or JAN-DEC                 , - * /
    周几                  1-7 or SUN-SAT                   , - * ? / L C #
    年 (可选字段)          empty, 1970-2099                 , - * /

     */

    // cron表达式：秒 分 时 日 月 星期
    // 下面表示在周一到周日的每时每分的0秒执行这个任务
    @Scheduled(cron = "0 * * * * 0-7")
    public void task() {
        /*
            30 0/5 10,18 * * ?  每天10时和18时，每隔5分钟的第30秒执行一次
         */
        LOGGER.info("定时任务被执行");
    }
}
