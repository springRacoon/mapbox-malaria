package com.sanguo.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: mapboxDemo
 * @description:
 * @author: Saxon
 * @create: 2021-05-28 13:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IllCase {

    /**
     * 患病数量
     */
    private Long number;

    /**
     * 所在省份名称
     */
    private String pname;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 经度
     */
    private String lng;
}
