var path="";

layui.use('table', function(){
  var table = layui.table,$=layui.$;
  path=$('#path').val();
	init();
	/*fruit();*/
	
	$('#btn9').hide();
  $('#btn').hide();
  $('#btn1').hide();
  $('#btn2').hide();
  var $ = layui.$, active = {
    reload: function(){
      var oneDemoReload = $('#oneDemoReload');
      var twoDemoReload = $('#twoDemoReload');
      var threeDemoReload = $('#threeDemoReload');
      
      
    }
  };
  var oneDemoReload = $('#oneDemoReload').val();
  var twoDemoReload = $('#twoDemoReload').val();
  var threeDemoReload = $('#threeDemoReload').val();
   $("#oneDemoReload").blur(function(){
	   var oneDemoReload = $('#oneDemoReload').val();
  	if(oneDemoReload.length==0){
  		layer.tips("请输入第一个","#oneDemoReload");
  	}
  });
  $("#twoDemoReload").blur(function(){
	  var one = $('#oneDemoReload').val();
	  var twoDemoReload = $('#twoDemoReload').val();
	  if(one.length==0){
	  		layer.tips("请输入第一个","#oneDemoReload");
	  	}  
  	if(Number(twoDemoReload)<Number(one)){
  		layer.tips("请输入一个大于前面那个数的","#oneDemoReload");
  	}
  });
  $("#threeDemoReload").blur(function(){
	  var one = $('#oneDemoReload').val();
	  var two = $('#twoDemoReload').val();
	  var threeDemoReload = $('#threeDemoReload').val();
	  if(one.length==0){
	  		layer.tips("请输入第一个","#oneDemoReload");
	  	}
  	if(two.length==0){
  		layer.tips("请输入第二个","#oneDemoReload");
  	}
  	if(Number(threeDemoReload)<Number(two)){
  		layer.tips("请输入一个大于前面那个数的","#twoDemoReload");
  	}
  }); 
  
  $('.demoTable .layui-btn').on('click', function(){
    var type = $(this).data('type');
    var one = $('#oneDemoReload').val();
    var two = $('#twoDemoReload').val();
    var three = $('#threeDemoReload').val();
    if(one.length==0){
    	layer.tips("请输入第一个","#oneDemoReload");
    }else
    if(one.length!=0&&two.length==0&&three.length==0){
    	$('#d3').hide();
    	$('#d4').hide();
    	$.ajax({
    		url:path+"member.do?method=jf1",
    		type:'post',
    		data:{
    			onejf:one,
    			tt:1
    		},
    		dataType:'json',
    		success:function(data){
    			bread(data, '<b style="font-size: 25px;">会员积分比例图</b>');
    			table.render({
    			    elem: '#LAY_table_user'
    			    ,url: path+'member.do?method=dy&onejf='+one
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    			$("#onejf").text('>='+one);
    			$("#onejf1").text('<'+one);
    			$('#btn').show();
    			$('#btn9').show();
    			table.render({
    			    elem: '#LAY_table_user1'
    			    ,url: path+'member.do?method=xy&onejf='+one
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    		}
    	});
    }else
    if(one.length!=0&&two.length!=0&&three.length==0){
    	$('#d3').show();
    	$('#d4').hide();
    	$.ajax({
    		url:path+"member.do?method=jf1",
    		type:'post',
    		data:{
    			onejf:one,
    			twojf:two,
    			tt:2
    		},
    		dataType:'json',
    		success:function(data){
    			bread(data, '<b style="font-size: 25px;">会员积分比例图</b>');
    			table.render({
    			    elem: '#LAY_table_user'
    			    ,url: path+'member.do?method=xy&onejf='+one
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    			table.render({
    			    elem: '#LAY_table_user1'
    			    ,url: path+'member.do?method=dx&onejf='+one+'&twojf='+two
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    			
    			table.render({
    			    elem: '#LAY_table_user2'
    			    ,url: path+'member.do?method=xy&twojf='+two
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    			
    			
    			$('#btn9').show();
    			$("#onejf").text('<'+one);
    			$("#onejf1").text(one+'<'+two);
    			$("#onejf2").text('>'+two);
    			$('#btn').show();
    			$('#btn1').show();
    		}
    	});
    }else
    if(one.length!=0&&two.length!=0&&three.length!=0){
    	$('#d3').show();
    	$('#d4').show();
    	$.ajax({
    		url:path+"member.do?method=jf1",
    		type:'post',
    		data:{
    			onejf:one,
    			twojf:two,
    			threejf:three,
    			tt:3
    		},
    		dataType:'json',
    		success:function(data){
    			bread(data, '<b style="font-size: 25px;">会员积分比例图</b>');
    			table.render({
    			    elem: '#LAY_table_user'
    			    ,url: path+'member.do?method=xy&onejf='+one
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    			table.render({
    			    elem: '#LAY_table_user1'
    			    ,url: path+'member.do?method=dx&onejf='+one+'&twojf='+two
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    			
    			table.render({
    			    elem: '#LAY_table_user2'
    			    ,url: path+'member.do?method=xx&twojf='+two+'&threejf='+three
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    			
    			table.render({
    			    elem: '#LAY_table_user3'
    			    ,url: path+'member.do?method=xy&threejf='+three
    			    ,cols: [[
    			      {field:'rid', title: 'ID', width:100, sort: true, fixed: true}
    			      ,{field:'rcard', title: '会员卡号', width:100}
    			      ,{field:'rname', title: '会员名称', width:100, sort: true}
    			      ,{field:'raddress', title: '联系地址', width:100}
    			      ,{field:'sex', title: '性别', width:100}
    			      ,{field:'rmoney', title: '卡余额', width:100}
    			      ,{field:'rjf', title: '卡积分', width:100}
    			      ,{fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}
    			      
    			    ]]
    			    ,id: 'testReload'
    			    ,page: true
    			  });
    			$("#onejf").text('积分'+'<'+one);
    			$("#onejf1").text(one+'<积分<'+two);
    			$("#onejf2").text(two+'<积分'+three);
    			$("#onejf3").text('积分'+'>'+three);
    			$('#btn').show();
    			$('#btn1').show();
    			$('#btn2').show();
    		}
    	});
    }
    
  //监听工具条
    table.on('tool(user)', function(obj){
      var data = obj.data;
      if(obj.event === 'one'){
    	  layer.open({
			  type: 2,
			  title: 'layer mobile页',
			  shadeClose: true,
			  shade: 0.8,
			  skin: 'layui-layer-lan',
			  area: ['800px', '600px'],
			  offset: '100px',
			  title: ['查看会员详情', 'font-size:18px;'],
			  content: path+'member/sel.jsp?rid='+data.rid,//iframe的url
			}); 
      } else if(obj.event === 'del'){
        layer.confirm('真的删除行么', function(index){
          obj.del();
          layer.close(index);
        });
      } else if(obj.event === 'edit'){
        layer.alert('编辑行：<br>'+ JSON.stringify(data))
      }
    });
    
    active[type] ? active[type].call(this) : '';
  });
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
			url : path+"member.do?method=jf",
			type : "post",
			dataType : "json",
			data:'',
			async : false,
			success : function(data) {
				
				bread(data, '<b style="font-size: 25px;">会员积分比例图</b>');
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