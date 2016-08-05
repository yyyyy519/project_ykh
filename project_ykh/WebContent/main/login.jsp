<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String user_name = (String)session.getAttribute("user_name");
	System.out.println(user_name + "<-- user_name");
%>
<html>
<head>
<title>Insert title here</title>
<style>
.div {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	text-align: center;
	background-image: url("../images/Cute-Wallpaper-9.jpg");
}

.div .login {	
	background: #EAEAEA;
	background : rgba(234, 234, 234, 0.6);
	padding: 40px;
	height: auto;
	min-height: 100px;
	overflow: auto;
	border-radius: 6px; display : inline-block;
	vertical-align: middle;
	display: inline-block
}

.div .blank {
	display: inline-block;
	width: 0;
	height: 100%;
	vertical-align: middle
}

input /* 바깥 테두리에 4px의 공간을 준다 */ {
	margin-bottom: 3px;
}

.loginButton .join {
	background-color: #8C8C8C; /* Green */
	border: none;
	color: white;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 13px;
	margin: 1px;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	cursor: pointer;
}

.button1 {
	background-color: #8C8C8C;
	color: white;
	border: 2px solid #8C8C8C;
}

.join {
	margin-top: 10px;
}
</style>
</head>
<body>
	<form action="<%= request.getContextPath() %>/login/login_pro.jsp" method="post">
	<div class="div"> <!-- 정렬을 위한 div / http://nuli.navercorp.com/sharing/blog/post/1132794 2번 -->
		<div class="login">
			<input id="id" name="id" type="text" placeholder="아이디"><br> <!-- placeholder : 한 단어나 짧은 구로 이루어진 ‘힌트’ '아이디'라는 문자열을 입력 영역의 자리에서 제공하는 경우에 사용 -->
			<input id="pw" name="pw" type="password" placeholder="비밀번호"><br>
			<input id="loginBtn" name="loginBtn" class="loginButton button1" type="submit" value="로그인" style="width: 173px"><br>
			<a href="" style="color: #444444; font-size: 0.9em;"> 아이디/비밀번호 찾기</a><br>
			<input id="join" name="join" class="join button1" type="button" value="회원가입하기" style="width: 173px">
		</div>
		<div class="blank"></div>
	</div>
	</form>
</body>
</html>