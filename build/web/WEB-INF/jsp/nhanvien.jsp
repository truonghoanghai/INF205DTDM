<%-- 
    Document   : nhanvien
    Created on : Apr 10, 2018, 12:58:30 PM
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
        <form:form action="nhanvien.htm" modelAttribute="Staff">

            <div class="inbox-head">
                <h3>Phong Ban</h3>
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
                            <th class="col-sm-2 view-message  dont-show">Mã Nhân Viên</th>
                            <th class="view-message col-sm-3">Tên Nhân viên</th>
                            <th class="view-message col-sm-3">Giới Tính</th>
                            <th class="view-message col-sm-3">Ngày Sinh</th>
                            <th class="view-message col-sm-3">Hình</th>
                            <th class="view-message col-sm-3">Email</th>
                            <th class="view-message col-sm-3">Số Điện Thoại</th>
                            <th class="view-message col-sm-3">Ghi Chú</th>
                            <th class="view-message col-sm-3">Cấp Độ</th>
                            <th class="view-message col-sm-3">Mã Phòng Ban</th>
                        </tr>
                    </thead>
                    
                    <c:forEach var="rows" items="${listNhanVien}">
                        <form class="col-sm-2" action="#">                        
                            <td class="view-message col-sm-3">${rows.manv}</td>
                            <td class="view-message col-sm-3">${rows.tennv}</td>
                            <td class="view-message col-sm-3">${rows.gioitinh}</td>
                            <td class="view-message col-sm-3">${rows.ngaysinh}</td>
                            <td class="view-message col-sm-3">${rows.hinh}</td>
                            <td class="view-message col-sm-3">${rows.email}</td>
                            <td class="view-message col-sm-3">${rows.sdt}</td>
                            <td class="view-message col-sm-3">${rows.ghichu}</td>
                            <td class="view-message col-sm-3">${rows.capdo}</td>
                            <td class="view-message col-sm-3">${rows.mapbid}</td>
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
    </body>
</html>
