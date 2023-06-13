package com.hoos007.project.onlinekaraoke.util;

public class GuestIdCreate {
    private String userid;

    public GuestIdCreate(){
    }

    public String create(){
        userid = "guest#";
        userid += String.format("%08d",(int)(Math.random()*100000000));
        return userid;
    }
}
