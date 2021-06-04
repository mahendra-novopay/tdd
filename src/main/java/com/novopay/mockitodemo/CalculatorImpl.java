package com.novopay.mockitodemo;

public class CalculatorImpl implements Calculator{
    @Override
    public Long addLong(Long a, Long b) {
        System.out.println("I got called");
        return a+b;
    }

    @Override
    public Long substractLong(Long a, Long b) {
        return a-b;
    }
}
