<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>
</title>
</head>
<body>
<f:form id="defaultForm" method="post" modelAttribute="data" action="updateTest.htm">
<f:input type="hidden" path="testId" />
a:<f:input path="a" value=""  />
<input type="submit" name="submit" value="Click"></input>
</f:form>
</body>
</html>