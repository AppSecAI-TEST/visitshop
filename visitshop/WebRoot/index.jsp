<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="visitshop.css">
<script src="jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	function checkDB() {
		$.get("check", function(data, status) {
			//alert("数据: " + data);
			$("#dblabel").html(data);
		});
	}
	function showImg() {
		$("#img").attr("src", "http://localhost:8080/visitshop/test.png");
		$("#img").attr("width", "300px");
		$("#img").attr("height", "150px");
	}
	function checkService() {
		$.get("appinfo", function(data, status) {
			//alert("数据: " + data);
			$("#serverlabel").html(data);
		});
	}
</script>
</head>

<body background="#cccccc">

	<form id="form" method="post" class="bootstrap-frm">
		<h1>欢迎使用微服私访后台服务.</h1>
		<br />

		<div>
			<input type="button" value="连接数据库" class="button" onclick="checkDB()" />
			<br /> <label class="label span" id="dblabel"></label>
		</div>
		<div>
			<input type="button" value="访问图片" class="button" onclick="showImg()" />
			<br /> <img alt="" id="img" src="" align="middle"> <br />
		</div>
		<div>
			<input type="button" value="接口测试" class="button"
				onclick="checkService()" /> <br /> <label class="label span"
				id="serverlabel"></label>
		</div>
	</form>
</body>
</html>
