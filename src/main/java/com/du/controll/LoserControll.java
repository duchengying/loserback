package com.du.controll;


import com.du.entry.LoseGood;
import com.du.entry.LoserGood;
import com.du.service.LoserService;
import com.du.tool.PagedResult;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Created by dcy on 2017/12/22.
 */
@Controller
@RequestMapping("loser")
public class LoserControll {

    @Autowired
    private LoserService loserService;

    @ResponseBody
    @RequestMapping("auto_loser")
    public ArrayList<LoserGood> auto_loser(String num){

        ArrayList<LoserGood> loserGoods=loserService.selectAutoLoserGoodByNum(num);
        if(loserGoods.isEmpty()){
            return null;
        }else{
            return loserGoods;
        }
    }
    @ResponseBody
    @RequestMapping("repair_loser")
    public String repair_loser(String loserGood, String time){
        /*
        * Gson 将字符串转换成对象
        * */
        Gson gson = new Gson();
        LoserGood loserGood1 = gson.fromJson(loserGood,LoserGood.class);
        /*当id为空时，自动赋上1*/
        if(loserGood1.getLoserId()==0||loserGood1.getLoserId()==null){
            loserGood1.setLoserId(1);
        }
       /*
       * 判断时间是否输入
       *
       * 输入了则进行字符串换成日期
       *
       * */

       /* 第一版
       if(loseGood1.getLoseTime()==null){
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");


           LocalDateTime date = LocalDateTime.parse(time,f);
            loseGood1.setLoseTime(date);
        }*/
        if(time !=null&&time !=""){
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");


            LocalDateTime date = LocalDateTime.parse(time,f);
            loserGood1.setLoserTime(date);
        }
       /*
       * 开始修改
       * */
        int i=loserService.repair_loserGoodById(loserGood1);
        if(i<=0){
            return "false";
        }else {
            return "true";
        }
    }
    @ResponseBody
    @RequestMapping("delete_loser")
    public String delete_loser(String id){
        int result= loserService.delete_loserGoodById(Integer.parseInt(id));
        if(result<=0){
            return "false";
        }else {
            return "true";
        }
    }
    @ResponseBody
    @RequestMapping("add_loser")
    public String add_loser(String loserGood,String time){
        Gson gson = new Gson();
        LoserGood loserGood1 = gson.fromJson(loserGood,LoserGood.class);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime date = LocalDateTime.parse(time,f);
        loserGood1.setLoserTime(date);
        loserGood1.setLoserChecked("否");//自动添加该字段为否
        /*
        * 开始添加*/
        int s=loserService.add_loseGood(loserGood1);
        if(s<=0){
            return "false";
        }else return "true";


    }
    /*
    * 查询所有的loser信息
    * */
    @ResponseBody
    @RequestMapping("all_loser")
    public PagedResult<LoserGood> all_lose(Integer pageNumber, Integer pageSize){
        try {
            PagedResult<LoserGood> pageResult = loserService.all_loser(pageNumber, pageSize);
            return pageResult;
        } catch (Exception e) {
            return null;
        }
    }
}
