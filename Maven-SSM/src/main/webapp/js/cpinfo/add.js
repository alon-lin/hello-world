var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	
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
			$('#fdw').append('<option value="1">个</option>');
			$('#fdw').append('<option value="2">包</option>');
			$('#fdw').append('<option value="3">桶</option>');
			$('#fdw').append('<option value="4">套</option>');
			form.render('select'); //刷新select选择框渲染
		}
	});
	
	$('#fname').blur(function(){
		var fname=$('#fname').val();
		$.ajax({
			url:path+'cpinfo.do?method=getCheckName',
			type:'post',
			data:{
				fname:fname
			},
			dataType:'json',
			success:function(data){
				if(data>0){
					layer.tips('该产品已存在!','#fname',{tips:[2,'blue']});
				}
			}
			
		});
	});
	
	
	$('#finprice').blur(function(){
		var foutprice=$('#foutprice').val();
		var finprice=$('#finprice').val();
		if(Number(foutprice)<Number(finprice)){
			layer.tips('进货价格不能大于销售价格', '#finprice', {
				  tips:2
				});
		}
	});
	
	
	
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
		    url:path+'cpinfo.do?method=add',
		    secureuri:false,//一般设置为false
		    async : false,
		    fileElementId:['img'],//上传对象 
		    data:{
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
		    	    	 parent.layer.msg('增加成功!!',{icon:1});
						 parent.location.reload(); 
				         var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			             parent.layer.close(index);
		    	    }
		    	 }
		});
	
		

	  return false;
	});
});
