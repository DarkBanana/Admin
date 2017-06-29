<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common-link.jsp" %>
<%@ include file="/WEB-INF/jsp/common-js.jsp" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 系统</title>

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper"   id="app" v-cloak >
 	<!-- 添加页面 -->
	<!-- header side column  -->
	<%@ include file="/WEB-INF/jsp/header.jsp" %>
 	
    <!-- Left side Menu column. contains the logo and sidebar -->
    <!-- Menu side -->
 	<%@ include file="/WEB-INF/jsp/menu.jsp" %>

	<!-- vue adduser -->
	<%@ include file="/WEB-INF/jsp/user/adduser.jsp" %>
	
    <!-- edituser -->
    <%@ include file="/WEB-INF/jsp/user/edituser.jsp" %> 
  
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Data Tables
        <small>advanced tables</small>
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
        <li><a href="#">Tables</a></li>
        <li class="active">Data tables</li>
      </ol>
    </section>


    <!-- Main content -->
    <section class="content">
      <div class="row">
        <div class="col-xs-12">
          <!-- /.box -->
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">角色</h3>
            </div>
            			
            <!-- /.box-header -->
            <div class="box-body">
            		
            		
            <div class="row-fluid">
    <div class="pull-right">
        <div class="btn-group">
            <button  type="button" @click="adduser" class="btn btn-danger btn-sm"  id="btn-add" style="height:25px ;width:68px;">
		              			  <i class="fa fa-plus" >添加</i> 
		    				 </button>
            
            <button type="button" class="btn  btn-success btn-sm" id="btn-re" style="height:25px ;width:68px;">
                <i class="fa fa-refresh">刷新</i>
            </button>
            
        </div>
    </div>
            	
            <table id="dataTable" class="table table-striped table-bordered table-hover table-condensed" >
		    	<thead>
		    	<!-- class =info 颜色 -->
		       		 <tr class="info">        
		            	<th>用户账号</th>
						<th>用户名称</th>
						<th>性别</th>
						<th>工号</th>
						<th>部门</th>
						<th>电话</th>
						<th>角色</th>
						<th>工种</th> 
						<th>职称</th>
						<th>备注</th> 
						<th style="text-align:center;">操作</th>
						<!--<th>修改</th> --> 
		       		 </tr>
		    	</thead>
			</table>
             
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>


  
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    <div class="pull-right hidden-xs">
      <b>Version</b> 2.3.8
    </div>
    <strong>Copyright &copy; 2014-2016 <a href="http://almsaeedstudio.com">Almsaeed Studio</a>.</strong> All rights
    reserved.
  </footer>
</div>

