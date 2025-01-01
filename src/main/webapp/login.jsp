<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib   uri="/WEB-INF/struts-html.tld"  prefix="s" %>
<%@ taglib   uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib   uri="/WEB-INF/struts-logic.tld"  prefix="logic" %>



<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>


</head>
<body>
<s:form action="/login.do"  method="post" styleId="formStruts">
    <s:text property="nickName" styleId="userNameStruts"/><br>
    <s:password property="password" styleId="passwordStruts"/><br>
    <s:hidden property="method" styleId="methodStruts"/><br>
    <p id="message">
                <% if (request.getAttribute("message") != null) { %>
                <%= request.getAttribute("message") %>
                <%}%>  </p>
    <s:submit property="button1" onclick="registerFunck()" value="Regist"/>
    <s:submit property="button2" onclick="loginFunch()" value="Login"/>
</s:form>
<%--<h1>this is a test</h1>--%>

<%--<form id="form">--%>
<%--    Username:<input type="text" name="username" id="username"><br>--%>
<%--    Password: <input type="password" name="password" id="password"><br>--%>
<%--    <p id="message">--%>
<%--        <% if (request.getAttribute("message") != null) { %>--%>
<%--        <%= request.getAttribute("message") %>--%>
<%--        <%}%>--%>

<%--    </p>--%>
<%--    <input type="submit" id="register" value="register"  onclick="registerFunck()">--%>
<%--    <input type="submit" id="login" value="login"   onclick="loginFunch()">--%>

<%--</form>--%>

<script>

    function registerFunck() {
        var username = document.getElementById("userNameStruts").value;
        var password = document.getElementById("passwordStruts").value;
        // var method = document.getElementById("methodStruts").value;
        document.getElementById("methodStruts").value="register";
        var button= document.createElement("input");
        button.name="button";
        button.value="register";
        button.type="hidden";

        var form = document.getElementById("formStruts")
        form.method = "post";
        form.appendChild(button);
    }
    //
    function loginFunch() {

        var username = document.getElementById("userNameStruts").value;
        var password = document.getElementById("passwordStruts").value;
        // var method = document.getElementById("methodStruts").value;
        document.getElementById("methodStruts").value="login";
        var button= document.createElement("input");
        button.name="button";
        button.value="login";
        button.type="hidden";

        var form = document.getElementById("formStruts")
        form.method = "post";
        form.appendChild(button);







        // var username = document.getElementById("username").value;
        // var password = document.getElementById("password").value;
        // var button= document.createElement("input");
        // document.getElementById("methodStruts").value="login";
        // // button.name="button";
        // // button.value="login";
        // // button.type="hidden";
        // var form = document.getElementById("formStruts");
        //
        // // form.action = "wellcome";
        // form.method = "post";
        // form.appendChild(button);
    }


    // window.onload = function () {
    //     // var testt=document.getElementById("nikeName").value;
    //     document.getElementById("username").value=document.getElementById("nickName").value;
    //     document.getElementById("password").value=document.getElementById("passwordStruts").value;
    //     // reza="hello";
    //     // alert(testt);



<%--        <% String username = request.getParameter("username"); %>--%>
<%--        <% String password = request.getParameter("password"); %>--%>

        <%--var username = "<%= username %>";--%>
        <%--var password = "<%= password %>";--%>

        // if (username !== "null") {
        //     document.getElementById("username").value = username;
        //     document.getElementById("password").value = password;
        // }
    // }

</script>
</body>
</html>