package com.nehemie.walkaround;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    private MyFirstClass myFirstClass;

    // Constructor Dependency Injection (Recommended);
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    // Method Dependency Injection;
//    @Autowired
//    public void injectDependencies(@Qualifier("mySecondBean") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

    // Setter Method Dependency Injection;
//    @Autowired
//    public void setMyFirstClass(@Qualifier("bean1") MyFirstClass myFirstClass) {
//        this.myFirstClass = myFirstClass;
//    }

    public String tellAStory() {
        return "The dependency is saying: " + myFirstClass.sayHello();
    }
}
