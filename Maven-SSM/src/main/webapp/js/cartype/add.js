var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	
	$('#aname').blur(function(){
		 var aname=$('#aname').val();
		 $.ajax({
			 url:path+'cartype.do?method=getCheckName',
			 type:'post',
			 data:{
				 aname:aname
			 },
			 dataType:'json',
			 success:function(data){
				if(data>0){
					 layer.tips('汽车类别已存在', '#aname');
					 flag=data;
				}else{
					flag=0;
				}
			 }
			 
		 });
	});
	
	
	form.on('submit(demo1)', function(data){
	  var aname=$('#aname').val();
	  
	 if(flag>0){
		 layer.tips('汽车类别已存在', '#aname');
	 }else{
		 $.post(path+'cartype.do?method=add', {
			  aname:aname,
		  },function(data){
			  layer.msg('添加成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	 }
	  

	  return false;
	});
});
