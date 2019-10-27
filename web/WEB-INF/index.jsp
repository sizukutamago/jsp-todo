<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/layout/app.jsp">
    <jsp:param name="content">
        <jsp:attribute name="value">
            <p>todo</p>

            <ul>
                <c:forEach var="todo" items="${todoList.todoList}">
                    <li>${todo.task}</li>
                </c:forEach>
            </ul>
        </jsp:attribute>
    </jsp:param>
</jsp:include>