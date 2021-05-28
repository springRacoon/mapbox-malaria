package com.sanguo.entity.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @program: mapboxDemo
 * @description:
 * @author: Saxon
 * @create: 2021-05-09 17:05
 */
@NoArgsConstructor
@Data
public class GeoJson {

    private String type;
    private CrsBean crs;
    private List<FeaturesBean> features;

    @NoArgsConstructor
    @Data
    public static class CrsBean {
        private String type;
        private PropertiesBean properties;

        @NoArgsConstructor
        @Data
        public static class PropertiesBean {
            private String name;
        }
    }

    @NoArgsConstructor
    @Data
    public static class FeaturesBean {
        private String type;
        private PropertiesBean properties;
        private GeometryBean geometry;

        @NoArgsConstructor
        @Data
        public static class PropertiesBean {
            private String card_id;
            private Integer now_stay_id;
            private String now_stay_address;
            private Date onset_time;
        }

        @NoArgsConstructor
        @Data
        public static class GeometryBean {
            private String type;
            private List<Double> coordinates;
        }
    }
}
