var form,layer,$,path,laypage,table;
var mybegin=1;
var mypages=5;
layui.use(['form','layer','laypage','table'],function(){
	form=layui.form,layer=layui.layer,$=layui.$,laypage=layui.laypage,table=layui.table;
	path=$("#path").val();
	//分页查询
	getAllPage();
	//弹出一个增加层
	myadd();
	//后面的 查看、修改、删除
	myallaction();
	//上面的内处几个按钮问题
	myupactgion();
});

/********************分页查询******************/
function getAllPage()
{
   	//第一步：定义表头
	table.render({
		elem: '#test',  //要邦定数据的地方
		url:path+"lipin.do?method=all",
		cellMinWidth: 80,//最小列的宽度
		cols:[[
			 {field:'nid',title:'礼品编号',sort:true},
    		 {field:'nname',title:'礼品姓名'},
    		 {field:'nimg',title:'礼品相片',templet:function (d) { return '<div style="height:200px; line-height:200px;"><img src='+path+d.nimg+' width="100" height="200"></div>'}},
    		 {field:'njf',title:'礼品积分'},
    		 {field:'ncount',title:'礼品数量'},
    		 {field:'nncount',title:'剩余数量'},
    		 {field:'right',title:'查看详情',align:'center',toolbar: '#barDemo1'},
    		 {field:'right',title:'操作',align:'center',toolbar: '#barDemo'}
		]],
		page: true,//不显示默认的分页样式,
		id:'lisheng',//你要操作所选择的对象的主键值(批量删除时要你选择的对象的主键)
		done:function(res, curr, count) //回调
		{
			  table.render();
			 //第二步：动态绑定数据
			 /*******************************/
		}
	});
}
/*******************************************************/





















/**********************************************************/
function myadd()
{
   $("#add").click(function(){
	   layer.open( {
			type : 2,
			title : '增加礼品',
			fix : false,
			shadeClose : true,
			resize:true,
			area : [ '850px', '530px' ],
			content : path+'lipin/add.jsp',
			skin : 'layui-layer-lan',
			shift: 4, //动画类型
			//层被销毁回调
			end : function() {
				getAllPage();
			}
		});  
   });	
}
/******************************/
























/*************后面的查看一个、修改、删除*****************/
function myallaction()
{
  	table.on('tool(demo)',function(obj){
  		 //得到你要操作对象的主键
  		 var data = obj.data.nid;
  		 
  		if(obj.event=='detail')
  			{
	  			 layer.open( {
	  				type : 2,
	  				title : '修改礼品',
	  				fix : false,
	  				shadeClose : true,
	  				resize:true,
	  				area : [ '850px', '530px' ],
	  				content : path+'lipin/upd.jsp?nid='+data,
	  				skin : 'layui-layer-lan',
	  				shift: 4, //动画类型
	  				//层被销毁回调
	  				end : function() {
	  					getAllPage();
	  				}
	  			});  
  			}
  		
  		else if(obj.event=='edit')
  			{
  			window.location.href=path+"lipin/allRes.jsp?nid="+data;
  			}
  		else
  			{
  		      //删除 
  			  //你可以删除对象
  			 alert(data);
  			}
  	});
}






















/**************************上面的按钮问题***************************/
function myupactgion()
{
	    var $ = layui.$, active = {
			    getCheckData: function()
			    { 
			    	//获取选中数据
			       var checkStatus = table.checkStatus('lisheng'),data = checkStatus.data;
			      
			       if(data.length==0)
			    	   {
			    	      alert("最少选择一个要删除的对象！");
			    	   }
			       else
			    	   {
			    	       $.each(data,function(index,xx){
					    	 
				    	     alert(xx.sid);//可以得到要删除对象的编号
				    	     //去后台删除
				    	 
				          }); 
			    	   }
			    },
			    uppemp:function()
			    {
			    	//获取选中数据
				    var checkStatus = table.checkStatus('lisheng'),data = checkStatus.data;
				    if(data.length==0)
			    	   {
			    	      alert("选择一个要修改的对象！");
			    	   }
			       else
			    	   {
			    	       if(data.length>1)
			    	    	   {
			    	    	      alert("对不起，你每次只能修改一个");
			    	    	   }
			    	       else
			    	    	   {
			    	    	       $.each(data,function(index,xx){
							    	 
						    	     alert(xx.sid);//可以得到要删除对象的编号
						    	     //去后台修改
						    	    
						          }); 
			    	    	   }
			    	   }
			    }
			  };
			  
			  $('.demoTable .layui-btn').on('click', function(){
			    var type = $(this).data('type');
			    active[type] ? active[type].call(this) : '';
			  });	
}




