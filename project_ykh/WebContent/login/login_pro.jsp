<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Mdao" %>
<%@ page import = "kr.or.ksmart.dto.User" %>

<%
String id = request.getParameter("id");
String pw = request.getParameter("pw");
System.out.println(id + "<-- id login_pro.jsp");
System.out.println(pw + "<-- pw login_pro.jsp");

Mdao dao = new Mdao();
String result = dao.mLoginCheck(id, pw);
//out.println("���:"+result);
if(result.equals("02�α��μ���")){
	//�̸��� ������ ������ session������ ����
	User u = dao.mGetForSession(id);
	session.setAttribute("user_name", u.getUser_name());
%>
<script type="text/javascript">
	alert("�α��μ���");
</script>	
<%
} else if(result.equals("01���̵����ġ")) {
%>
	<script type="text/javascript">
	alert("���̵� ����ġ");
	</script>		
<%
} else if(result.equals("03�������ġ")) {
%>
	<script type="text/javascript">
	alert("��й�ȣ ����ġ");
	</script>		
<%
}
%>
<script type="text/javascript">
location.href = "<%= request.getContextPath() %>/index.jsp";
</script>		