package com.stylefeng.guns.modular.mbti_sys.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.MbtiTab;
import com.stylefeng.guns.modular.mbti_sys.service.IMbtiTabService;

/**
 * mbti控制器
 *
 * @author fengshuonan
 * @Date 2018-05-15 22:43:23
 */
@Controller
@RequestMapping("/mbtiTab")
public class MbtiTabController extends BaseController {

    private String PREFIX = "/mbti_sys/mbtiTab/";

    @Autowired
    private IMbtiTabService mbtiTabService;

    /**
     * 跳转到mbti首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "mbtiTab.html";
    }

    /**
     * 跳转到添加mbti
     */
    @RequestMapping("/mbtiTab_add")
    public String mbtiTabAdd() {
        return PREFIX + "mbtiTab_add.html";
    }

    /**
     * 跳转到修改mbti
     */
    @RequestMapping("/mbtiTab_update/{mbtiTabId}")
    public String mbtiTabUpdate(@PathVariable Integer mbtiTabId, Model model) {
        MbtiTab mbtiTab = mbtiTabService.selectById(mbtiTabId);
        model.addAttribute("item",mbtiTab);
        LogObjectHolder.me().set(mbtiTab);
        return PREFIX + "mbtiTab_edit.html";
    }

    /**
     * 获取mbti列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return mbtiTabService.selectList(null);
    }

    /**
     * 新增mbti
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(MbtiTab mbtiTab) {
        mbtiTabService.insert(mbtiTab);
        return SUCCESS_TIP;
    }

    /**
     * 删除mbti
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer mbtiTabId) {
        mbtiTabService.deleteById(mbtiTabId);
        return SUCCESS_TIP;
    }

    /**
     * 修改mbti
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(MbtiTab mbtiTab) {
        mbtiTabService.updateById(mbtiTab);
        return SUCCESS_TIP;
    }

    /**
     * mbti详情
     */
    @RequestMapping(value = "/detail/{mbtiTabId}")
    @ResponseBody
    public Object detail(@PathVariable("mbtiTabId") Integer mbtiTabId) {
        return mbtiTabService.selectById(mbtiTabId);
    }
}
