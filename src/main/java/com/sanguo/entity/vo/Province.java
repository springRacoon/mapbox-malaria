package com.sanguo.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: mapbox
 * @description:
 * @author: Saxon
 * @create: 2021-05-28 16:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

    private String name;

    private String[] geoCoord;
}
