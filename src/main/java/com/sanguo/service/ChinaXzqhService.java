package com.sanguo.service;

import com.sanguo.entity.po.ChinaXzqh;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 中国行政区划 服务类
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
public interface ChinaXzqhService extends IService<ChinaXzqh> {
    ChinaXzqh doSome(Integer id);

    void doSome2();
}
