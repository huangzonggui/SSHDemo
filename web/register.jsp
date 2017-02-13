<%--
  Created by IntelliJ IDEA.
  User: hzg
  Date: 2017/2/11
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<s:form action="doRegister">
    <table>
        <tr>
            <s:textfield name="account" label="账号"/>
        </tr>
        <tr>
            <s:textfield name="loginName" label="用户名"/>
        </tr>
        <tr>
            <s:textfield name="loginPwd" label="密码"/>
        </tr>
        <tr>
            <s:submit value="确认"/>
        </tr>
    </table>
</s:form>
</body>
</html>
