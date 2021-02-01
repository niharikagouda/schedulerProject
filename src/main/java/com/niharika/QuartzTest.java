package com.niharika;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

public class QuartzTest {
	  public static void main(String[] args) throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		scheduler.start();
		//scheduler.shutdown();
		JobDetail job = newJob(BankTransferJob.class).withIdentity("bank-transfer").build();
		SimpleTrigger trigger= newTrigger().withIdentity("Trigger1").startNow().withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever()).build();
		
		scheduler.scheduleJob(job,trigger);
		
	}
	  public static class BankTransferJob implements Job{
		  public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException{
			  
			  System.out.println("I am transferring money to Pintuji....");
		  
	  }

}
}