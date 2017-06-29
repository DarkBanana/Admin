<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common-link.jsp" %>
<%@ include file="/WEB-INF/jsp/common-js.jsp" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!--定义操作列按钮模板-->
<script id="tpl" type="text/x-handlebars-template">
    {{#each func}}
    <button type="button" class="btn btn-{{this.type}} btn-sm" onclick="{{this.fn}}">{{this.name}}</button>
    {{/each}}
</script>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">菜单管理</h1>
    </div>
</div>
<!-- /.col-lg-12 -->
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                DataTable               
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="dataTable_wrapper">
                    <table id="dataTables-example" class="display" cellspacing="0" width="100%">
                        <thead>
                            <tr>
			            <th>用户账号</th>
						<th>用户名称</th>
						<th>性别</th>
						<th>工号</th>
						<th>部门</th>
						<th>电话</th>
						<th>角色</th>
						<th>备注</th> 
                                <th>操作</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <input type="text" class="form-control" id="name" placeholder="姓名">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="position" placeholder="位置">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="salary" placeholder="薪资">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="start_date" placeholder="时间"
                        data-date-format="yyyy/mm/dd">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="office" placeholder="工作地点">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" id="extn" placeholder="编号">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" id="initData">添加模拟数据</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div>
    </div>
</div>

<script>
    $("div.toolbar").html('<b style="color:red">自定义文字、图片等等</b>');

    //创建datatables
  var tables =  $('#dataTables-example').DataTable({
        //"autoWidth": true,//自适应宽度
        "jQueryUI": true,
        responsive: true,
        "processing": true,
        "bSort": false, //是否支持排序功能
        "oLanguage": {
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "对不起，查询不到任何相关数据",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoEmtpy": "找不到相关数据",
            "sInfoFiltered": "数据表中共为 _MAX_ 条记录)",
            "sProcessing": "正在加载中...",
            "sSearch": "搜索",
            "sUrl": "", //多语言配置文件，可将oLanguage的设置放在一个txt文件中，例：Javascript/datatable/dtCH.txt
            "oPaginate": {
                "sFirst": "第一页",
                "sPrevious": " 上一页 ",
                "sNext": " 下一页 ",
                "sLast": " 最后一页 "
            }
        }, //多语言配置
        //"ajax": '/Menu/LoadMenuList',
        "ajax": {
            "type": "post",
            "url": 'user/queryuser.action',
        },
        columns: [
               { "data": "useraccount" },
				{ "data": "username" },
				{ "data": "sex" },
				{ "data": "jobnumber" },
				{ "data": "department" },
				{ "data": "tel" },
				{ "data": "role" },
				{ "data": "note" },
            { data: null },
        ],
        //设置定义列的初始属性
        "columnDefs": [{
            "targets": -1,//编辑
            "data": null,
            "defaultContent": "<button id='editrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button> " +
                "<button id='delrow' class='btn btn-primary' type='button'><i class='fa fa-trash-o'></i></button>"
        },

        ],
        //定义datables布局
        "dom": "<'row'<'col-xs-2'l><'#mytool.col-xs-4'><'col-xs-6'f>r>" +
                    "t" +
                    "<'row'<'col-xs-6'i><'col-xs-6'p>>",
        //初始化结束后的回调函数
        initComplete: function () {
            $("#mytool").append('<button type="button" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">添加</button>');
            $("#datainit").on("click", initData);
        }
    });

    // 数据删除
    $('#dataTables-example tbody').on('click', 'button#delrow', function () {
        var data = tables.row($(this).parents('tr')).data();
        $.ajax({
            url: 'user/deluser.action',
            type: 'POST',
            dataType: 'json',
            data: { id: data[0] },
        })
        .done(function (data) {
            if (data == "success") {
                tables.ajax.reload();
            };
        })
        .fail(function () {
            alert("error");
        });
    });

    // 数据编辑
    $('#dataTables-example tbody').on('click', 'button#editrow', function () {
        //var data = tables.row($(this).parents('tr')).data();
        //var fields = $("#add-form").serializeArray();
        //jQuery.each(fields, function (i, field) {
        //    //jquery根据name属性查找
        //    $(":input[name='" + field.name + "']").val(data[i]);
        //});
        //$(":input[name='mark']").val("edit");
        $("#myModal").modal("show");//弹出框show

    });
</script>



 
 
 
</body>
</html>
