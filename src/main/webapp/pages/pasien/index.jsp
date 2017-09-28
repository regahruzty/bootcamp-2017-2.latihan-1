<%-- 
    Document   : index
    Created on : Sep 28, 2017, 12:59:09 AM
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
        <h1>Daftar Pasien</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>Alamat</th>
                    <th>Tanggal Lahir</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listPasien}" var="p" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${p.id}</td>
                        <td>${p.nama}</td>
                        <td>${p.alamat}</td>
                        <td>${p.tanggalLahir}</td>
                        <td>
                            <a href="${pageContext.servletContext.contextPath}/pasien/update?id=${p.id}">Update</a>
                            &nbsp;
                            <form action="${pageContext.servletContext.contextPath}/pasien/delete" method="post">
                                <input type="hidden" name="pasienId" value="${p.id}">
                                <button type="submit">Hapus</button>
                                </input>

                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
