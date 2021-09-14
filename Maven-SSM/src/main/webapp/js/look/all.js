var form,layer,$,path,laypage,table;
layui.use(['form','layer','laypage','table'],function(){
	form=layui.form,layer=layui.layer,$=layui.$,laypage=layui.laypage,table=layui.table;
	path=$("#path").val();
	
	var $ = layui.$, active = {
			getCheckData : function()
			{ 
				
				layer.open({
					type : 2,
					title : [ '添加', 'background-color:#FFDCA9;' ],
					fix : false,
					shadeClose : true,
					resize : true,
					shade : 0.5,
					skin : 'layui-layer-demo',
					shift : 4, // 动画类型
					area : [ '650px', '550px' ],
					offset : '100px',
					maxmin : true,

					  content: path+'look/add.jsp',//iframe的url
					  end : function() {
						getAllPage(mybegin, mypages);
					}
				});
				
				
			}
		};

		$('.demoTable .layui-btn').on('click', function()
		{
			var type = $(this).data('type');
			active[type] ? active[type].call(this) : '';
		});
	
	
	
});
