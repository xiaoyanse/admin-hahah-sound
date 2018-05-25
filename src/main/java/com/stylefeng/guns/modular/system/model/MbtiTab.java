package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * mtbi表格
 * </p>
 *
 * @author xiaoyanse123
 * @since 2018-05-15
 */
@TableName("mbti_tab")
public class MbtiTab extends Model<MbtiTab> {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 题目
     */
    private String timu;
    /**
     * 选项1
     */
    private String xuanxiang1;
    /**
     * 选项2
     */
    private String xuanxiang2;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimu() {
        return timu;
    }

    public void setTimu(String timu) {
        this.timu = timu;
    }

    public String getXuanxiang1() {
        return xuanxiang1;
    }

    public void setXuanxiang1(String xuanxiang1) {
        this.xuanxiang1 = xuanxiang1;
    }

    public String getXuanxiang2() {
        return xuanxiang2;
    }

    public void setXuanxiang2(String xuanxiang2) {
        this.xuanxiang2 = xuanxiang2;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MbtiTab{" +
        "id=" + id +
        ", timu=" + timu +
        ", xuanxiang1=" + xuanxiang1 +
        ", xuanxiang2=" + xuanxiang2 +
        "}";
    }
}
