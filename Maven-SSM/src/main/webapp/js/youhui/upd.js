var path="";
var flag=0;
var yid;
var x;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	yid=$('#yid').val();
	
	$.ajax({
		url:path+"youhui.do?method=sel",
		type:'post',
		data:{
			yid:yid
		},
		dataType:'json',
		success:function(data){
			$('#test1').val(data.ybegintime);
			$('#test2').val(data.yendtime);
			$('#ytitle').val(data.ytitle);
			$('#ylessmoney').val(data.ylessmoney);
			$('#ymoney').val(data.ymoney);
			x=data;
		}
		
	});
	 
	//监听提交
	
	$('#ytitle').blur(function(){
		 var ytitle=$('#ytitle').val();
		 if(ytitle==x.ytitle){
			 flag=0;
		 }else{
			 $.ajax({
				 url:path+'youhui.do?method=getCheckName',
				 type:'post',
				 data:{
					 ytitle:ytitle
				 },
				 dataType:'json',
				 success:function(data){
					if(data>0){
						 layer.tips('优惠已存在', '#ytitle');
						 flag=data;
					}else{
						flag=0;
					}
				 }
				 
			 });
		 }
	});
	
	
	form.on('submit(demo1)', function(data){
	  var ybegintime=$('#test1').val();
	  var yendtime=$('#test2').val();
	  var ytitle=$('#ytitle').val();
	  var ylessmoney=$('#ylessmoney').val();
	  var ymoney=$('#ymoney').val();
	  
	 if(flag>0){
		 layer.tips('优惠已存在', '#ytitle');
	 }else{
		 $.post(path+'youhui.do?method=upd', {
			 yid:yid,
			 ybegintime:ybegintime, 
			 yendtime:yendtime,
			 ytitle:ytitle,
			 ylessmoney,ylessmoney,
			 ymoney,ymoney
		  },function(data){
			  layer.msg('修改成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	 }
	  

	  return false;
	});
});
