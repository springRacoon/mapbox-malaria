package com.sanguo.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 中国行政区划
 * </p>
 *
 * @author sanguo
 * @since 2021-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ChinaXzqh implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    /**
     * 行政区划编码
     */
    private Integer code;

    /**
     * 行政区划名称
     */
    private String name;

    /**
     * 名称重命名-加政府，用于匹配经纬度
     */
    private String nameplus;

    /**
     * 行政区划全称
     */
    private String fullname;

    /**
     * 类型，1：省级，2：市级，3：县级
     */
    private String type;

    /**
     * 城市编码
     */
    private String citycode;

    /**
     * 城市名
     */
    private String cityname;

    /**
     * POI所在省份编码
     */
    private String pcode;

    /**
     * POI所在省份名称
     */
    private String pname;

    /**
     * 地址
     */
    private String address;

    /**
     * POI的电话
     */
    private String tel;

    /**
     * 高德经度
     */
    private String gdJd;

    /**
     * 高德纬度
     */
    private String gdWd;

    /**
     * 百度经度
     */
    private String bdJd;

    /**
     * 百度纬度
     */
    private String bdWd;

    /**
     * 备注
     */
    private String remark;

    private String geometry;


}
