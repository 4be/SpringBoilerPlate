package com.abe.templates.services;

public class Calculator {

    public Integer add(Integer first,Integer second){
        return first+second;
    }

    public Integer divide(Integer first,Integer second){
        if(first ==0 || second ==0) {
            throw new IllegalArgumentException("Cannot devide by 0");
        }else {
            return first/second;
        }
    }
}
