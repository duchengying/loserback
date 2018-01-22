package com.du.entry;

import org.springframework.stereotype.Component;

/**
 * Created by dcy on 2018/1/14.
 */
@Component
public class Login {

    private   String name;
    private String time;
    private String token;
    private  String num;//账号


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

}
