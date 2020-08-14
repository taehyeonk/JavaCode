<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hankki</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#getStore").click(function() {
		$("#result").html("");
		$.ajax({
			type: 'GET',
			url: './hankki/json/'+$("#storeid").val(),
			success: function(data) {
				var serverData = JSON.stringify(data);
				$("#result").html(serverData);
			},
			error : function(error) {
				console.log(error);
			}
		})
	})
	$("#getStore2").click(function() {
		var formData = $('#form').serializeArray();
		console.log(JSON.stringify(formData));
		$("#result").html("");
		$.ajax({
			type: 'POST',
			url: './hankki/ajax',
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			data: JSON.stringify(formData),
			success: function(data) {
				var serverData = JSON.stringify(data);
				$("#result").html(serverData);
			},
			error : function(error) {
				console.log(error);
			}
		})
	})
});
</script>
</head>
<body>
<h1>
	Hankki Sample  
</h1>
<a href="<c:url value='/hankki'/>">가게 목록(동기)</a>
<form id="form">
<input type="text" id="storeid" name="storeId" value="100">
<input type="button" id="getStore" value="가게정보(비동기 GET 방식)">
<input type="button" id="getStore2" value="가게정보(비동기 POST 방식)">
</form>
<div id="result"></div>
</body>
</html>
