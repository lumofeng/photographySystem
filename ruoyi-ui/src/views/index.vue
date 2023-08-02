<template>
  <div class="echart" id="mychart" :style="myChartStyle"></div>
</template>

<script>
import * as echarts from "echarts";

export default {
  data() {
    return {
      myChart: {},
      sortData: [], //动态排序数据
      myChartStyle: { float: "left", width: "100%", height: "400px" }, //图表样式
      dynamicSortZZTOption: {
        xAxis: {
          max: "dataMax"
        },
        yAxis: {
          type: "category",
          data: ["A", "B", "C", "D", "E"],
          inverse: true,
          animationDuration: 300,
          animationDurationUpdate: 300,
          max: 4 // only the largest 3 bars will be displayed
        },
        series: [
          {
            realtimeSort: true,
            name: "动态变化",
            type: "bar",
            data: [],
            label: {
              show: true,
              position: "right",
              valueAnimation: true
            }
          }
        ],
        legend: {
          show: true
        },
        animationDuration: 3000,
        animationDurationUpdate: 3000,
        animationEasing: "linear",
        animationEasingUpdate: "linear"
      }
    };
  },
  mounted() {
    // 图表初始化
    this.myChart = echarts.init(document.getElementById("mychart"));
    // 数据初始化
    for (let i = 0; i < 5; ++i) {
      this.sortData.push(Math.round(Math.random() * 200));
    }
    // 数据刷新
    setInterval(() => {
      this.pageUpdate();
    }, 3000);
  },
  methods: {
    // 数据刷新
    pageUpdate() {
      console.log(this.dynamicSortZZTOption.series[0].data);
      this.dynamicSortZZTOption.series[0].data = this.sortData;
      for (let i = 0; i < this.sortData.length; ++i) {
        if (Math.random() > 0.9) {
          this.sortData[i] += Math.round(Math.random() * 2000);
        } else {
          this.sortData[i] += Math.round(Math.random() * 200);
        }
      }
      this.myChart.setOption(this.dynamicSortZZTOption);
      //随着屏幕大小调节图表
      window.addEventListener("resize", () => {
        this.myChart.resize();
      });
    }
  }
};
</script>
