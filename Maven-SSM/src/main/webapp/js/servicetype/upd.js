var path="";
var sid=0;
var from;
var $;
var x;
layui.use('form', function(){
	form = layui.form,$=layui.$;
	path=$('#path').val();
	sid=$('#sid').val();
	
	//单查询
	selCptype();
	
	
	updCptype();
	
});


function selCptype(){
	$.ajax({
		url:path+'servicetype.do?method=sel',
		type:'post',
		data:{
			sid:sid
		},
		dataType:'json',
		success:function(data){
			$('#sname').val(data.sname);
			x=data;
		}
	});
}

function updCptype(){
	

	$('#sname').blur(function(){
		 var sname=$('#sname').val();
		 if(sname==x.sname){
			 flag=0;
		 }else{
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
		 }
	});
	//监听提交
	form.on('submit(demo1)', function(data){
	  var sname=$('#sname').val();
	  if(flag>0){
		  layer.tips('类别名称已存在', '#sname');
	  }else{
		  $.post(path+'servicetype.do?method=upd', {
			  sid:sid,
			  sname:sname,
		  },function(data){
			  layer.msg('修改成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	  }
	

	  return false;
	});
}
