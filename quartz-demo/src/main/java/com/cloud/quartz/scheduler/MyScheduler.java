package com.cloud.quartz.scheduler;

import com.cloud.quartz.job.CalcCrewAmountJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @auther: wjx
 * @Date: 2020/11/10 14:33
 * @Description:
 */
public class MyScheduler {

    public static void main(String[] args) throws Exception {
        //创建调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        //创建jobDetail实例，并与具体的job绑定
        JobDetail jobDetail = JobBuilder.newJob(CalcCrewAmountJob.class)
//                .withIdentity("")
                .usingJobData("amount", 10)
                .build();

        //创建trigger触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                //执行计划
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever()
                ).build();

        //执行
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();

        //结束job
        TimeUnit.SECONDS.sleep(3);
        scheduler.shutdown();
    }
}
