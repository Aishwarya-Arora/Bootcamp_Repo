package com.assignment.spring.Assignment.Q6;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class HotTea implements Tea {
    @Override
    public void drink() {
        System.out.println("Hot Tea is ready");
    }
}
