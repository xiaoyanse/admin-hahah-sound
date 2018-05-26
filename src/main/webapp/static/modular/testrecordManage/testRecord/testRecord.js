/**
 * testrecord管理初始化
 */
var TestRecord = {
    id: "TestRecordTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
TestRecord.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: 'id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '测试者姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '测试名称', field: 'testname', visible: true, align: 'center', valign: 'middle'},
            {title: '测试分数或结果', field: 'testscore', visible: true, align: 'center', valign: 'middle'},
            {title: '测试时间', field: 'testtime', visible: true, align: 'center', valign: 'middle'},
            {title: '测试电脑ip', field: 'testip', visible: true, align: 'center', valign: 'middle'},
            {title: '测试人性别', field: 'sex', visible: true, align: 'center', valign: 'middle'},
            {title: '年龄', field: 'age', visible: true, align: 'center', valign: 'middle'},
            {title: 'account账号', field: 'commeee', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
TestRecord.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        TestRecord.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加testrecord
 */
TestRecord.openAddTestRecord = function () {
    var index = layer.open({
        type: 2,
        title: '添加testrecord',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/testRecord/testRecord_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看testrecord详情
 */
TestRecord.openTestRecordDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'testrecord详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/testRecord/testRecord_update/' + TestRecord.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除testrecord
 */
TestRecord.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/testRecord/delete", function (data) {
            Feng.success("删除成功!");
            TestRecord.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("testRecordId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询testrecord列表
 */
TestRecord.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    TestRecord.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = TestRecord.initColumn();
   // var table = new BSTable(TestRecord.id, "/testRecord/list", defaultColunms);
	var count=document.getElementById('usercount').value;

    var table = new BSTable(TestRecord.id, "/testRecord/list/"+count, defaultColunms);
    table.setPaginationType("client");
    TestRecord.table = table.init();
});
