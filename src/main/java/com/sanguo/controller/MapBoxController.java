package com.sanguo.controller;


import com.alibaba.fastjson.JSONObject;
import com.sanguo.entity.vo.IllCase;
import com.sanguo.entity.vo.Province;
import com.sanguo.service.IllService;
import com.sanguo.utils.NumberFormatUtil;
import com.sanguo.utils.ReadJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MapBoxController {

    @Autowired
    private IllService illService;


    @RequestMapping("/mapbox")
    public String hello(Model model) {
        long totalNumber = illService.selectCount();
        List<IllCase> illCases = illService.selectNumberGroupByPname();
        model.addAttribute("totalNumber", NumberFormatUtil.numberFormat(totalNumber));
        model.addAttribute("illCases", illCases);
        return "index";
    }
}
