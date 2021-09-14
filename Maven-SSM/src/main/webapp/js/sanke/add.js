var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	
	$.ajax({
		url:path+'Cptype.do?method=allp',
		type:'post',
		dataType:'json',
		success:function(data){
			$('#cid').empty();
			$('#cid').append('<option value="0">---请选择---</option>');
			$.each(data,function(index,d){
				$('#cid').append('<option value='+d.cid+'>'+d.cname+'</option>');
			});
			form.render('select'); //刷新select选择框渲染
		}
	});
	
	
	$('#wcount').blur(function(){
		var xcount=$('#wcount').val();
		var fcount=$('#fcount').val();
		if(Number(fcount)<Number(xcount)){
			layer.alert('库存不足!', {icon: 2});
		}
	});
	
	
	form.on('select(cids)', function(data){
		 var cid=data.value;
		 $.ajax({
			 url:path+'cpinfo.do?method=cp',
			 type:'post',
			 data:{
				 cid:cid
			 },
			 dataType:'json',
			 success:function(data){
				$('#fid').empty();
				$('#fid').append('<option value="0">---请选择---</option>');
				$.each(data,function(index,d){
					$('#fid').append('<option value='+d.fid+'>'+d.fname+'</option>');
				});
				form.render('select'); //刷新select选择框渲染
			 }
		 });
	}); 
	
	form.on('select(fids)', function(data){
		 var fid=data.value;
		 $.ajax({
			 url:path+'cpinfo.do?method=sel',
			 type:'post',
			 data:{
				 fid:fid
			 },
			 dataType:'json',
			 success:function(data){
				 $('#fcount').val(data.fcount);
				 $('#foutprice').val(data.foutprice);
			 }
		 });
	}); 
	
	
	form.on('submit(demo1)', function(data){
		var cid=$('#cid').val(); 
		var fid=$('#fid').val(); 
		var wcount=$('#wcount').val(); 
		var wname=$('#wname').val(); 
		var wtel=$('#wtel').val();
		//库存总量
		var fcount=$('#fcount').val(); 
		$.ajax({
			url:path+'outcp1.do?method=add',
			type:'post',
			data:{
				cid:cid,
				fid:fid,
				wcount:wcount,
				wname:wname,
				wtel:wtel,
			},
			dataType:'json',
			success:function(data){
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭   
			}
		});
		
		return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
});
