<%-- 
    Document   : index
    Created on : Sep 28, 2017, 9:37:38 AM
    Author     : Diani
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Daftar Rawat</h1>
        <a href="${pageContext.servletContext.contextPath}/rawat/new" class="btn btn-primary">Tambah</a>
        &nbsp;
        <table border="1">
            <thead>
                <tr>
                    <th>Kode</th>
                    <th>Pasien</th>
                    <th>Dokter</th>
                    <th>Ruang</th>
                    <th>Waktu Register</th>
                    <th>Waktu Checkout</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${listRawat}" var="rwt">
                <tr>
                    <td>${rwt.id}</td>
                    <td>${rwt.pasienId.nama}</td>
                    <td>${rwt.dokterId.nama}</td>
                    <td>${rwt.ruangId.kosong}</td>
                    <td>${rwt.waktuRegister}</td>
                    <td>${rwt.waktuCheckout}</td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/rawat/update?id=${rwt.id}">Update</a>
                    </td>    
                    &nbsp;
                    <td>
                     <form action="${pageContext.servletContext.contextPath}/rawat/delete?id=${rwt.id}" method="post">
                     <input type="hidden" name="rawatId" value="${rwt.id}">    
                         <button type="submit">Hapus</button>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
