<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/layout/app.jsp">
    <jsp:param name="content">
        <jsp:attribute name="value">
            <h2>login</h2>
            <form action="/" method="post">
                email: <input type="email" name="email">
                password: <input type="password" name="password">
                <input type="submit" value="login">
            </form>

            <h2>register</h2>
            <form action="/register" method="post">
                email: <input type="email" name="email">
                password: <input type="password" name="password">
                name: <input type="text" name="name">
                <input type="submit" value="register">
            </form>
        </jsp:attribute>
    </jsp:param>

</jsp:include>