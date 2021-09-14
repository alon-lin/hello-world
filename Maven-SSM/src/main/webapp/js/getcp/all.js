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
		else if (obj.event === 'up')
		{
			window.location.href = path+"getcp/allOutcp.jsp?fid="+data.fid;
		}
		else if (obj.event === 'out')
		{
			window.location.href = path+"getcp/allGetcp.jsp?fid="+data.fid;
		}
	});

	var $ = layui.$, active = {
		getCheckData : function()
		{ 	//获取选中数据
			/*var checkStatus = table
					.checkStatus('idTest'), data = checkStatus.data;*/
			/*layer.alert(JSON.stringify(data));*/
			var fid=$('#fid').val();
			layer.open({
				  type: 2,
				  title: 'layer mobile页',
				  shadeClose: true,
				  shade: 0.8,
				  skin: 'layui-layer-lan',
				  area: ['400px', '240px'],
				  title: ['添加入库记录', 'font-size:18px;'],
				  content: path+'getcp/add.jsp?fid='+fid,//iframe的url
				  end:function(){
					  window.location.href = path+"getcp/all.jsp";
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
		