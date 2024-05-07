<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="EUC-KR" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Test</title>
</head>
<body>
<%-- JSP EL --%>
${name}
${user.age}

<%-- SpEL --%>
<spring:eval expression="user.name"/>
<spring:eval expression="user.toString()"/>
<spring:eval expression="new java.text.DeciamlFormat('###,##0.00').format(user.point)"/>
<spring:message code="greeting" />
<spring:message code="greeting" arguments="${user.name}" text="Hi"/>
<form>
    <spring:bind path="user.name">
        <p>
            <label for="name" <c:if test="${status.errorMessage != ''}">class="errorMessage"</c:if>>Name : </label>
<%--            <input type="text" id="name" name="name" value="${user.name}"/>--%>
            <input type="text" id="${status.expression}" name="${status.expression}" value="${status.value}"/>
            <span class="errorMessage">
                <c:forEach var="errorMessage" items="${status.errorMessages}">
                    ${errorMessage}
                </c:forEach>
            </span>
        </p>
    </spring:bind>
</form>

<%-- form 태그 라이브러리 --%>
<form:form modelAttribute="user">
    <form:label path="name" cssErrorClass="errorMessage">Name</form:label> :
    <form:input path="name" size="30"/>
    <form:errors path="name" cssClass="errorMessage"/>
    <form:hidden path="loginCount"/>
    <form:textarea path="info"/>
    <form:password path="pwd"/>
    <form:checkbox path="registered" label="Registered"/>
    <form:checkboxes path="interests" items="${interests}"/>
    <form:radiobutton path="type" label="관리자" value="1"/>
    <form:radiobutton path="type" label="회원" value="2"/>
    <form:radiobutton path="type" label="손님" value="3"/>
    <form:radiobuttons path="type" items="${types}" itemValue="id" itemLabel="name"/>
    <form:label path="kind">Kind : </form:label>
    <form:select path="kind">
        <form:option value="1">관리자</form:option>
        <form:option value="2">회원</form:option>
        <form:option value="3">손님</form:option>
        <form:options items="${kinds}" itemLabel="name" itemValue="id"/>
    </form:select>
</form:form>
</body>
</html>