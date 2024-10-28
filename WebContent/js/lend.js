$(function() {

$("#lno").blur(
		function() {
			$("#lno_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#lno").after("<span id='lno_msg' style='color: red'>借用单号不能为空</span>");
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
				$("#reason").after("<span id='reason_msg' style='color: red'>借用原因不能为空</span>");
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
var lno = $("#lno").val();
var equipmentid = $("#equipmentid").val();
var reason = $("#reason").val();
var memo = $("#memo").val();
$("#lno_msg").empty();
$("#equipmentid_msg").empty();
$("#reason_msg").empty();
$("#memo_msg").empty();
if (lno == "" || lno == null) {
	$("#lno").after("<span id='lno_msg' style='color: red'>借用单号不能为空</span>");
	return false;
}
if (equipmentid == "" || equipmentid == null) {
	$("#equipmentid").after("<span id='equipmentid_msg' style='color: red'>设备不能为空</span>");
	return false;
}
if (reason == "" || reason == null) {
	$("#reason").after("<span id='reason_msg' style='color: red'>借用原因不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#lno_msg").empty();
$("#equipmentid_msg").empty();
$("#reason_msg").empty();
$("#memo_msg").empty();
});

});
