<%-- 
    Document   : user
    Created on : Apr 6, 2018, 6:10:20 PM
    Author     : hoanghai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <base href="${pageContext.servletContext.contextPath}/">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <script>
            //<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#product_view"><i class="fa fa-search"></i> Quick View</button>
            function myFunction(x) {
                $("#item_view").modal();
            }
            ;
        </script>

    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/header.jsp"/>
        <jsp:include page="/WEB-INF/jsp/aside.jsp"/>
        <jsp:include page="/WEB-INF/jsp/nav.jsp"/>
        <form:form action="user.htm" modelAttribute="User">
            <div>Username</div>
            <form:input path="username"/>
            <div>Password</div>
            <form:input path="password"/>
            <div>Fullname</div>
            <form:input path="fullname"/>
            <div>
                <button name="btnInsert">Thêm</button>
                <button name="btnUpdate">Cập nhật</button> 
                <br>
                <input name="txtSearch" value="" />
                <button name="btnSearch">Tìm Kiếm </button>
            </div>

            <div class="inbox-head">
                <h3>User</h3>
                <form action="#" class="pull-right position">
                    <div class="input-append">
                        <input type="text" class="sr-input" placeholder="Tìm kiếm">
                        <button class="btn sr-btn" type="button"><i class="fa fa-search"></i></button>
                    </div>
                </form>
            </div>
            <button class="btn btn-default pull-right" style="margin-top:20px;" data-toggle="modal" data-target= "#item_add"><i class="glyphicon glyphicon-plus"></i> Thêm nhân viên</button>
        </form:form>
        <br>            
        <div class="inbox-body">
            <div class="mail-option">
                <table class="table table-inbox table-hover">				
                    <thead>
                        <tr class="unread">
                            <th class="col-sm-2 view-message  dont-show">Username</th>
                            <th class="view-message col-sm-3">Password</th>
                            <th class="view-message col-sm-3">Họ Và Tên</th>
                            <th class="view-message col-sm-3">#</th>
                            <th class="view-message col-sm-3">#</th>
                        </tr>
                    </thead>
                    <c:forEach var="rows" items="${listUser}">
                        <form action="user/delete.htm">
                            <tr>
                                <td class="view-message col-sm-3">${rows.username}</td>
                                <td class="view-message col-sm-3">${rows.password}</td>
                                <td class="view-message col-sm-3">${rows.fullname}</td>
                                <c:url var="edit" value="user/edit.htm">
                                    <c:param name="txtUsername" value="${rows.username}"/>
                                    <c:param name="txtPassword" value="${rows.password}"/>
                                    <c:param name="txtFullname" value="${rows.fullname}"/>
                                </c:url>
                                <td class="view-message col-sm-3"><a href="${edit}">Edit</a></td>
                                <td class="view-message col-sm-3">
                                    <input type="hidden" name="txtUsername" value="${rows.username}"/>
                                    <input type="submit" name="action" value="Delete"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>   
                </table>
            </div>
        </div>
        <div class="text-center">
            <ul class="pagination">
                <li class="disabled"><span>«</span></li>
                <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li class="disabled"><span>...</span></li>
                <li><a href="#">5</a></li>
                <li><a href="#" rel="next">»</a></li>
            </ul>
        </div>
    </body>
</html>
