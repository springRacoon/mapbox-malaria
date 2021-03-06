let map;
let bounds = [
    [71.543035, 16.764707], // Southwest coordinates，西南坐标
    [141.231996, 54.285751]  // Northeast coordinates，东北坐标
];

let timeControl = document.getElementById('slider');


//天地图的token
const tiandituToken = 'be51dd4a7507e1079f2e8bcd6030b479';
const mapboxToken = 'pk.eyJ1IjoiemF4c2Nkd2MiLCJhIjoiY2tvMHh3YnhsMDM5NDJ2bzNnYWp4YWNqaSJ9.G1Dcdqhq0fwnGuXox_n3lA';

//矢量底图
const vecwUrl = 'https://t0.tianditu.gov.cn/vec_w/wmts?' +
    'SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=vec&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles&' +
    'TILECOL={x}&TILEROW={y}&TILEMATRIX={z}&tk=' + tiandituToken;
//矢量注记
const cvawUrl = 'https://t3.tianditu.gov.cn/cva_w/wmts?' +
    'SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=cva&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles&' +
    'TILECOL={x}&TILEROW={y}&TILEMATRIX={z}&tk=' + tiandituToken;

mapboxgl.accessToken = mapboxToken;


/**
 * 向地图中添加一个栅格瓦片图层
 * @param map
 * @param url 瓦片url
 * @param sourceId 数据源id，保证唯一性即可
 * @param layerId 图层id，保证唯一性即可
 */
function addRasterTileLayer(map, url, sourceId, layerId) {
    map.addSource(sourceId, {
        type: 'raster',
        tiles: [url],
        tileSize: 256
    });
    map.addLayer({
        id: layerId,
        type: 'raster',
        source: sourceId
    });
}

/**
 * 更改时间轴年份
 * @param year 需要更改的年份
 */
function setTimeControlLabel(year) {
    document.getElementById('year').innerText = years[year];
}

/**
 * 构建时间轴
 */
function buildTimeControl() {
    document.getElementById('range-slider').style.display = 'flex';
    timeControl.setAttribute('max', years.length - 1)
    timeControl.setAttribute('value', years.length - 1);
    setTimeControlLabel(years.length - 1);
    showDataAtDate(years[years.length - 1])
}


/**
 * 过滤数据
 * @param year 显示年份
 */
function showDataAtDate(year) {
    var filters = ['==', 'year', year];
    map.setFilter('ills-heat', filters);
    map.setFilter('ills-point', filters)
}

/**
 * 根据输入框查询
 */
function filterList() {
    let filter = document.getElementById('location-filter').value
    let list_items = document.getElementById('location-list').getElementsByTagName('li');
    let clearFilter = document.getElementById('clear-filter');
    for (let i = 0; i < list_items.length; ++i) {
        let label = list_items[i].getElementsByClassName('label')[0];
        let txtValue = label.textContent || label.innerText;
        clearFilter.style.display = !!filter ? 'flex' : 'none';
        const show = txtValue.indexOf(filter) != -1;
        list_items[i].style.display = show ? 'list-item' : 'none';
    }
}

/**
 * 清空数据框
 */
function clearFilter() {
    document.getElementById('location-filter').value = '';
    filterList();
}

map = new mapboxgl.Map({
    container: 'map',
    style: {//为map构造一个空的style
        "version": 8,
        "sources": {},
        "layers": [],
    },
    minZoom: 4,
    zoom: 5,
    maxZoom: 13,
    center: [104.06, 30.67],
    maxBounds: bounds
});

//加载时触发的函数
map.on('load', function () {
    timeControl.addEventListener('input', function () {
        setTimeControlLabel(timeControl.value);
        showDataAtDate(years[timeControl.value]);
    });

    map.addSource('ills', {
        "type": "geojson",
        "data": "/ill/data"
    });

    addRasterTileLayer(map, vecwUrl, 'vecw', 'vecw')

    addRasterTileLayer(map, cvawUrl, 'cvaw', 'cvaw')

    //给map添加图层
    map.addLayer({
        "id": "ills-heat",
        "type": "heatmap",
        //与前面的资源绑定
        "source": "ills",
        "maxZoom": 13,
        "paint": {
            //根据频率和属性大小增加热图权重
            "heatmap-weight": [
                "interpolate",
                ["linear"],
                ["get", "now_stay_id"],
                2, 0.1,
                50, 0.2,
                100, 0.3,
                200, 0.4
            ],
            //按缩放级别增加热图颜色权重
            "heatmap-intensity": [
                "interpolate",
                ["linear"],
                ["zoom"],
                0, 1,
                13, 3
            ],
            // 颜色渐变  Domain is 0 (low) to 1 (high).
            // 创建模糊效果
            "heatmap-color": [
                "interpolate",
                ["linear"],
                ["heatmap-density"],
                0, "rgba(33,102,172,0)",
                0.4, "rgb(122,209,241)",
                0.7, "rgb(239,138,98)",
                1, "rgb(178,24,43)"
            ],
            //按缩放级别调整热图半径
            "heatmap-radius": [
                "interpolate",
                ["linear"],
                ["zoom"],
                0, 2,
                13, 32
            ],
            //通过缩放级别从热图过渡到圆形层
            "heatmap-opacity": [
                "interpolate",
                ["linear"],
                ["zoom"],
                8, 1,
                13, 0
            ],
        }
    }, 'cvaw');

    map.addLayer({
        "id": "ills-point",
        "type": "circle",
        "source": "ills",
        "minZoom": 8,
        "paint": {
            "circle-radius": [
                "interpolate",
                ["linear"],
                ["zoom"],
                7,
                [
                    "interpolate",
                    ["linear"],
                    ["get", "now_stay_id"],
                    1, 1,
                    6, 4
                ],
                16,
                [
                    "interpolate",
                    ["linear"],
                    ["get", "now_stay_id"],
                    1, 5,
                    6, 32
                ]
            ],

            //根据地震震级改变圈的色彩
            "circle-color": [
                "interpolate",
                ["linear"],
                ["get", "now_stay_id"],
                0, "rgba(33,102,172,0)",
                0.1, "rgb(116,226,243)",
                0.3, "rgb(239,138,98)",
                0.5, "rgb(178,24,43)"
            ],
            "circle-stroke-color": "white",
            "circle-stroke-width": 1,
            // //通过缩放级别从热图过渡到圆形层
            "circle-opacity": [
                "interpolate",
                ["linear"],
                ["zoom"],
                8, 0,
                13, 1
            ]
        }
    }, 'ills-heat');

    //实例化导航控件
    var nav = new mapboxgl.NavigationControl(
        {
            //是否显示指南针，默认为true
            "showCompass": false,
            //是否显示缩放按钮，默认为true
            "showZoom": true
        }
    );
    //添加导航控件，控件的位置包括'top-left', 'top-right','bottom-left' ,'bottom-right'四种，默认为'top-right'
    map.addControl(nav, 'top-right');

    buildTimeControl();
});


/**
 * 跳转城市坐标
 * @param lng 经度
 * @param lat 纬度
 */
function toCity(lng, lat) {
    map.flyTo({
        center: [lng, lat],
        zoom: 8
    })
}

/**
 * 跳转至地图中心
 */
function toNation() {
    map.flyTo({
        center: [104.06, 30.67],
        zoom: 5
    })
}