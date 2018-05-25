/**
 * 初始化test_record详情对话框
 */
var TestRecordInfoDlg = {
    testRecordInfoData : {}
};

/**
 * 清除数据
 */
TestRecordInfoDlg.clearData = function() {
    this.testRecordInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TestRecordInfoDlg.set = function(key, val) {
    this.testRecordInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
TestRecordInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
TestRecordInfoDlg.close = function() {
    parent.layer.close(window.parent.TestRecord.layerIndex);
}

/**
 * 收集数据
 */
TestRecordInfoDlg.collectData = function() {
    this
    .set('id')
    .set('testname')
    .set('testscore')
    .set('testtime')
    .set('testip')
    .set('sex')
    .set('age');
}

/**
 * 提交添加
 */
TestRecordInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/testRecord/add", function(data){
        Feng.success("添加成功!");
        window.parent.TestRecord.table.refresh();
        TestRecordInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.testRecordInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
TestRecordInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/testRecord/update", function(data){
        Feng.success("修改成功!");
        window.parent.TestRecord.table.refresh();
        TestRecordInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.testRecordInfoData);
    ajax.start();
}

$(function() {

});
