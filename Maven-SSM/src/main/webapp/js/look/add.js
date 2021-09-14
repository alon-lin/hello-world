var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
$('.x').hide();

	$('#rcard').blur(function(){
		var rcard=$('#rcard').val();
		if(rcard.length==0){
			layer.tips("卡号不能为空!","#rcard");
		}else{
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
									$('.x').show();
								}
								
							});
					 }else{
						 layer.tips('该会员卡号不存在!', '#rcard', {
							  tips: 1
							});
						 $('.x').hide();
					 }
				}
				
			});
		}
	});
	
	
	
	
	
	form.on('submit(demo1)', function(data){
		 var rcard=$('#rcard').val();
		 var kremark=$('#kremark').val();
		 
		 
		 $.post(path+'look.do?method=add',{
			 rcard:rcard,
			 kremark:kremark
		 },function(data){
			  var index = layer.load();
			  layer.msg('添加成功!');
			  layer.close(index); 
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭  
		 },'json');
		return false;
	});
});
