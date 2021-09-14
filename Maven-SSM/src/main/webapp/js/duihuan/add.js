var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
$('.x').hide();
$('.o').hide();
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
								$('#rjf').val(data.rjf)
								$('#dmoneyBl').val(data.dmoneyBl);
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
		url:path+'lipin.do?method=allp',
		type:'post',
		data:{
			
		},
		dataType:'json',
		success:function(data){
			$('#nid').empty();
			$('#nid').append('<option value="0">---请选择---</option>');
			$.each(data,function(index,d){
				$('#nid').append('<option value='+d.nid+'>'+d.nname+'</option>');
			});
			form.render(); //更新全部
		}
		
	});
	
	form.on('select(aihao)', function(data){
		var nid=data.value;
		$.ajax({
			url:path+'lipin.do?method=sel',
			data:{
				nid:nid
			},
			type:'post',
			dataType:'json',
			success:function(data){
				$('#njf').val(data.njf);
				$('#nncount').val(data.nncount);
				$('.o').show();
			}
		});
	});  
	$('#hcount').keyup(function(){
		var rjf=$('#rjf').val();
		var njf=$('#njf').val();
		var hcount=$('#hcount').val();
		var nncount=$('#nncount').val();
		var dmoneyBl=$('#dmoneyBl').val();
		
		if(Number(hcount)>Number(nncount)){
			layer.tips("库存不足!","#hcount");
		}else{
			$('#jf').val(Number(rjf)-(Number(njf*hcount)*(1-Number(dmoneyBl))));
		}
	});
	
	$('#hcount').blur(function(){
		var jf=$('#jf').val();
		if(Number(jf)<0){
			layer.tips('积分不能为空!','#jf');
		}
	});
	
	
	
	
	
	form.on('submit(demo1)', function(data){
		 var rcard=$('#rcard').val();
		 var nid=$('#nid').val();
		 //兑换数量
		 var hcount=$('#hcount').val();
		 //剩余数量
		 var nncount=$('#nncount').val();
		 //兑换完剩余的数量
		 var count=Number(nncount)-Number(hcount);
		 //剩余积分
		 var jf=$('#jf').val();
		 
		 if(Number(jf)<0){
			 layer.tips('积分不能为空!','#jf');
		 }else{
			 $.post(path+'duihuan.do?method=add',{
				 rcard:rcard,
				 nid:nid,
				 hcount:hcount,
				 count:count,
				 jf:jf
			 },function(data){
				  var index = layer.load();
				  layer.msg('添加成功!');
				  layer.close(index); 
				  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				  parent.layer.close(index); //再执行关闭  
			 },'json');
		 }
		 
		return false;
	});
});
