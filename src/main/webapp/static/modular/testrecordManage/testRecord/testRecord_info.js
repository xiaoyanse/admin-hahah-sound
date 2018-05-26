/**
 * 初始化testrecord详情对话框
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
    .set('name')
    .set('testname')
    .set('testscore')
    .set('testtime')
    .set('testip')
    .set('sex')
    .set('age')
    .set('commeee');
}

/**
 * 提交添加
 */
TestRecordInfoDlg.addSubmit = function() {

    this.clearData();
    
	document.getElementById('testtime').value = CurentTime();
    
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



/**
 * 获取当前系统时间
 * 
 * @returns 时间
 */

function CurentTime() {
	var now = new Date();

	var year = now.getFullYear(); // 年
	var month = now.getMonth() + 1; // 月
	var day = now.getDate(); // 日

	var hh = now.getHours(); // 时
	var mm = now.getMinutes(); // 分
	var ss = now.getSeconds(); // 秒

	var clock = year + "-";

	if (month < 10)
		clock += "0";

	clock += month + "-";

	if (day < 10)
		clock += "0";

	clock += day + " ";

	if (hh < 10)
		clock += "0";

	clock += hh + ":";
	if (mm < 10)
		clock += '0';
	clock += mm + ":";

	if (ss < 10)
		clock += '0';
	clock += ss;
	return (clock);
}

$(function() {
	document.getElementById('testip').value = returnCitySN["cip"];
});
