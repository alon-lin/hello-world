var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	$('.x').hide();
	
	$('#rcard').blur(function(){
		var rcard=$('#rcard').val();
		$.ajax({
			url:path+'member.do?method=getCheckName',
			type:'post',
			data:{
				rcard:rcard
			},
			dataType:'json',
			success:function(data){
				 if(data>0){
					 $.ajax({
							url:path+'member.do?method=getRcard',
							type:'post',
							data:{
								rcard:rcard
							},
							dataType:'json',
							success:function(data){
								$('#rname').val(data.rname)
								$('#rmoney').val(data.rmoney)
								$('.x').show();
							}
							
						});
				 }else{
					 layer.tips('该会员卡号不存在!', '#rcard', {
						  tips: 1
						});
				 }
			}
			
		});
	
	});
	
	
	$.ajax({
		url:path+"servicetype.do?method=allp",
		type:'post',
		data:{},
		dataType:'json',
		success:function(data){
			$('#sid').empty();
			$('#sid').append('<option value="0">---请选择---</option>');
			$.each(data,function(index,d){
				$('#sid').append('<option value='+d.sid+'>'+d.sname+'</option>');
			});
			form.render(); //更新全部
		}
	});
	
	form.on('submit(demo1)', function(data){
		var rcard=$('#rcard').val();
		var jmoney=$('#jmoney').val();
		var sid=$('#sid').val();
	    $.ajax({
	    	url:path+'jici.do?method=add',
	    	type:'post',
	    	data:{
	    		rcard:rcard,
	    		jmoney:jmoney,
	    		sid:sid
	    	},
	    	dataType:'json',
	    	success:function(data){
	    		 parent.layer.msg('增加成功!!',{icon:1});
				 parent.location.reload(); 
		         var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
	             parent.layer.close(index);
	    	}
	    	
	    });

	  return false;
	});
});
