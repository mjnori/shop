<%--
  Created by IntelliJ IDEA.
  User: Setare
  Date: 11/21/2024
  Time: 8:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <p> Wellcome dear     <%= request.getAttribute("username") %> </p>
</body>
</html>
