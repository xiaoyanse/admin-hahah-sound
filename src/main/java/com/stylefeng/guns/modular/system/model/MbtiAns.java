package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * mbti测评解析
 * </p>
 *
 * @author xiaoyanse123
 * @since 2018-05-24
 */
@TableName("mbti_ans")
public class MbtiAns extends Model<MbtiAns> {

    private static final long serialVersionUID = 1L;

    /**
     * 评测结果
     */
    private String id;
    /**
     * 职业
     */
    private String profession;
    /**
     * 基本分析报告
     */
    @TableField("step_1")
    private String step1;
    /**
     * 特征短评
     */
    private String features;
    /**
     * 基本描述
     */
    private String describe;
    /**
     * 盲点，误区
     */
    @TableField("blind_spot")
    private String blindSpot;
    /**
     * 工作中的劣势
     */
    @TableField("inferiority_1")
    private String inferiority1;
    /**
     * 职业发展分析报告
     */
    @TableField("step_2")
    private String step2;
    /**
     * 工作中的劣势
     */
    @TableField("inferiority_2")
    private String inferiority2;
    /**
     * 岗位的特性
     */
    @TableField("post_style")
    private String postStyle;
    /**
     * 适合的岗位
     */
    @TableField("post_suitable")
    private String postSuitable;
    /**
     * 个人发展建议
     */
    private String pdp;
    /**
     * 工作环境分析报告
     */
    @TableField("step_3")
    private String step3;
    /**
     * 组织的社会性
     */
    @TableField("sociality_og")
    private String socialityOg;
    /**
     * 组织的结构和细节关注度
     */
    @TableField("structure_detail")
    private String structureDetail;
    /**
     * 组织的开放性和想象力
     */
    @TableField("openness_imagination")
    private String opennessImagination;
    /**
     * 对组织的合作性和和谐型
     */
    @TableField("cooperative_harmonious")
    private String cooperativeHarmonious;
    /**
     * 对组织社会性的要求
     */
    private String sociality;
    /**
     * 对组织及对细节的关注度要求高
     */
    private String details;
    /**
     * 对组织的开放性和想象力要求
     */
    private String openness;
    /**
     * 对组织的合作性和和谐型要求
     */
    private String cooperative;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStep1() {
        return step1;
    }

    public void setStep1(String step1) {
        this.step1 = step1;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getBlindSpot() {
        return blindSpot;
    }

    public void setBlindSpot(String blindSpot) {
        this.blindSpot = blindSpot;
    }

    public String getInferiority1() {
        return inferiority1;
    }

    public void setInferiority1(String inferiority1) {
        this.inferiority1 = inferiority1;
    }

    public String getStep2() {
        return step2;
    }

    public void setStep2(String step2) {
        this.step2 = step2;
    }

    public String getInferiority2() {
        return inferiority2;
    }

    public void setInferiority2(String inferiority2) {
        this.inferiority2 = inferiority2;
    }

    public String getPostStyle() {
        return postStyle;
    }

    public void setPostStyle(String postStyle) {
        this.postStyle = postStyle;
    }

    public String getPostSuitable() {
        return postSuitable;
    }

    public void setPostSuitable(String postSuitable) {
        this.postSuitable = postSuitable;
    }

    public String getPdp() {
        return pdp;
    }

    public void setPdp(String pdp) {
        this.pdp = pdp;
    }

    public String getStep3() {
        return step3;
    }

    public void setStep3(String step3) {
        this.step3 = step3;
    }

    public String getSocialityOg() {
        return socialityOg;
    }

    public void setSocialityOg(String socialityOg) {
        this.socialityOg = socialityOg;
    }

    public String getStructureDetail() {
        return structureDetail;
    }

    public void setStructureDetail(String structureDetail) {
        this.structureDetail = structureDetail;
    }

    public String getOpennessImagination() {
        return opennessImagination;
    }

    public void setOpennessImagination(String opennessImagination) {
        this.opennessImagination = opennessImagination;
    }

    public String getCooperativeHarmonious() {
        return cooperativeHarmonious;
    }

    public void setCooperativeHarmonious(String cooperativeHarmonious) {
        this.cooperativeHarmonious = cooperativeHarmonious;
    }

    public String getSociality() {
        return sociality;
    }

    public void setSociality(String sociality) {
        this.sociality = sociality;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getOpenness() {
        return openness;
    }

    public void setOpenness(String openness) {
        this.openness = openness;
    }

    public String getCooperative() {
        return cooperative;
    }

    public void setCooperative(String cooperative) {
        this.cooperative = cooperative;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "MbtiAns{" +
        "id=" + id +
        ", profession=" + profession +
        ", step1=" + step1 +
        ", features=" + features +
        ", describe=" + describe +
        ", blindSpot=" + blindSpot +
        ", inferiority1=" + inferiority1 +
        ", step2=" + step2 +
        ", inferiority2=" + inferiority2 +
        ", postStyle=" + postStyle +
        ", postSuitable=" + postSuitable +
        ", pdp=" + pdp +
        ", step3=" + step3 +
        ", socialityOg=" + socialityOg +
        ", structureDetail=" + structureDetail +
        ", opennessImagination=" + opennessImagination +
        ", cooperativeHarmonious=" + cooperativeHarmonious +
        ", sociality=" + sociality +
        ", details=" + details +
        ", openness=" + openness +
        ", cooperative=" + cooperative +
        "}";
    }
}
