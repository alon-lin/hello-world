var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	
	//监听提交
	
	$('#uname').blur(function(){
		 var uname=$('#uname').val();
		 $.ajax({
			 url:path+'user.do?method=getCheckName',
			 type:'post',
			 data:{
				 uname:uname
			 },
			 dataType:'json',
			 success:function(data){
				if(data>0){
					 layer.tips('员工账号已存在', '#uname');
					 flag=data;
				}else{
					flag=0;
				}
			 }
			 
		 });
	});
	
	
	form.on('submit(demo1)', function(data){
	  var upsw=$('#upsw').val();
	  var urealname=$('#urealname').val();
	  var uname=$('#uname').val();
	  var usex=$('[name="usex"]:checked').val();
	  var utel=$('#utel').val();
	  
	 if(flag>0){
		 layer.tips('员工账号已存在', '#uname');
	 }else{
		 $.post(path+'user.do?method=add', {
			uname:uname,
			upsw:upsw,
			urealname:urealname,
			usex:usex,
		 	utel:utel
		  },function(data){
			  layer.msg('添加成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	 }
	  

	  return false;
	});
});
