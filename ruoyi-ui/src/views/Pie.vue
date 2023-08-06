<template>
  <div id="myChart" :style="{width: '800px', height: '600px'}"></div>
</template>
<script>
import * as echarts from 'echarts';
import {listStudentHobby} from "@/api/manage/student";
import data from "@/views/system/dict/data";
export default {
  name: "Pie",
  mounted() {
    listStudentHobby().then(response => {
      // 基于准备好的dom，初始化echarts实例
      let myChart = echarts.init(document.getElementById('myChart'))
      // 绘制图表
      myChart.setOption({
        title: {
          text: '学生兴趣分布',
          left: 'center'
        },
        tooltip: {
          trigger: 'item',
          formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
          top: 'bottom'
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        series: [
          {
            name: 'Nightingale Chart',
            type: 'pie',
            radius: [50, 250],
            center: ['50%', '50%'],
            roseType: 'area',
            itemStyle: {
              borderRadius: 8
            },
            data: response.data
          }
        ]
      })
      console.log(response.data)
    })
  }
}
</script>

