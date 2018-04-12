<%-- 
    Document   : addphongban
    Created on : Apr 11, 2018, 8:42:47 PM
    Author     : hoanghai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/header.jsp"/>
        <jsp:include page="/WEB-INF/jsp/aside.jsp"/>
        <jsp:include page="/WEB-INF/jsp/nav.jsp"/>
        <form:form action="PhongBanController" modelAttribute="Departs">
            <div>Mã PB</div>
            <form:input type="text" path="mapb"/>
            <div>Tên Phòng Ban</div>
            <form:input type="text" path="tenpb"/>
            <div>
                <button name="btnInsert">Thêm</button>
                <button name="btnUpdate">Cập nhật</button>
            </div>
        </form:form>
    </body>
</html>
