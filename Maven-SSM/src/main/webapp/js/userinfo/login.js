var path="";
var upsw="";
var uname="";
var layer;
var flag=0;
layui.use('layer', function(){
	  layer = layui.layer,$=layui.$;
	  
	  $('#uname').focus();
	  path=$('#path').val();

	  //验证非空
	  getCheckName();
	  getCheckPass();
	  
	  //登录
	  getSub();
	  
});    

function getCheckName(){
	$('#uname').blur(function(){
		uname=$('#uname').val();
		if(uname.length==0){
			layer.tips('账号不能为空', '#uname');
		}else{
			//账号是否有效
			$.ajax({
				url:path+"user.do?method=getCheckName",
				type:'post',
				data:{
					uname:uname
				},
				dataType:'json',
				success:function(data){
					if(data>0){
						layer.tips('账号有效', '#uname');
						flag=data;
					}
				}
			});
		}
	});
}
function getCheckPass(){
	$('#upsw').blur(function(){
		upsw=$('#upsw').val();
		if(upsw.length==0){
			layer.tips('密码不能为空', '#upsw');
		}
	});
}
function getSub(){
	$('#btn').click(function(){
		uname=$('#uname').val();
		upsw=$('#upsw').val();
		if(uname.length==0){
			layer.tips('账号不能为空', '#uname');
		}else if(upsw.length==0){
			layer.tips('密码不能为空', '#upsw');
		}else if(flag==0){
			layer.tips('账号不存在', '#uname');
		}else{
			$.ajax({
				url:path+'user.do?method=login',
				type:'post',
				data:{
					uname:uname,
					upsw:upsw
				},
				dataType:'json',
				success:function(data){
					if(data>0){
						//登录成功
						/*跳转页面*/
						window.location.href = path+"main/main.jsp";
					}else{
						layer.alert('账号或密码错误', {
							  skin: 'layui-layer-molv' //样式类名
							  ,closeBtn: 0
							  ,anim: 4 //动画类型
							}, function(){
								window.location.href = path+"login.jsp";
							});
					}
				}
			});
		}
	});
}
