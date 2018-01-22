package com.du.tool;

import com.du.dao.LoseGoodMapper;
import com.du.dao.LoserGoodMapper;
import com.du.entry.LoseGood;
import com.du.entry.LoserGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by dcy on 2018/1/3.
 */
/*
* 搜索信息
*
* 关键词-key，  失物/拾物-lose  物品类别-type  时间-time   地点-local
* */

@Component
public class AutoSearch {

    @Autowired(required = false)
    LoseGoodMapper loseGoodMapper;
    @Autowired(required = false)
    LoserGoodMapper loserGoodMapper;
/*
* 参数：lose-失物/拾物，key-关键词，type-物品类别，time-时间，local-地点
* */
    public ArrayList<?> search(String lose,String key,String type,String time,String local){

        if(lose=="失物"){

            return lose_search(key, type, time, local);
        }else if(lose=="拾物"){
            return  loser_search(key, type, time, local);
        }else {

            System.out.println("不能输入空的失物或者拾物");
            return null;
        }

    }

    private ArrayList<LoseGood> lose_search(String key,String type,String time,String local){

         ArrayList<LoseGood> loseGoods=loseGoodMapper.searchByKey(key, type, time, local);
         return loseGoods;

    }

    private ArrayList<LoserGood> loser_search(String key,String type,String time,String local){

        ArrayList<LoserGood> loserGoods=loserGoodMapper.searchByKey(key, type, time, local);
        return loserGoods;

    }
   /* public ArrayList<T> search(String lose){


    }
    public ArrayList<T> search(String lose,String key,String type){


    }
    public ArrayList<T> search(String lose,String key,String time){


    }
    public ArrayList<T> search(String lose,String key,String local){


    }*/

}
