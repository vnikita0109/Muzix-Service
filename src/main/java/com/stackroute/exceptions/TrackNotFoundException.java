package com.stackroute.exceptions;

public class TrackNotFoundException extends Exception{
    private String message;
    public TrackNotFoundException(){

    }
    public TrackNotFoundException(String msg){
        this.message=msg;
    }
}
