package com.sanguo.service;

import com.sanguo.entity.po.GeoJson;
import com.sanguo.entity.po.Ill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sanguo.entity.vo.IllCase;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
public interface IllService extends IService<Ill> {

    GeoJson getAllIllGeoJsonData();

    long selectCount();

    List<IllCase> selectNumberGroupByPname();
}
