package com.lambton;

import javax.management.timer.TimerNotification;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class Student {

    public static  void calculateRemainingTime(String scheduled_date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date scheduledDate;
        Calendar current = Calendar.getInstance();
        java.util.Date currentDate;
        String current_date = format.format(current.getTime());
        try {
            scheduledDate = format.parse(scheduled_date);
            currentDate = format.parse(current_date);


            long diff = scheduledDate.getTime() - currentDate.getTime();
            long diffHours = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS );
            long diffMinutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);
            String rTime = String.format("%d Hours, %d Minutes, %d Seconds",
                    TimeUnit.MILLISECONDS.toHours(diff),
                    TimeUnit.MILLISECONDS.toMinutes(diff)-TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(diff)),
                    TimeUnit.MILLISECONDS.toSeconds(diff)-TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(diff))
                    );


            System.out.println(rTime);
            String totalRemaining = String.format("Hours left : %d and Minutes Left : %d",diffHours,diffMinutes);
            System.out.println(totalRemaining);
        }
  catch (ParseException e)

            {
              e.printStackTrace();
            };

    }



    public static void main(String[] args) {
        System.out.println("welcome");
        LocalDate lecture;
        lecture = LocalDate.of(2019,10,20);
        LocalTime lecture1 = LocalTime.of(17,30,00);
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate curDate = LocalDate.now();
        int a = Period.between(lecture,curDate).getDays();
        int b = Period.between(lecture,curDate).getMonths();
        int c = Period.between(lecture,curDate).getYears();


calculateRemainingTime("2019-09-23 17:30");






        
    }
}