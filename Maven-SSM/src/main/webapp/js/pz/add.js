var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	
	$('#zname').blur(function(){
		 var zname=$('#zname').val();
		 $.ajax({
			 url:path+'pz.do?method=getCheckName',
			 type:'post',
			 data:{
				 zname:zname
			 },
			 dataType:'json',
			 success:function(data){
				if(data>0){
					 layer.tips('凭证名称已存在', '#zname');
					 flag=data;
				}else{
					flag=0;
				}
			 }
			 
		 });
	});
	
	
	form.on('submit(demo1)', function(data){
	  var zname=$('#zname').val();
	  
	 if(flag>0){
		 layer.tips('凭证名称已存在', '#zname');
	 }else{
		 $.post(path+'pz.do?method=add', {
			  zname:zname,
		  },function(data){
			  layer.msg('添加成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	 }
	  

	  return false;
	});
});
