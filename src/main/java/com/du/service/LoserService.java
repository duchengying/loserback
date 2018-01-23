package com.du.service;

import com.du.dao.LoseGoodMapper;
import com.du.dao.LoserGoodMapper;
import com.du.entry.LoseGood;
import com.du.entry.LoserGood;
import com.du.tool.BeanUtil;
import com.du.tool.PagedResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by dcy on 2017/12/22.
 */
@Service
public class LoserService {
    @Autowired
    private LoserGoodMapper loserGoodMapper;


    /*
    * loser页面的自动查找该账号的拾物信息
    * */
    public ArrayList<LoserGood> selectAutoLoserGoodByNum(String num){
        ArrayList<LoserGood> loserGoods= loserGoodMapper.selectAutoLoserGoodByNum(num);
        if(loserGoods.isEmpty()){
            System.out.println("没有查询结果");
        }

        return  loserGoods;
    }
    /*根据id修改拾物信息*/
    public int repair_loserGoodById(LoserGood loserGood){
        int i= loserGoodMapper.updateByPrimaryKeySelective(loserGood);
        if(i<=0){
            System.out.println("修改失败");
        }
        return  i;
    }
    /*根据id删除拾物信息*/

    public ArrayList<Integer> delete_loserGoodById(int... id){
        ArrayList<Integer> error=new ArrayList<>();
        for(int d:id){
            int s=loserGoodMapper.deleteByPrimaryKey(d);
            if(s<=0){
                error.add(d);
            }
        }

        return  error;
    }

    public int delete_loserGoodById(int id){

        int s=loserGoodMapper.deleteByPrimaryKey(id);

        return  s;
    }
    /*
    * 添加单个的拾物信息
    * */
    public int add_loseGood( LoserGood loserGood){
        int s= loserGoodMapper.insert(loserGood);
        return  s;
    }

    /*
    *查询所有的loser信息-一起提交到页面
    * */

    public PagedResult<LoserGood> all_loser(Integer pageNo, Integer pageSize ) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(loserGoodMapper.selectAllLoser());
    }

    /*审核*/
    public  ArrayList<Integer> checked(int... id){
        ArrayList<Integer> error=new ArrayList<>();
        for(int d:id){
            int i=loserGoodMapper.checked(d);
            if(i<=0){
                error.add(i);
            }
        }
        return  error;
    }
    /*查询已审核的信息*/
    public  PagedResult<LoserGood> selectchecked(Integer pageNo, Integer pageSize){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(loserGoodMapper.select_checked());
    }
    /*查询未审核的信息*/
    public  PagedResult<LoserGood> selectcheck(Integer pageNo, Integer pageSize){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(loserGoodMapper.select_check());
    }
}
