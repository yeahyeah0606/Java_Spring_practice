package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    @RequestMapping("/test8")
    public  String test8(){
        System.out.println("執行 test8 方法");
        return  "Hello test8";
    }
    @RequestMapping("/test7")
    public  String test7(){
        System.out.println("執行 test7 方法");
        return  "Hello test7";
    }

    @RequestMapping("/test6")
    public  String test6(){
        throw new IllegalArgumentException("test6 error");
    }

    @RequestMapping("/test5")
    public  String test5(){
         throw new RuntimeException("test5 error");
    }

    @RequestMapping("/test4/{userid}/{name}")
    public  String test4( @PathVariable  Integer userid, @PathVariable String name ){
        System.out.println("Path id:" + userid);
        System.out.println("Path name:" + name);
        return  "Hello test4";
    }

    @RequestMapping("/test3")
    public  String test3(@RequestHeader String info){
        System.out.println("header info: "+info);
        return "Hello test3";
    }

    @RequestMapping("/test2")
    public  String test2(@RequestBody Student3 std){
        System.out.println("Student id:" +std.getId());
        System.out.println("Student name:" +std.getName());
        return "Hello Test2";
    }

    @RequestMapping("/test1")
    public  String test1(
            @RequestParam(required = false , defaultValue = "777") Integer id){
        System.out.println("id : " +id);
        return "Hello test1 "+id;
    }

    @RequestMapping("/product")
    public Store product(){
        Store store = new Store();
        List<String> list = new ArrayList<>();
       list.add("蘋果");
       list.add("西瓜");
       store.setProductList(list);
       return store;
    }
    @RequestMapping("/user")
    public  Student2 user(){
        Student2 std = new Student2();
        std.setName("Judy");
        return std;
    }

//    @Autowired
//   // @Qualifier("canonPrinter")
//   // @Qualifier("yourPrinter")
//    private  Printer printer;
//    @RequestMapping("/test")
//    public String test(){
//        printer.print("Hello World!!!");
//        //System.out.println("HI");
//        return "Hello World~";
//    }

}
