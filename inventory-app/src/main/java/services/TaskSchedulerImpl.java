package services;

import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class TaskSchedulerImpl implements TaskScheduler {

	@Scheduled(cron = "0 15 10 15 * ?")
	public ScheduledFuture schedule(Runnable task, Trigger trigger) {
		// TODO Auto-generated method stub
		 long now = System.currentTimeMillis() / 1000;
		    System.out.println(
		      "schedule tasks using cron jobs - " + now);
		return null;
	}
}
