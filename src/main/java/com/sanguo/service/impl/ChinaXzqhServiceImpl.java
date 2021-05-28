package com.sanguo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sanguo.entity.po.ChinaXzqh;
import com.sanguo.mapper.ChinaXzqhMapper;
import com.sanguo.service.ChinaXzqhService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 中国行政区划 服务实现类
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
@Service
public class ChinaXzqhServiceImpl extends ServiceImpl<ChinaXzqhMapper, ChinaXzqh> implements ChinaXzqhService {

    @Autowired
    private ChinaXzqhMapper chinaXzqhMapper;

    @Override
    public ChinaXzqh doSome(Integer id) {
        QueryWrapper<ChinaXzqh> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("geometry").eq("code",id+"");
        ChinaXzqh chinaXzqh = chinaXzqhMapper.selectOne(queryWrapper);
        return chinaXzqh;
    }

    @Override
    public void doSome2() {
        List<ChinaXzqh> list = this.list();
        for (ChinaXzqh chinaXzqh : list) {
            chinaXzqhMapper.doSome(chinaXzqh.getId(),chinaXzqh.getGdJd(),chinaXzqh.getGdWd());
        }
    }


}
