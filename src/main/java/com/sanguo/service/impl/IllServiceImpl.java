package com.sanguo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sanguo.entity.po.GeoJson;
import com.sanguo.entity.po.Ill;
import com.sanguo.entity.vo.IllCase;
import com.sanguo.entity.vo.Province;
import com.sanguo.mapper.IllMapper;
import com.sanguo.service.IllService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sanguo.utils.ReadJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
@Service
public class IllServiceImpl extends ServiceImpl<IllMapper, Ill> implements IllService {


    @Autowired
    private IllMapper illMapper;

    @Override
    public GeoJson getAllIllGeoJsonData() {
        String geoJson = illMapper.getAllIllGeoJsonData();
        GeoJson json = JSONObject.parseObject(geoJson, GeoJson.class);
        return json;
    }

    @Override
    public long selectCount() {
        return illMapper.selectCount(null);
    }

    @Override
    public List<IllCase> selectNumberGroupByPname() {
        List<IllCase> illCases = illMapper.selectNumberGroupByPname();
        String provinces = ReadJsonUtil.readJsonFile("province.json");
        List<Province> lists = JSONObject.parseArray(provinces, Province.class);
        List<IllCase> res = illCases.stream().peek(illCase -> {
            Province province = lists.stream().filter(list -> {
                return illCase.getPname().contains(list.getName());
            }).collect(Collectors.toList()).get(0);
            illCase.setLng(province.getGeoCoord()[0]);
            illCase.setLat(province.getGeoCoord()[1]);
        }).collect(Collectors.toList());
        return res;
    }

    @Override
    public String[] selectDiffYears() {
        return illMapper.selectDiffYears();
    }
}
