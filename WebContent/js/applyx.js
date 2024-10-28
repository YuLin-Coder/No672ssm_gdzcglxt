$(function() {

$("#ano").blur(
		function() {
			$("#ano_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#ano").after("<span id='ano_msg' style='color: red'>申请单号不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>资产类型不能为空</span>");
			}
	});

$("#equipmentname").blur(
		function() {
			$("#equipmentname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#equipmentname").after("<span id='equipmentname_msg' style='color: red'>设备名称不能为空</span>");
			}
	});

$("#reason").blur(
		function() {
			$("#reason_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#reason").after("<span id='reason_msg' style='color: red'>申请原因不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>采购数量不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var ano = $("#ano").val();
var cateid = $("#cateid").val();
var equipmentname = $("#equipmentname").val();
var reason = $("#reason").val();
var num = $("#num").val();
var memo = $("#memo").val();
$("#ano_msg").empty();
$("#cateid_msg").empty();
$("#equipmentname_msg").empty();
$("#reason_msg").empty();
$("#num_msg").empty();
$("#memo_msg").empty();
if (ano == "" || ano == null) {
	$("#ano").after("<span id='ano_msg' style='color: red'>申请单号不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>资产类型不能为空</span>");
	return false;
}
if (equipmentname == "" || equipmentname == null) {
	$("#equipmentname").after("<span id='equipmentname_msg' style='color: red'>设备名称不能为空</span>");
	return false;
}
if (reason == "" || reason == null) {
	$("#reason").after("<span id='reason_msg' style='color: red'>申请原因不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>采购数量不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#ano_msg").empty();
$("#cateid_msg").empty();
$("#equipmentname_msg").empty();
$("#reason_msg").empty();
$("#num_msg").empty();
$("#memo_msg").empty();
});

});
