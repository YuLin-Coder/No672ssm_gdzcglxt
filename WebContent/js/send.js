$(function() {

$("#employid").blur(
		function() {
			$("#employid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#employid").after("<span id='employid_msg' style='color: red'>接收人不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>接收数量不能为空</span>");
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
var employid = $("#employid").val();
var num = $("#num").val();
var memo = $("#memo").val();
$("#employid_msg").empty();
$("#num_msg").empty();
$("#memo_msg").empty();
if (employid == "" || employid == null) {
	$("#employid").after("<span id='employid_msg' style='color: red'>接收人不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>接收数量不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#employid_msg").empty();
$("#num_msg").empty();
$("#memo_msg").empty();
});

});
