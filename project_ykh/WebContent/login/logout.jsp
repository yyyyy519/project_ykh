<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	session.invalidate();	//��������
%>
<script type="text/javascript">
	alert("�α׾ƿ�");
	location.href = "<%= request.getContextPath() %>/user/index.jsp";
</script>