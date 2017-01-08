<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="homeTitle"/></title>
</head>
<body>
<div class="errClass"><c:if test="${errMsg ne null}"> <spring:message code="${errMsg}"/> </c:if></div>
<div class="msgClass"><c:if test="${msg ne null}"> <spring:message code="${msg}"/> </c:if></div>
<a href="student.do"><spring:message code="enterStudentDetail"/></a><br/>
<a href="score.do"><spring:message code="enterTestDetail"/></a><br/>
<a href="result.do"><spring:message code="showStudentList"/></a><br/>
</body>
</html>