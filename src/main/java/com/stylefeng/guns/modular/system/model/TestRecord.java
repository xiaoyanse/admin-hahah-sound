package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 测试记录表
 * </p>
 *
 * @author xiaoyanse123
 * @since 2018-05-26
 */
@TableName("test_record")
public class TestRecord extends Model<TestRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 测试者姓名
     */
    private Integer id;
    /**
     * 测试名称
     */
    private String testname;
    /**
     * 测试分数或结果
     */
    private String testscore;
    /**
     * 测试时间
     */
    private String testtime;
    /**
     * 测试电脑ip
     */
    private String testip;
    /**
     * 测试人性别
     */
    private String sex;
    /**
     * 年龄
     */
    private String age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public String getTestscore() {
        return testscore;
    }

    public void setTestscore(String testscore) {
        this.testscore = testscore;
    }

    public String getTesttime() {
        return testtime;
    }

    public void setTesttime(String testtime) {
        this.testtime = testtime;
    }

    public String getTestip() {
        return testip;
    }

    public void setTestip(String testip) {
        this.testip = testip;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TestRecord{" +
        "id=" + id +
        ", testname=" + testname +
        ", testscore=" + testscore +
        ", testtime=" + testtime +
        ", testip=" + testip +
        ", sex=" + sex +
        ", age=" + age +
        "}";
    }
}
