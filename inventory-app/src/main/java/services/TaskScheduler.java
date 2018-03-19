package services;

import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.Trigger;

public interface TaskScheduler {

	ScheduledFuture schedule(Runnable task, Trigger trigger);
}
