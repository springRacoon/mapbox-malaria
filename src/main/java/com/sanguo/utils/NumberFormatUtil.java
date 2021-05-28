package com.sanguo.utils;

import java.text.DecimalFormat;

/**
 * @program: mapboxDemo
 * @description:
 * @author: Saxon
 * @create: 2021-05-28 12:31
 */
public class NumberFormatUtil {

    public static String numberFormat(float data) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(data);
    }
}
