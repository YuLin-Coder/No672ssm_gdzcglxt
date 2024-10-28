$(function() {

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

$("#cost").blur(
		function() {
			$("#cost_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cost").after("<span id='cost_msg' style='color: red'>花费金额不能为空</span>");
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
var equipmentid = $("#equipmentid").val();
var reason = $("#reason").val();
var cost = $("#cost").val();
var memo = $("#memo").val();
$("#equipmentid_msg").empty();
$("#reason_msg").empty();
$("#cost_msg").empty();
$("#memo_msg").empty();
if (equipmentid == "" || equipmentid == null) {
	$("#equipmentid").after("<span id='equipmentid_msg' style='color: red'>设备不能为空</span>");
	return false;
}
if (reason == "" || reason == null) {
	$("#reason").after("<span id='reason_msg' style='color: red'>原因不能为空</span>");
	return false;
}
if (cost == "" || cost == null) {
	$("#cost").after("<span id='cost_msg' style='color: red'>花费金额不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#equipmentid_msg").empty();
$("#reason_msg").empty();
$("#cost_msg").empty();
$("#memo_msg").empty();
});

});
