package com.sanguo.mapper;

import com.sanguo.entity.po.Ill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sanguo.entity.vo.IllCase;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
public interface IllMapper extends BaseMapper<Ill> {

    String getAllIllGeoJsonData();

    List<IllCase> selectNumberGroupByPname();

    String[] selectDiffYears();
}
