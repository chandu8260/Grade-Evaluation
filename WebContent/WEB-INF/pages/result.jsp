<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="RESULTPAGETITLE"></spring:message></title>
</head>
<body>
<table width="80%" border="1">
<tr>
	<th width="25%">Regd No</th>
	<th width="60%">Name</th>
	<th width="15%">Grade</th>
</tr>
<c:forEach items="${results}" var="result" >
<tr>
	<td width="25%">${result.regdNo}</td>
	<td width="60%"><a href="showtests.do?regdno=${result.regdNo}" title="${result.studentName}">${result.studentName}</a></td>
	<td width="15%">${result.grade}</td>
</tr>
</c:forEach>
</table><br/><hr/>
<c:if test="${scores ne null}">
	<h2>Appeared Tests</h2>
	<c:choose>
		<c:when test="${empty scores}">
			Not appeared any tests
		</c:when>
		<c:otherwise>
			<table width="60%" border="1">
				<tr>
					<th width="55%">Test Name</th>
					<th width="15%">Max Score</th>
					<th width="15%">Obtained Score</th>
					<th width="15%">Date of Test</th>
				</tr>
				<c:forEach items="${scores}" var="score" >
				<tr>
					<td width="45%">${score.testName}</td>
					<td width="15%">${score.maxScore}</td>
					<td width="15%">${score.testScore}</td>
					<td width="25%">${score.testDate}</td>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
	<br/><hr/>
</c:if>
<input type="button" name="cancel" value='<spring:message code="cancel"/>' 
						onclick='window.location.href="home.do"'>
</body>
</html>

