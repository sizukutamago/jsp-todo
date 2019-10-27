<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
        <head>
            <title>todo app</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>            <link rel="stylesheet" href="/css/style.css">
        </head>
        <body>
            <jsp:include page="/WEB-INF/layout/header.jsp"/>
            <div id="main">
                ${param.content}
            </div>
            <jsp:include page="/WEB-INF/layout/footer.jsp"/>
        </body>
    </html>
