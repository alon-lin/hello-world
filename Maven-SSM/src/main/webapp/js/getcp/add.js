var path="";
var flag=0;
layui.use('form', function(){
	var form = layui.form,$=layui.$;
	path=$('#path').val();
	//监听提交
	var fid=$('#fid').val();
	
	form.on('submit(demo1)', function(data){
	  var gcount=$('#gcount').val();
	  $.post(path+'getcp.do?method=add', {
		  fid:fid,
		  gcount:gcount
	  },function(data){
		  layer.msg('添加成功!');
		  var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
		  parent.layer.close(index); //再执行关闭   
	  },'json')
	  return false;
	});
});