<!-- page script -->
<script>
	
	$(document).ready(function() {
	var table = $('#dataTable').DataTable( {
		//语言设置
        language: {  
	      "sProcessing": "处理中...",  
	      "sLengthMenu": "显示 _MENU_ 项结果",  
	      "sZeroRecords": "没有匹配结果",  
	      "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",  
	      "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",  
	      "sInfoFiltered": "(由 _MAX_ 项结果过滤)",  
	      "sInfoPostFix": "",  
	      "sSearch": "搜索:",  
	      "sUrl": "",  
	      "sEmptyTable": "表中数据为空",  
	      "sLoadingRecords": "载入中...",  
	      "sInfoThousands": ",",  
	      "oPaginate": {  
	          "sFirst": "首页",  
	          "sPrevious": "上页",  
	          "sNext": "下页",  
	          "sLast": "末页"  
	      	},  
	      "oAria": {  
	          "sSortAscending": ": 以升序排列此列",  
	          "sSortDescending": ": 以降序排列此列"  
	      	}  
	 	  } ,
	 	//自定义风格
	    //sScrollX: "100%",  // x轴添加响应滚轴
	    //sScrollY: "100%",  // x轴添加响应滚轴 下面太多空白 此项不可添加 
	    //autoWidth: true , //自动宽度
	    autoWidth: false, //自动宽度
	    searching:false, //关闭搜索框 
	    
        //ajax
		ajax: {
		url: "user/queryuser.action",
		type: "POST",
		},
		"columns": [		//对应thead
			{ "data": "useraccount" },
			{ "data": "username" },
			{ "data": "sex" },
			{ "data": "jobnumber" },
			{ "data": "department" },
			{ "data": "tel" },
			{ "data": "role" },
			{ "data": "worktype" },
			{ "data": "position" },
			{ "data": "note" },
			{ "data": null },
		],
		 columnDefs: [
             {
                targets: -1,
                 defaultContent: "<div id ='operation' class='btn-group'>"+
                               "<button id='editRow' class='btn btn-primary btn-sm' type='button'><i class='fa fa-edit'>修改</i></button>"+
                               "<button id='delRow'  class='btn btn-primary btn-sm' type='button'><i class='fa fa-trash-o'>删除</i></button>"+
                               "</div>"  
             }], 
		deferRender: false
	} );
	 //不显示任何错误信息
	 $.fn.dataTable.ext.errMode = 'none';  
	
	 //删除方法必须放在$datatable下 绑定button 不好用vue
	 $('#dataTable tbody').on( 'click', 'button#delRow', function () {
        var data = table.row( $(this).parents('tr') ).data();
        console.log(data)
        var id = data.id
         console.log(id)
        layer.confirm('您确定要删除吗？', {
	    btn: ['确定','取消'] //按钮
		}, function(){
		  layer.msg('已删除', {
		  //icon: 1,
		  time: 1200, //1.2s后自动关闭
		  });
		  $.ajax({
	            url:"user/deluser.action?id="+id,
	            type:"Post",
	            dataType:"json",
	            success:function(){
	            	console.log(id);
	               // layer.msg('已删除');
	                table.ajax.reload();
	            },
	            error:function(data){
	                $.messager.alert('错误',data.msg);
	            }
	        });
	        
		});
   		 } );
	
	
	   //修改方法必须放在$datatable下 绑定button 不好用vue
	    $('#dataTable tbody').on('click', 'button#editRow', function () {
	 	var data = table.row($(this).parents('tr')).data();
	 	var id = data.id
		// 异步加载 得到详细信息，然后假如得到的对象是r
		for(var name in data){
			$("[name='"+name+"']").val(data[name]);
		}
		layer.open({
		type: 1,		//除了信息框,open等框必须要制定type,content为html必须为2
	    skin: 'layui-layer-lan' ,
	    title: "修改用户信息",
	    area: ['330px', '520px'],
	    offset: ['100px', '475px'], //定位坐标位置
	    closeBtn: 0 ,
	    anim: 5 ,  //动画类型
	    content: $("#editUserLayer"),			
	    //success: 
	    btn: ['修改','取消'],
	        btn1: function (index, layero) {
				var useraccount = document.getElementById("useraccount").value;
				var username = document.getElementById("username").value;
				var sex = document.getElementById("sex").value;
				var jobnumber = document.getElementById("jobnumber").value;
				var department = document.getElementById("department").value;
				var tel = document.getElementById("tel").value;
				var role = document.getElementById("role").value;
				var role = document.getElementById("worktype").value;
				var role = document.getElementById("position").value;
				var note = document.getElementById("note").value;
			
			    var de =  "&id="+data.id+"&useraccount="+useraccount+"&username="+username
						  +"&sex="+sex+"&jobnumber="+jobnumber
						  +"&department="+department+"&tel="+tel
						  +"&role="+role+"&worktype"+worktype+"&position"+position+"&note="+note;							
				console.log(de)
				$.ajax({
						type: "POST",
					    url: "user/edituser.action",
					    data: de,
					    dataType: "json",
					    success: function(result){
							if(result.code == 0){
								layer.close(index);
								layer.alert('修改成功', function(index){
									location.reload();
								});
							}else{
								layer.alert(result.msg);
							}
						}
					});
	               } 
		  });
	 
    });  
	
} ); 
	
        
	//添加adduser	
	var vm = new Vue({
	el:'#app',	//绑定表单
	 data:{
		useraccount:'',
		username:'',
	 	sex: '',
	 	jobnumber:'',
	 	department:'',
	 	tel:'',
	 	role:'',
	 	worktype:'',
	 	position:'',
	 	password:'',
	 	age:'',
	 	note:'',
	 	}, 
	methods: {
	  adduser: function(){
		layer.open({
		type: 1,		//除了信息框,open等框必须要制定type 
	    skin: 'layui-layer-molv' ,
	    title: "添加用户信息",
	    area: ['320px', '550px'],
	    offset: ['100px', '475px'], //定位坐标位置
	    closeBtn: 0 ,
	    anim: 5 ,  //动画类型
	    content: jQuery("#addUserLayer"),
	    btn: ['添加','取消'],
	        btn1: function (index) {
				var data =  "useraccount="+vm.useraccount+"&username="+vm.username
							+"&sex="+vm.sex+"&jobnumber="+vm.jobnumber
							+"&department="+vm.department+"&tel="+vm.tel
							+"&role="+vm.role+"&worktype="+vm.worktype
							+"&position="+vm.position+"&password="+vm.password
							+"&age="+vm.age+"&note="+vm.note;
				$.ajax({
						type: "POST",
					    url: "user/adduser.action",
					    data: data,
					    dataType: "json",
					    success: function(result){
							if(result.code == 0){
								layer.close(index);
								layer.alert('添加成功', function(index){
									location.reload();
								});
							}else{
								layer.alert(result.msg);
							}
						}
					});
	               } 
		  });
		 }
		},
	})
	
</script>
</body>
</html>
