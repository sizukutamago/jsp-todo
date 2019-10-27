<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:include page="/WEB-INF/layout/app.jsp">
    <jsp:param name="content">
        <jsp:attribute name="value">
            <p>todo</p>

            <ul>
                <li>task</li>
                <li>task2</li>
                ${todoList}
            </ul>
        </jsp:attribute>
    </jsp:param>
</jsp:include>