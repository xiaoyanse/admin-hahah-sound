package com.stylefeng.guns.modular.testrecord.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.TestRecord;
import com.stylefeng.guns.modular.testrecord.service.ITestRecordService;

/**
 * test_record控制器
 *
 * @author fengshuonan
 * @Date 2018-05-26 00:23:19
 */
@Controller
@RequestMapping("/testRecord")
public class TestRecordController extends BaseController {

    private String PREFIX = "/testrecord/testRecord/";

    @Autowired
    private ITestRecordService testRecordService;

    /**
     * 跳转到test_record首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "testRecord.html";
    }

    /**
     * 跳转到添加test_record
     */
    @RequestMapping("/testRecord_add")
    public String testRecordAdd() {
        return PREFIX + "testRecord_add.html";
    }

    /**
     * 跳转到修改test_record
     */
    @RequestMapping("/testRecord_update/{testRecordId}")
    public String testRecordUpdate(@PathVariable Integer testRecordId, Model model) {
        TestRecord testRecord = testRecordService.selectById(testRecordId);
        model.addAttribute("item",testRecord);
        LogObjectHolder.me().set(testRecord);
        return PREFIX + "testRecord_edit.html";
    }

    /**
     * 获取test_record列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return testRecordService.selectList(null);
    }

    /**
     * 新增test_record
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(TestRecord testRecord) {
        testRecordService.insert(testRecord);
        return SUCCESS_TIP;
    }

    /**
     * 删除test_record
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer testRecordId) {
        testRecordService.deleteById(testRecordId);
        return SUCCESS_TIP;
    }

    /**
     * 修改test_record
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(TestRecord testRecord) {
        testRecordService.updateById(testRecord);
        return SUCCESS_TIP;
    }

    /**
     * test_record详情
     */
    @RequestMapping(value = "/detail/{testRecordId}")
    @ResponseBody
    public Object detail(@PathVariable("testRecordId") Integer testRecordId) {
        return testRecordService.selectById(testRecordId);
    }
}
