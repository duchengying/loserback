package com.du.service;

import com.du.dao.LoseGoodMapper;
import com.du.entry.LoseGood;
import com.du.tool.BeanUtil;
import com.du.tool.PagedResult;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dcy on 2018/1/10.
 */
@Service
public class Testservice {

    @Autowired
    LoseGoodMapper loseGoodMapper;

    public PagedResult<LoseGood> queryByPage(String userName, Integer pageNo, Integer pageSize ) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(loseGoodMapper.selectAllLose());
    }
}
