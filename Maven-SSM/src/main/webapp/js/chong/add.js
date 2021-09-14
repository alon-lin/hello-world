var path="";
var flag=0;
var rcard="";
var rid;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	rcard=$('#rcard').val();
	 
	$.ajax({
		url:path+'youhui.do?method=allp',
		type:'post',
		dataType:'json',
		success:function(data){
			$('#yid').empty();
			$('#yid').append("<option value='0'>---请选择优惠活动---</option>");
			$.each(data,function(index,d){
				$('#yid').append("<option value="+d.yid+">"+d.ytitle+"</option>");
			});
			form.render('select'); //刷新select选择框渲染
		}
		
	});
	
		form.on('select(aihao)', function(data){
		  var yid=data.value;
		  $.ajax({
			  url:path+"youhui.do?method=sel",
			  type:'post',
			  data:{
				  yid:yid
			  },
			  dataType:'json',
			  success:function(data){
				  $('#ylessmoney').val(data.ylessmoney);
				  $('#ymoney').val(data.ymoney);
			  }
			  
		  });
		});      
	$('#tab').hide();
	form.on('submit(demo1)', function(data){
	  rcard=$('#rcard').val();
	  $.ajax({
			url:path+"member.do?method=getRcard",
			type:'post',
			data:{
				rcard:rcard
			},
			dataType:'json',
			success:function(mydata){
					rid=mydata.rid;
				
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
			}
			
		});

	  return false;
	});
	
	var omoney=0;
	var ylessmoney=0;
	var ymoney =0
	$('#omoney').blur(function(){
		var omoney=$('#omoney').val();
		var ylessmoney=$('#ylessmoney').val();
		var ymoney=$('#ymoney').val();
		if(Number(omoney)>=Number(ylessmoney)){
			$('#olastmoney').val(Number(ymoney)+Number(omoney));
		}else{
			layer.tips('充值金额大于起始金额才能享受该优惠', '#omoney', {
				  tips:2
				});
		}
	});
	
	form.on('submit(demo2)', function(data){
		omoney=$('#omoney').val();
		var yid=$('#yid').val();
		var osmoney=$('#ymoney').val();
		var olastmoney=$('#olastmoney').val();
		var oremark=$('#oremark').val();
		$.post(path+"chong.do?method=add",{
			rid:rid,
			omoney:omoney,
			yid:yid,
			osmoney:osmoney,
			olastmoney:olastmoney,
			oremark:oremark
		},function(data){
			 if(data>0){
				 layer.msg('添加成功!');
				  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				  parent.layer.close(index); //再执行关闭   
			 }
		},'json');
		
		
		  return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
	
	

});
