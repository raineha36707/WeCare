package com.Infy.WeCare.Exception;

public class InvalidDate extends WecareException{
    public InvalidDate(){
        this("Invalid Date");
    }

    public InvalidDate(String message) {
        super(message);
    }
}
