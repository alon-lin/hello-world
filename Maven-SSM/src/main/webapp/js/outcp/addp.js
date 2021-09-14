var path="";
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	
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
	
	
	$('#xcount').blur(function(){
		var xcount=$('#xcount').val();
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
		var xcount=$('#xcount').val(); 
		var rcard=$('#rcard').val(); 
		$.ajax({
			url:path+'outcp.do?method=sub',
			type:'post',
			data:{
				cid:cid,
				fid:fid,
				xcount:xcount,
				rcard:rcard
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
