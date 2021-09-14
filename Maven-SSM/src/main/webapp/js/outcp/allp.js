var path="";
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();

	
	
	var pr=$('#pr').val();
	form.on('submit(test)', function(data){
		var rcard=$('#rcard').val();
		var pr=$('#pr').val();
		$.ajax({
			url:path+'member.do?method=getRcard',
			type:'post',
			data:{
				rcard:rcard
			},
			dataType:'json',
			success:function(data){
				if(Number(pr)>Number(data.rmoney)){
					//询问框
					//墨绿深蓝风

					layer.alert('余额不足,请充值', {
					  skin: 'layui-layer-lan' //样式类名
					  ,closeBtn: 0
					});
				}else{
					$.ajax({
						url:path+'outcp.do?method=add',
						type:'post',
						data:{},
						dataType:'json',
						success:function(data){
							 layer.alert('购买成功!', {icon: 1});
							 var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
							 parent.layer.close(index); //再执行关闭   
						}
					});
				}
			}
			
		});
		return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
});
