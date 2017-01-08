<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="./header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="SCOREPAGETITLE"/></title>
</head>
<body>
<form:form action="score.do" method="post" commandName="score">
<table>
		<tr>
			<td><form:label path="regdNo"><spring:message code="regdNo"/></form:label></td>
			<td>
				<form:select path="regdNo">
					<option value="select">--select--</option>
					<form:options items="${requestScope.regdnos}"/>
				</form:select>
			</td>
			<td><form:errors path="regdNo" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
			<td><form:label path="testName"><spring:message code="testName"/></form:label></td>
			<td><form:input path="testName"></form:input></td>
			<td><form:errors path="testName" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
			<td><form:label path="maxScore"><spring:message code="maxScore"/></form:label></td>
			<td><form:input path="maxScore"></form:input></td>
			<td><form:errors path="maxScore" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
			<td><form:label path="testScore"><spring:message code="score"/></form:label></td>
			<td><form:input path="testScore"></form:input></td>
			<td><form:errors path="testScore" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
			<td><form:label path="testDate"><spring:message code="date"/></form:label></td>
			<td><form:input path="testDate"></form:input></td>
			<td><form:errors path="testDate" cssClass="errclass"></form:errors></td>
		</tr>
		<tr>
		<td colspan="3">
		<input type="submit" name="submit" value='<spring:message code="save"/>'>
		<input type="reset" name="reset" value='<spring:message code="reset"/>'>
		<input type="button" name="cancel" value='<spring:message code="cancel"/>' 
										onclick='window.location.href="home.do"'>
		</td>
		</tr>
	</table>

</form:form>
</body>
</html>
