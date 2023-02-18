package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public  void addTest(){
        Calculator cal = new Calculator();
        int result = cal.add(1,2);
        assertNotNull(result);
        assertEquals(3, result, "加法有問題");
        assertTrue(result>1);
    }
    @Test
    @DisplayName("測試加法問題")
    public  void divide(){
        Calculator cal = new Calculator();
        assertThrows( ArithmeticException.class, () -> {
         cal.divide(1,0);
        });
    }
}