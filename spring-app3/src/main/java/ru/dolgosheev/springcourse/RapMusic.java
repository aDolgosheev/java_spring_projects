package ru.dolgosheev.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
public class RapMusic implements Music {

//    @PostConstruct
//    public void doMyInit() {
//        System.out.println("Doing my initialization");
//    }
//
//    @PreDestroy
//    public void doMyDestroy() {
//        System.out.println("Doing my destruction");
//    }

    private final List<String> musicPlaylist = Arrays.asList("99 problems", "Candy shop", "Stan");
    @Override
    public String getSong(int i) {
        return musicPlaylist.get(i);
    }
}
