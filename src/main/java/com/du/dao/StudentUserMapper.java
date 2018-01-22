package com.du.dao;

import com.du.entry.LoseGood;
import com.du.entry.StudentUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


public interface StudentUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_user
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    int deleteByPrimaryKey(String studentNum);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_user
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    int insert(StudentUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_user
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    int insertSelective(StudentUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_user
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    StudentUser selectByPrimaryKey(String studentNum);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_user
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    int updateByPrimaryKeySelective(StudentUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_user
     *
     * @mbggenerated Mon Dec 25 21:27:10 CST 2017
     */
    int updateByPrimaryKey(StudentUser record);

    int updatePwd(@Param(value="password")String password,@Param(value="studentNum")String studentNum);

}