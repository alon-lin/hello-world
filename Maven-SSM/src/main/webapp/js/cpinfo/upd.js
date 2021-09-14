var path="";
var flag=0;
var fid=0;
var x;
layui.use(['form','table'], function(){
	var form = layui.form,$=layui.$,table=layui.table;
	path=$('#path').val();
	//监听提交
	fid=$('#fid').val();
	$.ajax({
		url:path+"Cptype.do?method=allp",
		type:'post',
		dataType:'json',
		success:function(data){
			$('#cid').empty();
			$('#fdw').empty();
			$('#cid').append('<option value="0">---请选择产品类型---</option>');
			$.each(data,function(index,d){
				$('#cid').append('<option value='+d.cid+'>'+d.cname+'</option>');
			});
			$('#fdw').append('<option value="0">---请选择产品类型---</option>');
			$('#fdw').append('<option value="个">个</option>');
			$('#fdw').append('<option value="包">包</option>');
			$('#fdw').append('<option value="桶">桶</option>');
			$('#fdw').append('<option value="套">套</option>');
			form.render('select'); //刷新select选择框渲染
		}
	});
	
	
	
	
	
	
	$.ajax({
		
		url:path+'cpinfo.do?method=sel',
		type:'post',
		data:{
			fid:fid
		},
		dataType:'json',
		success:function(data){
			$('#fname').val(data.fname);
			$('#cid').val(data.cid);
			$('#fdw').val(data.fdw);
			$('#faddress').val(data.faddress);
			$('#foutprice').val(data.foutprice);
			$('#finprice').val(data.finprice);
			$('#img').attr('src',path+'upload/'+data.fimg)
			x=data;
		}
	});
	
	/*$.ajax({
		url:path+'cpinfo.do?method=allp',
		type:'post',
		dataType:'json',
		success:function(data){
			$.each(data,function(index,d){
				if(d.fid==data.fid){
					$('#cid').empty();
					$('#fdw').empty();
					$('#cid').append('<option value="0">---请选择产品类型---</option>');
					$('#fdw').append('<option value="0">---请选择产品类型---</option>');
					if(d.cid==data.cid){
						$('#cid').append('<option value='+d.cid+' selected>'+d.cname+'</option>');
					}else{
						$('#cid').append('<option value='+d.cid+'>'+d.cname+'</option>');
					}
					if(data.fdw==x.fdw){
						$('#fdw').append('<option value='+d.fdw+' selected>'+d.fdw+'</option>');
					}else{
						$('#fdw').append('<option value='+d.fdw+'>'+d.fdw+'</option>');
					}
					form.render('select');
				}
			});
		}
	});
	*/
	
	
	
	form.on('submit(demo1)', function(data){
	  
	 /* $.post(path+'cartype.do?method=add', {
		  aname:aname,
	  },function(data){
		  layer.msg('添加成功!');
		  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		  parent.layer.close(index); //再执行关闭   
	  },'json')*/
		var fname=$('#fname').val();
		var cid=$('#cid').val();
		var fdw=$('#fdw').val();
		var faddress=$('#faddress').val();
		var foutprice=$('#foutprice').val();
		var finprice=$('#finprice').val();
		var img=$('#img').val();	
		var fcount=$('#fcount').val();
		$.ajaxFileUpload({
		    url:path+'cpinfo.do?method=upd',
		    secureuri:false,//一般设置为false
		    async : false,
		    fileElementId:['img'],//上传对象 
		    data:{
		    	fid:fid,
		    	fname:fname,
		    	cid:cid,
		    	fdw:fdw,
		    	faddress:faddress,
		    	foutprice:foutprice,
		    	finprice:finprice,
		    	fcount:fcount
			 }, //上传控件以外的控件对应的参数
		    dataType: 'json', 
		    type:'post',
		    success:function(mydata,status)
		    	 {
		    	    if(mydata>0){
		    	    	 parent.layer.msg('修改成功!!',{icon:1});
						 parent.location.reload(); 
				         var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			             parent.layer.close(index);
		    	    }
		    	 }
		});
	
		

	  return false;
	});
});
