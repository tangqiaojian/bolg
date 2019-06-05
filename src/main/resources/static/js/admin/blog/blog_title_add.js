layui.use('table', function(){
    var table = layui.table;

    table.render({
        elem: '#titile'
        ,url:'/BlogTitleController/datagrid'
        ,cols: [[
            {field:'id', width:80, title: 'ID', sort: true}
            ,{field:'title', width:80, title: '标题'}
/*
            ,{field:'create_time', width:80, title: '时间', sort: true}
*/
            ,{field:'see_num', width:80, title: '浏览次数'}
            ,{field:'label', title: '标签', width: 80}
            ,{field:'content',minWidth :150, title: '文章内容', sort: true}
        ]]
        ,page: true
    });
});