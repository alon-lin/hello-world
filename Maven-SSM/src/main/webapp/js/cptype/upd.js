var path="";
var cid=0;
var from;
var $;
var x;
layui.use('form', function(){
	form = layui.form,$=layui.$;
	path=$('#path').val();
	cid=$('#cid').val();
	
	//单查询
	selCptype();
	
	
	updCptype();
	
});


function selCptype(){
	$.ajax({
		url:path+'Cptype.do?method=sel',
		type:'post',
		data:{
			cid:cid
		},
		dataType:'json',
		success:function(data){
			$('#cname').val(data.cname);
			x=data;
		}
	});
}

function updCptype(){
	

	$('#cname').blur(function(){
		 var cname=$('#cname').val();
		 if(cname==x.cname){
			 flag=0;
		 }else{
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
		 }
	});
	//监听提交
	form.on('submit(demo1)', function(data){
	  var cname=$('#cname').val();
	  if(flag>0){
		  layer.tips('类别名称已存在', '#cname');
	  }else{
		  $.post(path+'Cptype.do?method=upd', {
			  cid:cid,
			  cname:cname,
		  },function(data){
			  layer.msg('修改成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	  }
	

	  return false;
	});
}
