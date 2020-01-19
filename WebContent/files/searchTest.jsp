<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
</head>
<body>
<table id="example" cellspacing="0" width="100%" border=1>
                                <thead>
                                    <tr>
                                        <th>Test ID</th>
										<th>a</th>
                                        <th>Action</th>
                                         
                                    </tr>
                                </thead>
									<c:forEach items="${data}" var="i">
                                
                                    <tr>
                                        <td>${i.testId}</td>
                                        <td>${i.a}</td>
                                        <th><a href="deleteTest.htm?id=${i.testId}">Delete Record</a><a href="editTest.htm?id=${i.testId}">Edit Record</a></th>
                                    </tr>       
                                </c:forEach>
                            </table>
</body>
</html>