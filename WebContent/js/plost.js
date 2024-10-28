$(function() {

$("#pno").blur(
		function() {
			$("#pno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#pno").after("<span id='pno_msg' style='color: red'>单号不能为空</span>");
			}
	});

$("#equipmentid").blur(
		function() {
			$("#equipmentid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#equipmentid").after("<span id='equipmentid_msg' style='color: red'>设备不能为空</span>");
			}
	});

$("#reason").blur(
		function() {
			$("#reason_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#reason").after("<span id='reason_msg' style='color: red'>原因不能为空</span>");
			}
	});

$("#lost").blur(
		function() {
			$("#lost_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#lost").after("<span id='lost_msg' style='color: red'>损失不能为空</span>");
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
var pno = $("#pno").val();
var equipmentid = $("#equipmentid").val();
var reason = $("#reason").val();
var lost = $("#lost").val();
var memo = $("#memo").val();
$("#pno_msg").empty();
$("#equipmentid_msg").empty();
$("#reason_msg").empty();
$("#lost_msg").empty();
$("#memo_msg").empty();
if (pno == "" || pno == null) {
	$("#pno").after("<span id='pno_msg' style='color: red'>单号不能为空</span>");
	return false;
}
if (equipmentid == "" || equipmentid == null) {
	$("#equipmentid").after("<span id='equipmentid_msg' style='color: red'>设备不能为空</span>");
	return false;
}
if (reason == "" || reason == null) {
	$("#reason").after("<span id='reason_msg' style='color: red'>原因不能为空</span>");
	return false;
}
if (lost == "" || lost == null) {
	$("#lost").after("<span id='lost_msg' style='color: red'>损失不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#pno_msg").empty();
$("#equipmentid_msg").empty();
$("#reason_msg").empty();
$("#lost_msg").empty();
$("#memo_msg").empty();
});

});
