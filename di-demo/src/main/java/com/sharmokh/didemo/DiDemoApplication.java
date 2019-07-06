package com.sharmokh.didemo;

import com.sharmokh.didemo.controllers.MyController;
import com.sharmokh.didemo.examplebeans.FakeDataSource;
import com.sharmokh.didemo.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);
        MyController controller = (MyController) ctx.getBean("myController");
        System.out.println(controller.hello());

        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUser());
        System.out.println(fakeDataSource.getUrl());

        FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
        System.out.println(fakeJmsBroker.getUsername());
    }

}
