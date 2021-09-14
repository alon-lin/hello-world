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
		else if (obj.event === 'del')
		{
			layer.confirm('真的删除行么', function(index)
			{
				obj.del();
				layer.close(index);
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
				  area: ['800px', '600px'],
				  offset: '100px',
				  title: ['修改优惠活动', 'font-size:18px;'],
				  content: path+'youhui/upd.jsp?yid='+data.yid,//iframe的url
				  end:function(){
					  window.location.href = path+"youhui/all.jsp";
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
				  area: ['700px', '600px'],
				  offset: '100px',
				  title: ['添加优惠活动', 'font-size:18px;'],
				  content: path+'youhui/add.jsp',//iframe的url
				  end:function(){
					  window.location.href = path+"youhui/all.jsp";
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
		