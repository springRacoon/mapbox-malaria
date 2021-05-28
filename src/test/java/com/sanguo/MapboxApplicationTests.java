package com.sanguo;

import com.alibaba.fastjson.JSONObject;
import com.sanguo.entity.po.ChinaXzqh;
import com.sanguo.entity.po.Ill;
import com.sanguo.entity.vo.IllCase;
import com.sanguo.entity.vo.Province;
import com.sanguo.service.ChinaXzqhService;
import com.sanguo.service.IllService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;

@SpringBootTest
class MapboxApplicationTests {


    @Autowired
    private ChinaXzqhService chinaXzqhService;

    @Autowired
    private IllService illService;

    @Test
    void setIllGeo() {
        List<Ill> list = illService.list();
        for (Ill ill : list) {
            Integer id = ill.getNowStayId();
            ChinaXzqh chinaXzqh = chinaXzqhService.doSome(id);
            if(chinaXzqh==null){
                continue;
            }
            ill.setGeo(chinaXzqh.getGeometry());
        }
        System.out.println(list);
    }

    @Test
    void setChinaXzqhGeo(){
        chinaXzqhService.doSome2();
    }

    @Test
    void test(){
        List<IllCase> illCases = illService.selectNumberGroupByPname();
        System.out.println(illCases);
    }

}
