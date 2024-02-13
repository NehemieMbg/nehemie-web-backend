package com.nehemie.walkaround;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyFirstClass {
    
    private String myVar;

    public MyFirstClass(@Value("Something new") String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "Hello from the MyFirstClass ==> myVar = " + myVar;
    }
}
