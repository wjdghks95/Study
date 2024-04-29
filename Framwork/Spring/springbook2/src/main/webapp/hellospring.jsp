<%--
  Created by IntelliJ IDEA.
  User: wjdgh
  Date: 2024-04-25
  Time: 오후 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="EUC-KR" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.example.springbook2.temp.HelloSpring" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Test</title>
</head>
<body>

<%
    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
    HelloSpring helloSpring = context.getBean(HelloSpring.class);

    out.println(helloSpring.sayHello("Root Context"));
%>

</body>
</html>
