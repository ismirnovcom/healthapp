package com.ismirnov.healthapp;

import com.ismirnov.healthapp.configurations.Config;
import com.ismirnov.healthapp.persist.*;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class HealthappApplication {

    public static void main(String[] args) {
        SpringApplication.run(HealthappApplication.class, args);

/*        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
//        SessionFactory sf = ctx.getBean("healthappSessionFactory", SessionFactory.class);
//        sf.getCurrentSession().beginTransaction();

        UserEntityDAO userDAO = ctx.getBean("userEntityDAO", UserEntityDAO.class);
        UserEntity user = userDAO.searchById(4);
//        UserEntity user = userDAO.getByEmail("user@mail.ru");
        System.out.println(user);
        for (RxEntity rx : user.getRxs()) {
            System.out.println(rx.getSymptoms() + " -> " + rx.getMedicine());
        }

        DoctorEntityDAO doctorDAO = ctx.getBean("doctorEntityDAO", DoctorEntityDAO.class);
        DoctorEntity doctor = doctorDAO.findBySpeciality("therapist");
        System.out.println(doctor);*/
    }
}
