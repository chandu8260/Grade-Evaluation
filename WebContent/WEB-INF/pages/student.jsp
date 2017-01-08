<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="./header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="STUDENTPAGETITLE"/></title>
</head>
<body>
<form:form action="student.do" method="post" commandName="student">
<table>
		<tr>
			<td><form:label path="studentName"><spring:message code="studentName"/></form:label></td>
			<td><form:input path="studentName"></form:input></td>
			<td><form:errors path="studentName" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
			<td><form:label path="regdNo"><spring:message code="registrationNo"/></form:label></td>
			<td><form:input path="regdNo"></form:input></td>
			<td><form:errors path="regdNo" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
			<td><form:label path="address"><spring:message code="address"/></form:label></td>
			<td><form:input path="address"></form:input></td>
			<td><form:errors path="address" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
			<td><form:label path="phoneNo"><spring:message code="phone"/></form:label></td>
			<td><form:input path="phoneNo"></form:input></td>
			<td><form:errors path="phoneNo" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
		<td colspan="3">
		<input type="submit" name="submit" value="<spring:message code="save"/>">
		<input type="reset" name="reset" value="<spring:message code="reset"/>">
		<input type="button" name="cancel" value="<spring:message code="cancel"/>" onclick="window.location.href='home.do'">
		</td>
		</tr>
	</table>

</form:form>
</body>
</html>