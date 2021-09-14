var path="";
var zid=0;
var from;
var $;
var x;
layui.use('form', function(){
	form = layui.form,$=layui.$;
	path=$('#path').val();
	zid=$('#zid').val();
	
	//单查询
	selCptype();
	
	
	updCptype();
	
});


function selCptype(){
	$.ajax({
		url:path+'pz.do?method=sel',
		type:'post',
		data:{
			zid:zid
		},
		dataType:'json',
		success:function(data){
			$('#zname').val(data.zname);
			x=data;
		}
	});
}

function updCptype(){
	

	$('#zname').blur(function(){
		 var zname=$('#zname').val();
		 if(zname==x.zname){
			 flag=0;
		 }else{
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
		 }
	});
	//监听提交
	form.on('submit(demo1)', function(data){
	  var zname=$('#zname').val();
	  if(flag>0){
		  layer.tips('凭证名称已存在', '#zname');
	  }else{
		  $.post(path+'pz.do?method=upd', {
			  zid:zid,
			  zname:zname,
		  },function(data){
			  layer.msg('修改成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	  }
	

	  return false;
	});
}
