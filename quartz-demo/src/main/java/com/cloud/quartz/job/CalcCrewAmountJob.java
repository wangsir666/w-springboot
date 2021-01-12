package com.cloud.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @auther: wjx
 * @Date: 2020/11/10 14:28
 * @Description:
 */
public class CalcCrewAmountJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("*****start********");
        System.out.println(Thread.currentThread().getName()+"....");
        System.out.println(context.getMergedJobDataMap().getInt("amount"));
//        System.out.println(context.get("amount"));
        System.out.println("********end********");
    }
}
