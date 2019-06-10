layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#lable_msg'
        ,url:'/BlogTitleController/datagrid'
        ,toolbar: '#toolbarDemo'
        ,cols: [[
            {type: 'checkbox', fixed: 'left'}
            ,{field:'id', width:80, title: 'ID', sort: true}
            ,{field:'title', width:80, title: '标题'}
/*
            ,{field:'create_time', width:80, title: '时间', sort: true}
*/
            ,{field:'see_num', width:80, title: '浏览次数'}
            ,{field:'label', title: '标签', width: 80}
            ,{field:'content',minWidth :150, title: '文章内容', sort: true}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
        ]]
        ,page: true
    });

//监听表格复选框选择
    table.on('checkbox(lable_msg)', function(obj){
        console.log(obj)
    });

    //监听工具条
    table.on('tool(lable_msg)', function(obj){
        console.log(13123)
        $MB.n_success(13123);
        var data = obj.data;
        if(obj.event === 'del'){
            layer.msg('ID：'+ data.id + ' 的查看操作');
        } else if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
            });
        } else if(obj.event === 'edit'){
            layer.alert('编辑行：<br>'+ JSON.stringify(data))
        }
    });

    var $ = layui.$, active = {
        getCheckData: function(){ //获取选中数据
            console.log(1)
            var checkStatus = table.checkStatus('lable_msg')
                ,data = checkStatus.data;
            layer.msg(JSON.stringify(data));
            console.log(JSON.stringify(data))

        }
        ,getCheckLength: function(){ //获取选中数目
            console.log(2)
            var checkStatus = table.checkStatus('lable_msg')
                ,data = checkStatus.data;
            layer.msg('选中了：'+ data.length + ' 个');
            console.log('选中了：'+ data.length + ' 个')

        }
        ,isAll: function(){ //验证是否全选
            console.log(3)
            var checkStatus = table.checkStatus('lable_msg');
            layer.msg(checkStatus.isAll ? '全选': '未全选')
            console.log(checkStatus.isAll ? '全选': '未全选')

        }
    };

    $(".layui-btn").click(function () {
        console.log(12312312313)
        var type = $(this).data('type');
        console.log(type)
        active[type] ? active[type].call(this) : '';
    })

});


