package com.sanguo.controller;


import com.sanguo.entity.po.GeoJson;
import com.sanguo.service.IllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
@RestController
@RequestMapping("/ill")
public class IllController {

    @Autowired
    private IllService illService;

    @GetMapping("/data")
    public GeoJson getAllIllGeoJsonData(){
        return illService.getAllIllGeoJsonData();
    }
}
