var path="";
var flag=0;
var nid=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	nid=$('#nid').val();
	
	
	$.ajax({
		   url:path+'lipin.do?method=sel',
		   type:'post',
		   data:{
			   nid:nid
		   },
		   dataType:'json',
		   success:function(data){
			   $("#nname").val(data.nname);
			   $("#njf").val(data.njf);
			   $("#ncount").val(data.ncount);
			  /* $("img").attr("src",data.nimg);*/
		   }
		   
	});
	
	
	form.on('submit(demo1)', function(data){
		 var nname=$('#nname').val();
		 var njf=$('#njf').val();
		 var ncount=$('#ncount').val();
		 var img=$('#img').val();
		 $.ajaxFileUpload({
			    url:path+"lipin.do?method=upd",
			    secureuri:false,//一般设置为false
			    fileElementId:['img'],//上传对象 
			    data:{
					    nid:nid,
			    		nname:nname,
					    njf:njf,
					    ncount:ncount,
					 }, //上传控件以外的控件对应的参数
			    dataType: 'json', 
			    type:'post',
			    success:function(mydata,status)
			    	 {
			    	     parent.layer.msg('修改成功!!',{icon:1});
				         var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			             parent.layer.close(index);
			    	 }
			    	  ,
		             error: function (data, status, e)//服务器响应失败处理函数
		              {
			    	      parent.layer.msg('修改失败!!',{icon:1});
				    	  var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
			              parent.layer.close(index);
		               }
			    });
		 return false;
	});
});
