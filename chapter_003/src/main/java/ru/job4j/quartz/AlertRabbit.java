package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {
    public static void main(String[] args) {
            try (Connection connection = getConnect()) {
                Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
                scheduler.start();
                JobDataMap data = new JobDataMap();
                data.put("connection", connection);
                JobDetail job = newJob(Rabbit.class)
                        .usingJobData(data)
                        .build();
                SimpleScheduleBuilder times = simpleSchedule()
                        .withIntervalInSeconds(5)
                        .repeatForever();
                Trigger trigger = newTrigger()
                        .startNow()
                        .withSchedule(times)
                        .build();
                scheduler.scheduleJob(job, trigger);
                Thread.sleep(10000);
                scheduler.shutdown();

        } catch (Exception se) {
            se.printStackTrace();
        }
    }

    private static Connection getConnect() throws Exception {
        Connection cn = null;
        try (InputStream in = AlertRabbit.class.getClassLoader().getResourceAsStream("rabbit.properties")) {
            Properties ps = new Properties();
            ps.load(in);
            Class.forName(ps.getProperty("jdbc.driver"));
            cn = DriverManager.getConnection(
                    ps.getProperty("jdbc.url"),
                    ps.getProperty("jdbc.username"),
                    ps.getProperty("jdbc.password")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cn;
    }

    public static class Rabbit implements Job {
        public Rabbit() {
            System.out.println(hashCode());
        }
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.out.println("Rabbit runs here ...");
            Connection connection = (Connection) context.getJobDetail().getJobDataMap().get("connection");
            try (PreparedStatement ps = connection.prepareStatement("insert into rabbit(name) values(?)")) {
                    ps.setString(1, String.valueOf(System.currentTimeMillis()));
                    ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}