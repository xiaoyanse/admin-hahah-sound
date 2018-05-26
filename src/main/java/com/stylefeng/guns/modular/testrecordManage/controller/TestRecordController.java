package com.stylefeng.guns.modular.testrecordManage.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.stylefeng.guns.core.util.ToolUtil;

import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TestRecord;
import com.stylefeng.guns.modular.system.model.Timu;
import com.stylefeng.guns.modular.testrecordManage.service.ITestRecordService;

/**
 * testrecord控制器
 *
 * @author fengshuonan
 * @Date 2018-05-26 02:02:35
 */
@Controller
@RequestMapping("/testRecord")
public class TestRecordController extends BaseController {

    private String PREFIX = "/testrecordManage/testRecord/";

    @Autowired
    private ITestRecordService testRecordService;

    /**
     * 跳转到testrecord首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "testRecord.html";
    }
    /**
     * 跳转到usertestrecord首页
     */
    @RequestMapping("/usertestrecord")
    public String userindex() {
        return PREFIX + "usertestrecord.html";
    }

    /**
     * 跳转到添加testrecord
     */
    @RequestMapping("/testRecord_add")
    public String testRecordAdd() {
        return PREFIX + "testRecord_add.html";
    }

    /**
     * 跳转到修改testrecord
     */
    @RequestMapping("/testRecord_update/{testRecordId}")
    public String testRecordUpdate(@PathVariable Integer testRecordId, Model model) {
        TestRecord testRecord = testRecordService.selectById(testRecordId);
        model.addAttribute("item",testRecord);
        LogObjectHolder.me().set(testRecord);
        return PREFIX + "testRecord_edit.html";
    }

    /**
     * 获取testrecord列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return testRecordService.selectList(null);
    }
    
    
    /**
     * 根据name获取题目管理列表
     */
    @RequestMapping(value = "/list/{commeee}")
    @ResponseBody
    public Object listbyshitino(@PathVariable String commeee) {
		System.out.println("commeee账号:"+commeee);

    	if (ToolUtil.isEmpty(commeee)) {
            return testRecordService.selectList(null);
		}else {
			EntityWrapper<TestRecord> wrapper=new EntityWrapper<>();
			Wrapper<TestRecord> result=wrapper.where("commeee='"+commeee+"'");
			return testRecordService.selectList(result);	 
		}
    }


    /**
     * 新增testrecord
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TestRecord testRecord) {
        testRecordService.insert(testRecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除testrecord
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer testRecordId) {
        testRecordService.deleteById(testRecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改testrecord
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TestRecord testRecord) {
        testRecordService.updateById(testRecord);
        return SUCCESS_TIP;
    }

    /**
     * testrecord详情
     */
    @RequestMapping(value = "/detail/{testRecordId}")
    @ResponseBody
    public Object detail(@PathVariable("testRecordId") Integer testRecordId) {
        return testRecordService.selectById(testRecordId);
    }
}
