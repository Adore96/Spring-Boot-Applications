package com.adore96.SpringBootCRUD;

import com.adore96.SpringBootCRUD.Bean.StudentInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootCrudApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(SpringBootCrudApplication.class, args);

        StudentInfo studentInfo = context.getBean(StudentInfo.class);


        studentInfo.Print();
    }

}
