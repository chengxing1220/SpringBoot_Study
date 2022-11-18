package com.tellhow.review.spring_annotation.beanlifecycle.test;

import com.tellhow.review.spring_annotation.beanlifecycle.config.BeanLifeStyleConfig;
//import com.tellhow.review.spring_annotation.beanlifecycle.pojo.SectPojo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author wujianghao
 * @date 2022年11月08日 16:17
 */

public class BeanLifeStyleTest {

    public static String addDays(String dateTime, int days) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar date = Calendar.getInstance();
            date.setTime(sdf.parse(dateTime));
            date.set(Calendar.MINUTE, date.get(Calendar.MINUTE) + days);
            return sdf.format(date.getTime());
        }
        catch (Exception e) {
            return dateTime;
        }
    }



    public static Timestamp addDayByTimestamp(Timestamp startT,int daysNum){
        Calendar c = Calendar.getInstance();
        c.setTime(startT);
        c.add(Calendar.DAY_OF_MONTH, daysNum);
        startT = new Timestamp(c.getTimeInMillis());
        return startT;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanLifeStyleConfig.class);
        applicationContext.close();

    }
}
