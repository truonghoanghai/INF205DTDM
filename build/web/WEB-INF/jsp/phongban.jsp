<%-- 
    Document   : phongban
    Created on : Apr 5, 2018, 5:21:58 PM
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
        <form:form action="phongban.htm" modelAttribute="Departs">
            <div class="inbox-head">
                <h3>Phong Ban</h3>
                <form action="#" class="pull-right position">
                    <div class="input-append">
                        <input type="text" name="txtSearch" value="" class="sr-input" placeholder="Tìm kiếm">
                        <button class="btn sr-btn" type="button"><i class="fa fa-search" name="btnSearch"></i></button>
                    </div>
                </form>
            </div>
            <button class="btn btn-default pull-right" style="margin-top:20px;" data-toggle="modal" data-target= "#item_add">
                <i class="glyphicon glyphicon-plus"></i><a href="addphongban.htm">Thêm Nhân Viên</a></button>

        </form:form>
        <br>            
        <div class="inbox-body">
            <div class="mail-option">
                <table class="table table-inbox table-hover">				
                    <thead>
                        <tr class="unread">
                            <th class="col-sm-2 view-message  dont-show">Mã Phòng Ban</th>
                            <th class="view-message col-sm-3">Tên Phòng Ban</th>
                            <th class="view-message col-sm-3">#</th>
                            <th class="view-message col-sm-3">#</th>
                        </tr>
                    </thead>
                    <c:forEach var="rows" items="${listPhongBan}">
                        <form class="col-sm-2" action="phongban/delete.htm">                        
                                <td class="view-message col-sm-3">${rows.mapb}</td>
                                <td class="view-message col-sm-3">${rows.tenpb}</td>

                                <c:url var="edit" value="phongban/edit.htm">
                                    <c:param name="txtMaPB" value="${rows.mapb}"/>
                                    <c:param name="txtTenPB" value="${rows.tenpb}"/>
                                </c:url>
                                <td class="view-message col-sm-3"><a href="${edit}">Edit</a></td>
                                <td class="view-message col-sm-3">
                                    <input type="hidden" name="txtMaPB" value="${rows.mapb}"/>
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
