package com.stylefeng.guns.modular.mbtians.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.MbtiAns;
import com.stylefeng.guns.modular.mbtians.service.IMbtiAnsService;

/**
 * mbti解析控制器
 *
 * @author fengshuonan
 * @Date 2018-05-24 21:48:29
 */
@Controller
@RequestMapping("/mbtiAns")
public class MbtiAnsController extends BaseController {

    private String PREFIX = "/mbtians/mbtiAns/";

    @Autowired
    private IMbtiAnsService mbtiAnsService;

    /**
     * 跳转到mbti解析首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "mbtiAns.html";
    }

    /**
     * 跳转到添加mbti解析
     */
    @RequestMapping("/mbtiAns_add")
    public String mbtiAnsAdd() {
        return PREFIX + "mbtiAns_add.html";
    }

    /**
     * 跳转到修改mbti解析
     */
    @RequestMapping("/mbtiAns_update/{mbtiAnsId}")
    public String mbtiAnsUpdate(@PathVariable Integer mbtiAnsId, Model model) {
        MbtiAns mbtiAns = mbtiAnsService.selectById(mbtiAnsId);
        model.addAttribute("item",mbtiAns);
        LogObjectHolder.me().set(mbtiAns);
        return PREFIX + "mbtiAns_edit.html";
    }

    /**
     * 跳转到mbti结果页面
     */
    @RequestMapping("/mbtiAns_result/{mbtiAnsId}")
    public String mbtiAnsResult() {
/*        MbtiAns mbtiAns = mbtiAnsService.selectById(mbtiAnsId);
        model.addAttribute("item",mbtiAns);
        LogObjectHolder.me().set(mbtiAns);*/
        return PREFIX + "mbtiAns_result.html";
    }
    
    

    /**
     * 获取mbti解析列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return mbtiAnsService.selectList(null);
    }

    /**
     * 新增mbti解析
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(MbtiAns mbtiAns) {
        mbtiAnsService.insert(mbtiAns);
        return SUCCESS_TIP;
    }

    /**
     * 删除mbti解析
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer mbtiAnsId) {
        mbtiAnsService.deleteById(mbtiAnsId);
        return SUCCESS_TIP;
    }

    /**
     * 修改mbti解析
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(MbtiAns mbtiAns) {
        mbtiAnsService.updateById(mbtiAns);
        return SUCCESS_TIP;
    }

    /**
     * mbti解析详情
     */
    @RequestMapping(value = "/detail/{mbtiAnsId}")
    @ResponseBody
    public Object detail(@PathVariable("mbtiAnsId") Integer mbtiAnsId) {
        return mbtiAnsService.selectById(mbtiAnsId);
    }
}
