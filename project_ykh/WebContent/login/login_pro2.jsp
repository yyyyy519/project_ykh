<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	System.out.println(id+ "<-id login_pro.jsp");
	System.out.println(pw+ "<-pw login_pro.jsp");
//가입된 회원 정보 가정 시작
	String dbid = "id001";
	String dbpw = "pw001";
	String dbname = "홍길동";
	String dblevel = "관리자";
//가입된 회원 정보 가정 끝	


//입력된 아이디와 db아이디 비교/패스워드와 db패스워드 비교
	if(id.equals(dbid)){
		System.out.println("01 아이디 일치");
		if(pw.equals(dbpw)){
			System.out.println("03 로그인 성공");
			//session영역에 이름과 권한을 셋팅 시작
			session.setAttribute("S_NAME",dbname);
			session.setAttribute("S_LEVEL",dblevel);
			//session영역에 이름과 권한을 셋팅 끝
			//index.jsp로 이동
			//response.sendRedirect(request.getContextPath()+"/user/index.jsp");
%>
	<script type="text/javascript">
	alert("로그인");
	location.href = "<%= request.getContextPath() %>/user/index.jsp";
	</script>		
<%
		}else{
			System.out.println("04 비밀번호 불일치");
%>
	<script type="text/javascript">
	alert("비밀번호 불일치");
	location.href = "<%= request.getContextPath() %>/user/index.jsp";
	</script>		
<%
		}
	}else{
		System.out.println("02 아이디 불일치");
%>
	<script type="text/javascript">
	alert("아이디 불일치");
	location.href = "<%= request.getContextPath() %>/user/index.jsp";
	</script>		
<%
	}

%>