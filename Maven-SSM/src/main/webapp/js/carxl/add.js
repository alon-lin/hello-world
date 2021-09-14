var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	
	$.ajax({
		url:path+'carxl.do?method=allType',
		type:'post',
		dataType:'json',
		success:function(data){
			$('#city').empty();
			$('#city').append('<option value="0">请选择汽车品牌</option>');
			$.each(data,function(index,d){
				$('#city').append('<option value='+d.aid+'>'+d.aname+'</option>');
			});
			form.render('select');
		}
	});
	
	
	$('#xname').blur(function(){
		 var aid=$('#city').val();
		 var xname=$('#xname').val();
		 $.ajax({
			 url:path+'carxl.do?method=getCheckName',
			 type:'post',
			 data:{
				 xname:xname,
				 aid:aid
			 },
			 dataType:'json',
			 success:function(data){
				if(data>0){
					 layer.tips('该汽车已有该系列', '#xname');
					 flag=data;
				}else{
					flag=0;
				}
			 }
			 
		 });  
	});
	
	
	form.on('submit(demo1)', function(data){
	  var xname=$('#xname').val();
	  var city=$('#city').val();
	 if(flag>0){
		 layer.tips('该汽车已有该系列', '#xname');
	 }else{
		 $.post(path+'carxl.do?method=add', {
			  xname:xname,
			  aid:city
		  },function(data){
			  layer.msg('添加成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	 }
	  

	  return false;
	});
});
