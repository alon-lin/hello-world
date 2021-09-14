var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	
	
	 
	//监听提交
	
	$('#ytitle').blur(function(){
		 var ytitle=$('#ytitle').val();
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
	});
	
	
	form.on('submit(demo1)', function(data){
	  var ybegintime=$('#test1').val();
	  var yendtime=$('#test2').val();
	  var ytitle=$('#ytitle').val();
	  var ylessmoney=$('#ylessmoney').val();
	  var ymoney=$('#ymoney').val();
	  
	  /*var time1=new Date(ybegintime).getTime();
	  var time2=new Date(yendtime).getTime();*/
	  
	 if(flag>0){
		 layer.tips('优惠已存在', '#ytitle');
	 }else{
		 $.post(path+'youhui.do?method=add', {
			 ybegintime:ybegintime, 
			 yendtime:yendtime,
			 ytitle:ytitle,
			 ylessmoney,ylessmoney,
			 ymoney:ymoney
		  },function(data){
			  layer.msg('添加成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	 }
	  

	  return false;
	});
});
