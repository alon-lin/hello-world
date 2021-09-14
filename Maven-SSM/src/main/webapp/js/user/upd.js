var path="";
var flag=0;
var uid;
var x;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	uid=$('#uid').val();
	
	$.ajax({
		url:path+"user.do?method=sel",
		type:'post',
		data:{
			uid:uid
		},
		dataType:'json',
		success:function(data){
			$('#uname').val(data.uname);
			$('#upsw').val(data.upsw);
			$('#urealname').val(data.urealname);
			if(data.usex==1){
				$("#male").attr("checked","checked");
			}
			if(data.usex==0){
				$("#female").attr("checked","checked");
			}
			$('#utel').val(data.utel);
			x=data;
			form.render(); //更新全部     
		}
		
	});
	 
	//监听提交
	
	$('#uname').blur(function(){
		 var uname=$('#uname').val();
		 if(uname==x.uname){
			 flag=0;
		 }else{
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
		 }
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
			 $.post(path+'user.do?method=upd', {
				uid:uid,
				uname:uname,
				upsw:upsw,
				urealname:urealname,
				usex:usex,
			 	utel:utel
			  },function(data){
				  layer.msg('修改成功!');
				  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				  parent.layer.close(index); //再执行关闭   
			  },'json')
		 }
		  

		  return false;
		});
});
