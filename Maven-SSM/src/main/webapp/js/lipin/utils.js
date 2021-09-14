var path="";
$(function(){
	path=$("#path").val();
	init();
	fruit();
	
	
	
	
});




function init(){
	Highcharts.setOptions({
            lang: {
               　 printChart:"打印图表",
                  downloadJPEG: "下载JPEG 图片" , 
                  downloadPDF: "下载PDF文档"  ,
                  downloadPNG: "下载PNG 图片"  ,
                  downloadSVG: "下载SVG 矢量图" , 
                  exportButtonTitle: "导出图片" 
            }
        });
};

function fruit() {
	
		$.ajax( {
			url : path+"lipin.do?method=px",
			type : "post",
			dataType : "json",
			data:'',
			async : false,
			success : function(data) {
				
				botao(data, '<b style="font-size: 25px;">礼品兑换数量</b>');
			}
		});

};



//JS生杨图形的函数
function botao(data,title){
	
	  $('#container').highcharts({
      chart: {
          type: 'column'
      },
      title: {
          text: title
      },
      subtitle: {
          text: ''
      },
      xAxis: {
          categories:data[0],
      	crosshair : true
      },
      yAxis: {
          min: 0,
          title: {
              text: '金额'
          }
      },
      tooltip: {
          headerFormat: '<span style="font-size:10px">{point.key}</span><table  style="width: 130px;">',
          pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
              '<td style="padding:0"><b>{point.y:.1f} 人</b></td></tr>',
          footerFormat: '</table>',
          shared: true,
          useHTML: true
      },
      credits: {
        enabled:false
		},
      plotOptions: {
          column: {
              pointPadding: 0.2,
              borderWidth: 0
          }
      },
      series: data[1] 
  });
};