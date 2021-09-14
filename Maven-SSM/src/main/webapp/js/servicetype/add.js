var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	
	$('#sname').blur(function(){
		 var sname=$('#sname').val();
		 $.ajax({
			 url:path+'servicetype.do?method=getCheckName',
			 type:'post',
			 data:{
				 sname:sname
			 },
			 dataType:'json',
			 success:function(data){
				if(data>0){
					 layer.tips('类别名称已存在', '#sname');
					 flag=data;
				}else{
					flag=0;
				}
			 }
			 
		 });
	});
	
	
	form.on('submit(demo1)', function(data){
	  var sname=$('#sname').val();
	  
	 if(flag>0){
		 layer.tips('类别名称已存在', '#sname');
	 }else{
		 $.post(path+'servicetype.do?method=add', {
			  sname:sname,
		  },function(data){
			  layer.msg('添加成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	 }
	  

	  return false;
	});
});
