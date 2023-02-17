package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HpPrinter implements Printer{
//    @Value("${printer.name:Kelly's Printer}")
//    private String name;
//    @Value("${printer.count}")
//    private int count;
//    @PostConstruct
//    public  void init(){
//        count = 5;
//    }
    @Override
    public void print(String message) {
        System.out.println("HP印表機 : " + message );
//        count--;
//        System.out.println("HP印表機 : " + message );
//        System.out.println("剩餘使用次數 : " +count);
//        System.out.println("name: "+name);
    }
}
