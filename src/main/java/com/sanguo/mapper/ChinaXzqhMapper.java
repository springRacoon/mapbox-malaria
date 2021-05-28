package com.sanguo.mapper;

import com.sanguo.entity.po.ChinaXzqh;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 中国行政区划 Mapper 接口
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
public interface ChinaXzqhMapper extends BaseMapper<ChinaXzqh> {

    void doSome(@Param("id") int id, @Param("jd")String gdJd, @Param("wd")String gdWd);
}
