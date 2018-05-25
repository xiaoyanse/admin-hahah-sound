/**
 * 初始化mbti详情对话框
 */
var MbtiTabInfoDlg = {
    mbtiTabInfoData : {}
};

/**
 * 清除数据
 */
MbtiTabInfoDlg.clearData = function() {
    this.mbtiTabInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MbtiTabInfoDlg.set = function(key, val) {
    this.mbtiTabInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MbtiTabInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
MbtiTabInfoDlg.close = function() {
    parent.layer.close(window.parent.MbtiTab.layerIndex);
}

/**
 * 收集数据
 */
MbtiTabInfoDlg.collectData = function() {
    this
    .set('id')
    .set('timu')
    .set('xuanxiang1')
    .set('xuanxiang2');
}

/**
 * 提交添加
 */
MbtiTabInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mbtiTab/add", function(data){
        Feng.success("添加成功!");
        window.parent.MbtiTab.table.refresh();
        MbtiTabInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.mbtiTabInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
MbtiTabInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mbtiTab/update", function(data){
        Feng.success("修改成功!");
        window.parent.MbtiTab.table.refresh();
        MbtiTabInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.mbtiTabInfoData);
    ajax.start();
}

$(function() {

});
