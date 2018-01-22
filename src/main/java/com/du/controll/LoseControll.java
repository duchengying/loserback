package com.du.controll;

import com.du.entry.LoseGood;

import com.du.service.LoseService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 * Created by dcy on 2017/12/22.
 */
@RestController
@RequestMapping("lose")
public class LoseControll {

    @Autowired
    private  LoseService loseService;

    /*自动查询自己添加的列表
    * 重点在添加信息
    * */
    @RequestMapping("auto_lose")
    @ResponseBody
    public ArrayList<LoseGood> auto_lose(String num){
        ArrayList<LoseGood> loseGoods=loseService.selectAutoLoseGoodByNum(num);
        System.out.println(loseGoods.get(0).getLoseTime());
        if(loseGoods.isEmpty()){
            return null;
        }else{
            return loseGoods;
        }
    }
    /*根据lose对象的内容来更新*/
    @ResponseBody
    @RequestMapping(value = "repair_lose")
    public String  repair_lose(String loseGood, String time){
        /*这里的losegood的id不能为空，否则不能自动装配
        *
        * 猜测：可能由于id是integer类型
        * 验证：将id该成String，就可以了，不会提示空指针
        *
        * 注：没有值的loseGood 属性将赋“”，而不会为null
        * */
       // LoseGood loseGood1 = (LoseGood)JSONObject.toBean(loseGood,LoseGood.class);
        /*System.out.println(loseGood);
           /*System.out.println( JSONObject.toJSONString(loseGood));
        LoseGood loseGood1 = JSON.parseObject(JSONObject.toJSONString(loseGood), new TypeReference<LoseGood>(){});*/
        /*
        * Gson 将字符串转换成对象
        * */
        Gson gson = new Gson();
        LoseGood loseGood1 = gson.fromJson(loseGood,LoseGood.class);
        /*当id为空时，自动赋上1*/
        if(loseGood1.getLoseId()==0||loseGood1.getLoseId()==null){
            loseGood1.setLoseId(1);
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
           System.out.println(time+"这是直接打印时间");
           loseGood1.setLoseTime(date);
       }
       /*
       * 开始修改
       * */
        System.out.println("这是test文本");
        System.out.println("这是打印对象中的时间"+loseGood1.getLoseTime());
        int i=loseService.repair_loseGoodById(loseGood1);
        if(i<=0){
            return "false";
        }else {
            return "true";
        }
    }
    /*删除 -id*/
    @ResponseBody
    @RequestMapping("delete_lose")
    public String delete_lose(String id){
       int result= loseService.delete_loseGoodById(Integer.parseInt(id));
        if(result<=0){
            return "false";
        }else {
            return "true";
        }
    }
    /*添加
    * 添加信息后 会自动搜索相关的信息得出结果
    *
    * */
    @ResponseBody
    @RequestMapping("add_lose")
    public String add_lose(String loseGood,String time){

        Gson gson = new Gson();
        LoseGood loseGood1 = gson.fromJson(loseGood,LoseGood.class);
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime date = LocalDateTime.parse(time,f);
        System.out.println(time+"这是直接打印时间");
        loseGood1.setLoseTime(date);
        loseGood1.setLoseChecked("否");//自动添加该字段为否
        /*
        * 开始添加*/
        System.out.println(loseGood);
        System.out.println("得到实体的name"+loseGood1.getLoseName());
        int s=loseService.add_loseGood(loseGood1);
        if(s<=0){
            return "false";
        }else return "true";


    }
    /*查询所有的lose信息--分页处理*/
    @RequestMapping("all_lose")
    @ResponseBody
    public ArrayList<LoseGood> all_lose(){
        System.out.println("tesat");

        ArrayList<LoseGood> loseGoods=loseService.all_lose();

        return loseGoods;
    }

    /*添加信息后 会自动搜索相关的信息得出结果*/

}
