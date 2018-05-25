/**
 * mbti解析管理初始化
 */
var MbtiAns = {
    id: "MbtiAnsTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
MbtiAns.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '评测结果', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '职业', field: 'profession', visible: true, align: 'center', valign: 'middle'},
            {title: '基本分析报告', field: 'step1', visible: true, align: 'center', valign: 'middle'},
            {title: '特征短评', field: 'features', visible: true, align: 'center', valign: 'middle'},
            {title: '基本描述', field: 'describe', visible: true, align: 'center', valign: 'middle'},
            {title: '盲点，误区', field: 'blindSpot', visible: true, align: 'center', valign: 'middle'},
            {title: '工作中的劣势', field: 'inferiority1', visible: true, align: 'center', valign: 'middle'},
            {title: '职业发展分析报告', field: 'step2', visible: true, align: 'center', valign: 'middle'},
            {title: '工作中的劣势', field: 'inferiority2', visible: true, align: 'center', valign: 'middle'},
            {title: '岗位的特性', field: 'postStyle', visible: true, align: 'center', valign: 'middle'},
            {title: '适合的岗位', field: 'postSuitable', visible: true, align: 'center', valign: 'middle'},
            {title: '个人发展建议', field: 'pdp', visible: true, align: 'center', valign: 'middle'},
            {title: '工作环境分析报告', field: 'step3', visible: true, align: 'center', valign: 'middle'},
            {title: '组织的社会性', field: 'socialityOg', visible: true, align: 'center', valign: 'middle'},
            {title: '组织的结构和细节关注度', field: 'structureDetail', visible: true, align: 'center', valign: 'middle'},
            {title: '组织的开放性和想象力', field: 'opennessImagination', visible: true, align: 'center', valign: 'middle'},
            {title: '对组织的合作性和和谐型', field: 'cooperativeHarmonious', visible: true, align: 'center', valign: 'middle'},
            {title: '对组织社会性的要求', field: 'sociality', visible: true, align: 'center', valign: 'middle'},
            {title: '对组织及对细节的关注度要求高', field: 'details', visible: true, align: 'center', valign: 'middle'},
            {title: '对组织的开放性和想象力要求', field: 'openness', visible: true, align: 'center', valign: 'middle'},
            {title: '对组织的合作性和和谐型要求', field: 'cooperative', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
MbtiAns.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        MbtiAns.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加mbti解析
 */
MbtiAns.openAddMbtiAns = function () {
    var index = layer.open({
        type: 2,
        title: '添加mbti解析',
        area: ['80%', '70%'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/mbtiAns/mbtiAns_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看mbti解析详情
 */
MbtiAns.openMbtiAnsDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'mbti解析详情',
            area: ['80%', '70%'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/mbtiAns/mbtiAns_update/' + MbtiAns.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除mbti解析
 */
MbtiAns.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/mbtiAns/delete", function (data) {
            Feng.success("删除成功!");
            MbtiAns.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("mbtiAnsId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询mbti解析列表
 */
MbtiAns.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    MbtiAns.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = MbtiAns.initColumn();
    var table = new BSTable(MbtiAns.id, "/mbtiAns/list", defaultColunms);
    table.setPaginationType("client");
    MbtiAns.table = table.init();
});
