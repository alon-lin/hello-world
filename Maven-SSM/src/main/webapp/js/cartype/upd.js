var path="";
var aid=0;
var from;
var $;
var x;
layui.use('form', function(){
	form = layui.form,$=layui.$;
	path=$('#path').val();
	aid=$('#aid').val();
	
	//单查询
	selCptype();
	
	
	updCptype();
	
});


function selCptype(){
	$.ajax({
		url:path+'cartype.do?method=sel',
		type:'post',
		data:{
			aid:aid
		},
		dataType:'json',
		success:function(data){
			$('#aname').val(data.aname);
			x=data;
		}
	});
}

function updCptype(){
	

	$('#aname').blur(function(){
		 var aname=$('#aname').val();
		 if(aname==x.aname){
			 flag=0;
		 }else{
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
		 }
	});
	//监听提交
	form.on('submit(demo1)', function(data){
	  var aname=$('#aname').val();
	  if(flag>0){
		  layer.tips('汽车类别已存在', '#aname');
	  }else{
		  $.post(path+'cartype.do?method=upd', {
			  aid:aid,
			  aname:aname,
		  },function(data){
			  layer.msg('修改成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	  }
	

	  return false;
	});
}
