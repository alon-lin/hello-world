var path="";
var flag=0;
var rid=0;
var rcard;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	rid=$('#rid').val();
	rcard=$('#rcard').val();
	
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
				if(data<1){
					layer.tips('该会员卡号不存在!','#rcard',{tips:[2,'red']});
				}
			}
			
		});
	});
	
	form.on('submit(demo2)', function(data){
		var rcard=$('#rcard').val(); 
		if(rcard.length==0){
			layer.tips('请输入会员卡号', '#rcard', {
				  tips: 2
				});
		 }else{
			 layer.open({
				  type: 2,
				  title: 'layer mobile页',
				  shadeClose: true,
				  shade: 0.8,
				  skin: 'layui-layer-lan',
				  area: ['800px', '600px'],
				  title: ['添加订单', 'font-size:18px;'],
				  content: path+'outcp/addp.jsp?rcard='+rcard,//iframe的url
				  end:function(){
					  window.location.href = path+"outcp/add.jsp?x="+1;
				  }
				}); 
		 }
		 return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
	
	
	
	var x=$('#x').val();
	 $('#p').hide();
	if(x==1){
		var ca=$('#ca').val();
		 $('#p').show();
		$.ajax({
			url:path+"member.do?method=getRcard",
			type:'post',
			data:{
				rcard:ca,
			},
			dataType:'json',
			success:function(mydata){
				   $('#rcard').val(ca);
				   $("#rrid").text(mydata.rid);
				   $("#rrcard").text(ca);
				   $("#rname").text(mydata.rname);
				   $('#img').attr("src",path+"upload/"+mydata.rimg);
				   $("#rtel").text(mydata.rtel);
				   $("#rpsw").text(mydata.rpsw);
				   $("#sex").text(mydata.sex);
				   $("#dname").text(mydata.dname);
				   $("#rbirthday").text(mydata.rbirthday);
				   $("#status").text(mydata.status);
				   $("#rmoney").text(mydata.rmoney);
				   $("#rjf").text(mydata.rjf);
				   $("#rcarnum").text(mydata.rcarnum);
				   $("#aname").text(mydata.aname);
				   $("#xname").text(mydata.xname);
				   $("#rcolor").text(mydata.rcolor);
				   $("#rway").text(mydata.rway);
				   $("#zname").text(mydata.zname);
				   $("#rnum").text(mydata.rnum);
				   $("#raddress").text(mydata.raddress);
				   $("#rtime").text(mydata.rtime);
				   $("#rremark").text(mydata.rremark);
				   $("#xrcard").val(rcard);
				   $('#tab').show();
				   $.ajax({
					   url:path+'outcp.do?method=xll',
					   type:'post',
					   dataType:'json',
					   success:function(data){
						   if(data>0){
							   $('#p').show();
						   }else{
							   $('#p').hide();
						   }
					   }
				   });
				   
			}
			
		});
	}else{
		//监听提交
		$('#tab').hide();
		form.on('submit(demo1)', function(data){
			  var rcard=$('#rcard').val();
			  $.ajax({
					url:path+"member.do?method=getRcard",
					type:'post',
					data:{
						rcard:rcard,
					},
					dataType:'json',
					success:function(mydata){
						   $("#rrid").text(mydata.rid);
						   $("#rrcard").text(rcard);
						   $("#rname").text(mydata.rname);
						   $('#img').attr("src",path+"upload/"+mydata.rimg);
						   $("#rtel").text(mydata.rtel);
						   $("#rpsw").text(mydata.rpsw);
						   $("#sex").text(mydata.sex);
						   $("#dname").text(mydata.dname);
						   $("#rbirthday").text(mydata.rbirthday);
						   $("#status").text(mydata.status);
						   $("#rmoney").text(mydata.rmoney);
						   $("#rjf").text(mydata.rjf);
						   $("#rcarnum").text(mydata.rcarnum);
						   $("#aname").text(mydata.aname);
						   $("#xname").text(mydata.xname);
						   $("#rcolor").text(mydata.rcolor);
						   $("#rway").text(mydata.rway);
						   $("#zname").text(mydata.zname);
						   $("#rnum").text(mydata.rnum);
						   $("#raddress").text(mydata.raddress);
						   $("#rtime").text(mydata.rtime);
						   $("#rremark").text(mydata.rremark);
						   $("#xrcard").val(rcard);
						   $('#tab').show();
						   $('#p').show();
						   $.ajax({
							   url:path+'outcp.do?method=xll',
							   type:'post',
							   dataType:'json',
							   success:function(data){
								   if(data>0){
									   $('#p').show();
								   }
							   }
						   });
					}
					
				});

			  return false;
			});
	}
	
	
	form.on('submit(demo3)', function(data){
		var rcard=$('#rcard').val();
		layer.open({
			  type: 2,
			  title: 'layer mobile页',
			  shadeClose: true,
			  shade: 0.8,
			  skin: 'layui-layer-lan',
			  area: ['800px', '600px'],
			  title: ['结账', 'font-size:18px;'],
			  content: path+'outcp/allp.jsp?rcard='+rcard,//iframe的url
			  end:function(){
				  window.location.href = path+"outcp/add.jsp";
			  }
			}); 
		 return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
	
	
});
