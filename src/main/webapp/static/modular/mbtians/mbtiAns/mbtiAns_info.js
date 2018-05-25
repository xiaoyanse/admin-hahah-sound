/**
 * 初始化mbti解析详情对话框
 */
var MbtiAnsInfoDlg = {
    mbtiAnsInfoData : {}
};

/**
 * 清除数据
 */
MbtiAnsInfoDlg.clearData = function() {
    this.mbtiAnsInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MbtiAnsInfoDlg.set = function(key, val) {
    this.mbtiAnsInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MbtiAnsInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
MbtiAnsInfoDlg.close = function() {
    parent.layer.close(window.parent.MbtiAns.layerIndex);
}

/**
 * 收集数据
 */
MbtiAnsInfoDlg.collectData = function() {
    this
    .set('id')
    .set('profession')
    .set('step1')
    .set('features')
    .set('describe')
    .set('blindSpot')
    .set('inferiority1')
    .set('step2')
    .set('inferiority2')
    .set('postStyle')
    .set('postSuitable')
    .set('pdp')
    .set('step3')
    .set('socialityOg')
    .set('structureDetail')
    .set('opennessImagination')
    .set('cooperativeHarmonious')
    .set('sociality')
    .set('details')
    .set('openness')
    .set('cooperative');
}

/**
 * 提交添加
 */
MbtiAnsInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mbtiAns/add", function(data){
        Feng.success("添加成功!");
        window.parent.MbtiAns.table.refresh();
        MbtiAnsInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.mbtiAnsInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
MbtiAnsInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/mbtiAns/update", function(data){
        Feng.success("修改成功!");
        window.parent.MbtiAns.table.refresh();
        MbtiAnsInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.mbtiAnsInfoData);
    ajax.start();
}

$(function() {

});
