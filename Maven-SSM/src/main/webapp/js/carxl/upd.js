var path="";
var xid=0;
var from;
var $;
var x;
layui.use('form', function(){
	form = layui.form,$=layui.$;
	path=$('#path').val();
	xid=$('#xid').val();
	
	//单查询
	$.ajax({
		url:path+'carxl.do?method=sel',
		type:'post',
		data:{
			xid:xid
		},
		dataType:'json',
		success:function(data){
			$('#xname').val(data.xname);
			x=data;
		}
	});
	
	$.ajax({
		url:path+'carxl.do?method=allType',
		type:'post',
		dataType:'json',
		success:function(data){
			$('#city').empty();
			$('#city').append('<option value="0">请选择汽车品牌</option>');
			$.each(data,function(index,d){
				if(d.aid==x.aid){
					$('#city').append('<option value='+d.aid+' selected>'+d.aname+'</option>');
				}else{
					$('#city').append('<option value='+d.aid+'>'+d.aname+'</option>');
				}
			});
			form.render('select');
		}
	});
	
	updCptype();
	
});


function updCptype(){
	

	$('#xname').blur(function(){
		 var xname=$('#xname').val();
		 var aid=$('#city').val();
		 if(xname==x.xname){
			 flag=0;
		 }else{
			 $.ajax({
				 url:path+'carxl.do?method=getCheckName',
				 type:'post',
				 data:{
					 xname:xname,
					 aid:aid
				 },
				 dataType:'json',
				 success:function(data){
					if(data>0){
						 layer.tips('该汽车已有该系列', '#xname');
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
	  var xname=$('#xname').val();
	  var aid=$('#city').val();
	  if(flag>0){
		  layer.tips('该汽车已有该系列', '#xname');
	  }else{
		  $.post(path+'carxl.do?method=upd', {
			  xid:xid,
			  xname:xname,
			  aid:aid
		  },function(data){
			  layer.msg('修改成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	  }
	

	  return false;
	});
}
