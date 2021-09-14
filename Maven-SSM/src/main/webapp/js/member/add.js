var form,layer,$,path,laypage,table,flag,laydate,a,b,c;
layui.use(['form','layer','laypage','table','laydate'],function(){
	form=layui.form,layer=layui.layer,$=layui.$,laypage=layui.laypage,table=layui.table,laydate=layui.laydate;
	path=$("#path").val();
	
	laydate.render({
		elem:'#rtime',
		format:'yyyy-MM-dd',
		value:new Date()
	});
	laydate.render({
		elem:'#rbirthday'
	});
	
	
	$('#rcard').blur(function(){
		var rcard=$('#rcard').val();
		$.ajax({
			url:path+'member.do?method=getCheckName',
			type:'post',
			data:{
				rcard:rcard
			},
			dataType:'json',
			success:function(data){
				if(data>0){
					layer.tips('该会员卡号已存在!','#rcard',{tips:[2,'blue']});
				}
			}
			
		});
	});
	
	
	//查询会员等级
	getGrade();
	
	//初始化汽车品牌下拉框
	getCar();
	
	//联动下拉框查询汽车系列
	getXl();
	
	//查询证件
	getVou();
	
	//监听提交
	form.on('submit(demo1)',function(){
		  var rcard=$("#rcard").val();
		  var rname=$("#rname").val();
		  var img=$("#img").val();
		  var rtel=$("#rtel").val();
		  var rpsw=$("#rpsw").val();
		  var rsex=$("#rsex").val();
		  var did=$("#did").val();
		  var rbirthday=$("#rbirthday").val();
		  var rstatus=$("#rstatus").val();
		  var rmoney=$("#rmoney").val();
		  var rjf=$("#rjf").val();
		  var rcarnum=$("#rcarnum").val();
		  var aid=$("#aid").val();
		  var xid=$("#xid").val();
		  var rcolor=$("#rcolor").val();
		  var rway=$("#rway").val();
		  var zid=$("#zid").val();
		  var rnum=$("#rnum").val();
		  var raddress=$("#raddress").val();
		  var rtime=$("#rtime").val();
		  var rremark=$("#rremark").val();
		  
		  if(/^1(3|4|5|7|8)\d{9}$/.test(rtel)!=true){
				layer.tips('请输入正确的电话格式!','#rtel',{tips:[2,'blue']});
			}else if(!/[\u4e00-\u9fa5]/.test(rname)){
				layer.tips('对不起,会员名称必须为汉字!','#rname',{tips:[2,'blue']});
			}else if(flag==1){
				layer.tips('对不起,会员卡号已存在!','#rcard',{tips:[2,'blue']});
			}else if(!/^1(3|4|5|7|8)\d{9}$/.test(rtel)){
				layer.tips('请输入正确的电话格式!','#rtel',{tips:[2,'blue']});
			}else if(a==2){
				layer.tips('对不起,电话号码已存在!','#rtel',{tips:[2,'blue']});
			}else if(b==3){
				layer.tips('车牌号已存在!','#rcarnum',{tips:[2,'blue']});
			}else if(c==4){
				layer.tips('证件号已存在，请重新输入!','#rnum',{tips:[2,'blue']});
			}else if(/[\u4e00-\u9fa5]/.test(raddress)!=true){
				layer.tips('地址必须为中文汉字!','#raddress',{tips:[2,'blue']});
			}
			else{
				$.ajaxFileUpload({
				    url:path+'member.do?method=add',
				    secureuri:false,//一般设置为false
				    async : false,
				    fileElementId:['img'],//上传对象 
				    data:{
				    	'rcard':rcard,
				    	'rname':rname,
				    	'rtel':rtel,
				    	'rpsw':rpsw,
				    	'rsex':rsex,
				    	'did':did,
				    	'rbirthday':rbirthday,
				    	'rstatus':rstatus,
				    	'rjf':rjf,
				    	'rcarnum':rcarnum,
				    	'xid':xid,
				    	'rcolor':rcolor,
				    	'rway':rway,
				    	'zid':zid,
				    	'rnum':rnum,
				    	"raddress":raddress,
					    "rtime":rtime,
						 "rremark":rremark,
						"rmoney":rmoney,
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
			}
		  return false;
	});
});


//下拉框查询会员等级
function getGrade(){
	$("#did").empty();
	$("#did").append("<option value='0'>---请选择会员等级---</option>")
	$.ajax({
		url:path+'dj.do?method=allp',
		data:'',
		dataType: 'json',
		type:'post',
		success : function(mydata) {
			$.each(mydata, function(index, xx) {
				$("#did").append("<option value=" + xx.did + ">" + xx.dname+ "</option>");
			});
			form.render('select'); //刷新select选择框渲染
		}
	});
}

//下拉框查询车辆品牌
function getCar(){
	  $("#aid").empty();
	  $("#aid").append("<option value=0>---请选择车辆品牌---</option>");
	  $.ajax({
		   url:path+"cartype.do?method=allp",
		   data:'',
		   dataType:'json',
		   type:'post',
		   success:function(mydata)
		   {
			   $.each(mydata,function(index,xx){
				   $("#aid").append("<option value="+xx.aid+">"+xx.aname+"</option>");
			   });
			   form.render('select'); //刷新select选择框渲染
		   }
	   });
}

//联动下拉框查询车辆系列
function getXl(){
	form.on('select(xilie)', function(data){
		 var aid=data.value;
		 $("#xid").empty();
		 $("#xid").append("<option value=0>---请选择车辆系列---</option>");
		 $.ajax({
			   url:path+"carxl.do?method=allp",
			   data:{'aid':aid},
			   dataType:'json',
			   type:'post',
			   success:function(mydata)
			   {
				   $.each(mydata,function(index,xx){
					   if(aid==xx.aid){
						   $("#xid").append("<option value="+xx.xid+">"+xx.xname+"</option>");
					   }else{
						   $("xid").append("<option value='0'>没有值</option>")
					   }
				   });
				   form.render('select'); //刷新select选择框渲染
			   }
		   });	
	});
}

//下拉框查询证件类型
function getVou(){
	$("#zid").empty();
	$("#zid").append("<option value='0'>---请选择证件类型---</option>")
	$.ajax({
		url:path+'pz.do?method=allp',
		data:'',
		dataType: 'json',
		type:'post',
		success : function(mydata) {
			$.each(mydata, function(index, xx) {
				$("#zid").append("<option value=" + xx.zid + ">" + xx.zname+ "</option>");
			});
			form.render('select'); //刷新select选择框渲染
		}
	});
}

