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
        <h1>Daftar Dokter</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>Spesialis</th>
                    <th>Aksi</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listDokter}" var="d" varStatus="index">
                    <tr>
                        <td>${index.count}</td>
                        <td>${d.id}</td>
                        <td>${d.nama}</td>
                        <td>${d.spesialis}</td>
                        <td>
                            <a href="${pageContext.servletContext.contextPath}/dokter/update?id=${d.id}">Update</a>
                            &nbsp;
                            <form action="${pageContext.servletContext.contextPath}/dokter/delete" method="post">
                                <input type="hidden" name="dokterId" value="${d.id}">
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
