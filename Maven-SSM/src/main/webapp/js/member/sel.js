var form,layer,$,path,laypage,table,flag,laydate,a,b,c;
layui.use(['form','layer','laypage','table','laydate'],function(){
	form=layui.form,layer=layui.layer,$=layui.$,laypage=layui.laypage,table=layui.table,laydate=layui.laydate;
	path=$("#path").val();
	var rid=$('#rid').val();
	
	
	
	$.ajax({
		url:path+"member.do?method=sel",
		type:'post',
		data:{
			rid:rid
		},
		dataType:'json',
		success:function(mydata){
			   $("#rrid").text(mydata.rid);
			   $("#rcard").text(mydata.rcard);
			   $("#rname").text(mydata.rname);
			   //$("#img").val(mydata.img);
			   $('#img').attr("src",path+"upload/"+mydata.rimg);
			   $("#rtel").text(mydata.rtel);
			   $("#rpsw").text(mydata.rpsw);
			   $("#sex").text(mydata.sex);
			   $("#dname").text(mydata.dname);
			   $("#rbirthday").text(mydata.rbirthday);
			   $("#status").text(mydata.status);
			   $("#rmoney").text(mydata.rmoney);
			   $("#rjf").text(mydata.rjf);
			   $("#rcarnum").text(mydata.rcarnum);
			   $("#aname").text(mydata.aname);
			   $("#xname").text(mydata.xname);
			   $("#rcolor").text(mydata.rcolor);
			   $("#rway").text(mydata.rway);
			   $("#zname").text(mydata.zname);
			   $("#rnum").text(mydata.rnum);
			   $("#raddress").text(mydata.raddress);
			   $("#rtime").text(mydata.rtime);
			   $("#rremark").text(mydata.rremark);
		}
		
	});
	
});	
	
	