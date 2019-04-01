<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var username = "${sessionScope.username}";
	var ws;
	var target = 'ws://localhost:8080/chat_01/chatSocket?username=' + username;
	window.onload = function() {
		if ('WebSocket' in window) {
			ws = new WebSocket(target);
		} else if ('MozWebSocket' in window) {
			ws = new MozWebSocket(target);
		} else {
			alert("WebSocket is not supported this brower");
			return;
		}

		ws.onmessage = function(event){
			eval('var msg = '+event.data+";");
			if(undefined!=msg.message){
				$('#content').append(msg.message);
			}
			if(undefined!=msg.usernames){
				$('#userList').html("");
				$('msg.usernames').each(function(){
					$('#userList').append(this+"</br>")
				});
			}
			if(undefined!=content){
				$("#content").append(msg.content);
			}
		}		
	}
	function subSend(){
		var ss = $("#userList");
		var val = $('#msg').val();
		var obj = null;
		if(ss.size() == 0){
			obj={
				msg:val,
				type:1//１广播　２单聊
			}
		}else{
			var to=$('#userList').val();
			obj={
					to:to,
					msg:val,
					type:2//单聊
			}
		}
		var str = JSON.stringify(obj);
		ws.send(str);
		var val = $("#msg").val();
		sw.send(val);
		$("#msg").val("");
	}
</script>
</head>
<body>
	<div id="container" style="border: 1px solid black" width="400px"
		;height="400px" float="left">
		<div id="content" style="height: 300px">
			<div style="border-top: 1px solid black" width="400px" height="50px">
				<input id="msg">
				<button onclick="subSend()">send</button>
			</div>
		</div>
		<div id="userList" style="border: 1px solid black" width="100px"
			height="400px" float="left"></div>
	</div>
</body>
</html>






















