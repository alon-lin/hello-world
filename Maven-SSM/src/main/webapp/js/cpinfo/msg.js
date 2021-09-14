var path="";
$(function(){
	 path=$("#path").val();
	 $.messager.lays(250,150);
	 var mytx="<div id='tx'>";
	 $.ajax({
		  url:path+'cpinfo.do?method=msg',
		  type:'post',
		  dataType:'json',
		  success:function(data)
		  {
			  mytx="<a href='"+path+"cpinfo/msg.jsp'>你有"+data+"条待审消息</a>";
			  $("#tx").append(mytx);
			  $.messager.show('您有新消息',mytx,0);
		  }
	  });
	
});