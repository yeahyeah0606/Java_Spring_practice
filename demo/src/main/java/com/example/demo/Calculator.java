package com.example.demo;

public class Calculator {
    public  int add(int x, int y){
        return  x+y;
    }
    public  int divide(int x, int y){
        return  x/y;
    }
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int result = cal.add(3,5);
        System.out.println("結果為: "+ result);
    }
}
