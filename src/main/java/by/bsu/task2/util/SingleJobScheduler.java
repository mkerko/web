package by.bsu.task2.util;

import org.apache.log4j.BasicConfigurator;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created by Mikhail on 07.11.2017.
 */
public class SingleJobScheduler {
    public static void main(String[] args) throws SchedulerException {
        BasicConfigurator.configure();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = newJob(EmailValidatorJob.class)
                .usingJobData("email", args[0])
                .withIdentity("job1", "group1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInSeconds(2))
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }
}
