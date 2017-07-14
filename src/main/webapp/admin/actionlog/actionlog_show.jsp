<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}">
    <title>Title</title>
    <link rel="stylesheet" href="res/bootstrap/css/bootstrap.min.css">
</head>
<body>
<div class="jumbotron">
    <h1>${notepad.npTitle}</h1>
    <p>${notepad.npContent}</p>
</div>
</body>
</html>
