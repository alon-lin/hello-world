var path="";
layui.use('table',function(){
	var table = layui.table,$=layui.$;
	
	path=$('#path').val();
	//监听表格复选框选择
	table.on('checkbox(demo)', function(obj)
	{
		console.log(obj)
	});
	//监听工具条
	table.on('tool(demo)', function(obj)
	{
		var data = obj.data;
		if (obj.event === 'detail')
		{
			layer.msg('ID：' + data.id + ' 的查看操作');
		}
		else if (obj.event === 'one')
		{
			layer.open({
				  type: 2,
				  title: 'layer mobile页',
				  shadeClose: true,
				  shade: 0.8,
				  skin: 'layui-layer-lan',
				  area: ['800px', '600px'],
				  offset: '100px',
				  title: ['查看会员详情', 'font-size:18px;'],
				  content: path+'member/sel.jsp?rid='+data.rid,//iframe的url
				  end:function(){
					  window.location.href = path+"member/all.jsp";
				  }
				}); 
		}
		else if (obj.event === 'edit')
		{
			layer.open({
				  type: 2,
				  title: 'layer mobile页',
				  shadeClose: true,
				  shade: 0.8,
				  skin: 'layui-layer-lan',
				  area: ['1000px', '800px'],
				  offset: '100px',
				  title: ['修改会员', 'font-size:18px;'],
				  content: path+'member/upd.jsp?rid='+data.rid,//iframe的url
				  end:function(){
					  window.location.href = path+"member/all.jsp";
				  }
				}); 
		}
	});

	var $ = layui.$, active = {
		getCheckData : function()
		{ /*//获取选中数据
			var checkStatus = table
					.checkStatus('idTest'), data = checkStatus.data;
			layer.alert(JSON.stringify(data));*/
			
			layer.open({
				  type: 2,
				  title: 'layer mobile页',
				  shadeClose: true,
				  shade: 0.8,
				  skin: 'layui-layer-lan',
				  area: ['1000px', '800px'],
				  title: ['添加会员', 'font-size:18px;'],
				  content: path+'member/add.jsp',//iframe的url
				  end:function(){
					  window.location.href = path+"member/all.jsp";
				  }
				}); 
		},
		getCheckLength : function()
		{ //获取选中数目
			var checkStatus = table
					.checkStatus('idTest'), data = checkStatus.data;
			layer.msg('选中了：' + data.length + ' 个');
		},
		isAll : function()
		{ //验证是否全选
			var checkStatus = table
					.checkStatus('idTest');
			layer.msg(checkStatus.isAll ? '全选' : '未全选')
		}
	};

	$('.demoTable .layui-btn').on('click', function()
	{
		var type = $(this).data('type');
		active[type] ? active[type].call(this) : '';
	});
});
		