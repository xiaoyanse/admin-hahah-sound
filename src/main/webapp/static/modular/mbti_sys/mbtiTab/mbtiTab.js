/**
 * mbti管理初始化
 */
var MbtiTab = {
    id: "MbtiTabTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
MbtiTab.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '题目', field: 'timu', visible: true, align: 'center', valign: 'middle'},
            {title: '选项1', field: 'xuanxiang1', visible: true, align: 'center', valign: 'middle'},
            {title: '选项2', field: 'xuanxiang2', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
MbtiTab.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        MbtiTab.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加mbti
 */
MbtiTab.openAddMbtiTab = function () {
    var index = layer.open({
        type: 2,
        title: '添加mbti',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/mbtiTab/mbtiTab_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看mbti详情
 */
MbtiTab.openMbtiTabDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'mbti详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/mbtiTab/mbtiTab_update/' + MbtiTab.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除mbti
 */
MbtiTab.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/mbtiTab/delete", function (data) {
            Feng.success("删除成功!");
            MbtiTab.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("mbtiTabId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询mbti列表
 */
MbtiTab.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    MbtiTab.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = MbtiTab.initColumn();
    var table = new BSTable(MbtiTab.id, "/mbtiTab/list", defaultColunms);
    table.setPaginationType("client");
    MbtiTab.table = table.init();
});
