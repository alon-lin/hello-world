var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	
	$('#cname').blur(function(){
		 var cname=$('#cname').val();
		 $.ajax({
			 url:path+'Cptype.do?method=getCheckName',
			 type:'post',
			 data:{
				 cname:cname
			 },
			 dataType:'json',
			 success:function(data){
				if(data>0){
					 layer.tips('类别名称已存在', '#cname');
					 flag=data;
				}else{
					flag=0;
				}
			 }
			 
		 });
	});
	
	
	form.on('submit(demo1)', function(data){
	  var cname=$('#cname').val();
	  
	 if(flag>0){
		 layer.tips('类别名称已存在', '#cname');
	 }else{
		 $.post(path+'Cptype.do?method=add', {
			  cname:cname,
		  },function(data){
			  layer.msg('添加成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	 }
	  

	  return false;
	});
});
