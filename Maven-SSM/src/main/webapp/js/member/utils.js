var path="";
$(function(){
	path=$("#path").val();
	init();
	fruit();
	
	var size=$('#size').val();
	for(var i=1;i<=size;i++){
		var did=$('#did'+i).val();
		getSel(did,i);
	}
	
	
});

function getSel(did,i){
	if(did==i){
		$.ajax({
			url:path+"dj.do?method=sel",
			type:'post',
			data:{
				did:did
			},
			dateType:'json',
			success:function(data){
				$("#dname"+i).html(data.dname);
			}
		});
	}
}


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
			url : path+"member.do?method=grap",
			type : "post",
			dataType : "json",
			data:'',
			async : false,
			success : function(data) {
				
				bread(data, '<b style="font-size: 25px;">会员等级数量比例图</b>');
			}
		});

};



//JS生杨图形的函数
function bread(Data, title) {
	
	 $('#container').highcharts({
      chart: {
          type: 'pie',
          options3d: {
              enabled: true,
              alpha: 60,
              beta: 0
          }
      },
      title: {
          text: title
      },
      tooltip: {
          pointFormat: '会员等级数量比例图: <b>{point.percentage:.1f}%'
         
      },
      plotOptions: {
          pie: {
              allowPointSelect: true,
              cursor: 'pointer',
              depth: 95,
              dataLabels: {
                  enabled: true,
                  format:  '<b style="font-size: 14px;">{point.name}</b>:<b style="font-size: 16px;">{point.percentage:.1f} %</b>'
              }
          }
      },
      credits: {
        enabled:false
		},
      series: [{
          type: 'pie',
          data: Data
      }]
  });
};