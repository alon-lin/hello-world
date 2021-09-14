var path="";
var did=0;
var from;
var $;
var dj;
/*积分*/
var f=0;
/*兑换比例*/
var k=0;
/*兑换折扣*/
var m=0;
var flag=0;
layui.use('form', function(){
	form = layui.form,$=layui.$;
	path=$('#path').val();
	did=$('#did').val();
	
	//单查询
	selDj();
	
	
	updDj();
	
});


function selDj(){
	$.ajax({
		url:path+'dj.do?method=sel',
		type:'post',
		data:{
			did:did
		},
		dataType:'json',
		success:function(data){
			$('#dname').val(data.dname);
			$('#djf').val(data.djf);
			$('#dmoneyBl').val(data.dmoneyBl);
			$('#dzk').val(data.dzk);
			dj=data;
		}
	});
}

function updDj(){
	$('#dname').blur(function(){
		var dname=$('#dname').val();
			if(dname==dj.dname){
				flag=0;
			}else{
				$.ajax({
					url:path+'dj.do?method=getCheckName',
					type:'post',
					data:{
						dname:dname
					},
					dataType:'json',
					success:function(data){
						if(data>0){
							layer.tips('等级名称已存在', '#dname');
							flag=1;
						}else{
							flag=0;
						}
					}
				});
			}
		});
		
		$('#djf').blur(function(){
			var djf=$('#djf').val();
			if(djf==dj.djf){
				f=0;
			}else{
				$.ajax({
					url:path+'dj.do?method=getCheckAll',
					type:'post',
					data:{
						djf:djf
					},
					dataType:'json',
					success:function(data){
						if(data==1){
							layer.tips('等级积分已存在', '#djf');
							f=1;
						}else{
							f=0;
						}
					}
				});
			}
			});
		$('#dmoneyBl').blur(function(){
			var dmoneyBl=$('#dmoneyBl').val();
				if(dmoneyBl==dj.dmoneyBl){
					k=0;
				}else{
					$.ajax({
						url:path+'dj.do?method=getCheckAll',
						type:'post',
						data:{
							dmoneyBl:dmoneyBl
						},
						dataType:'json',
						success:function(data){
							if(data==2){
								layer.tips('兑换比例已存在', '#dmoneyBl');
								k=2;
							}else{
								k=0;
							}
						}
					});
				}
			});
		
		$('#dzk').blur(function(){
			var dzk=$('#dzk').val();
			if(dzk==dj.dzk){
				m=0;
			}else{
				$.ajax({
					url:path+'dj.do?method=getCheckAll',
					type:'post',
					data:{
						dzk:dzk
					},
					dataType:'json',
					success:function(data){
						if(data==3){
							layer.tips('兑换折扣已存在', '#dzk');
							m=3;
						}else{
							m=0;
						}
					}
				});
			}
			});
	//监听提交
	form.on('submit(demo1)', function(data){
	  var dname=$('#dname').val();
	  var djf=$('#djf').val();
	  var dmoneyBl=$('#dmoneyBl').val();
	  var dzk=$('#dzk').val();
	  if(flag==1){
		  layer.tips('等级名称已存在', '#dname');
	  }else if(f==1){
		  layer.tips('等级积分已存在', '#djf');
	  }else if(k==2){
		  layer.tips('兑换比例已存在', '#dmoneyBl');
	  }else if(m==3){
		  layer.tips('兑换折扣已存在', '#dzk');
	  }else{
		  $.post(path+'dj.do?method=upd', {
			  did:did,
			  dname:dname,
			  djf:djf,
			  dmoneyBl:dmoneyBl,
			  dzk,dzk
		  },function(data){
			  layer.msg('修改成功!');
			  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			  parent.layer.close(index); //再执行关闭   
		  },'json')
	  }
	  
	  
	  

	  return false;
	});
}
