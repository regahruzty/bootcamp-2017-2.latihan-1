<%-- 
    Document   : addRawat
    Created on : Sep 28, 2017, 8:38:03 AM
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
        <h1>Tambah data Rawat</h1>
        <!--${pageContext.servletContext.contextPath}-->
        <form action="${pageContext.servletContext.contextPath}/rawat/new" method="post">
            <div>
                <label for="rawatPasien">Pilih Pasien</label>
                <select name="rawatPasien" id="rawatPasien">
                    <c:forEach items="${listPasien}" var="p">
                    <option value="${p.id}">${p.nama}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="rawatDokter">Pilih Dokter</label>
                <select name="rawatDokter" id="rawatDokter">
                    <c:forEach items="${listDokter}" var="d">
                        <option value="${d.id}">${d.nama}</option>
                    </c:forEach>
                </select>
            </div>
                <label for="rawatRuang">Pilih Ruang</label>
                <select name="rawatRuang" id="rawatRuang">
                    <c:forEach items="${listRuang}" var="r">
                        <option value="${r.id}">${r.no_ruangan}</option>
                    </c:forEach>
                </select>
            </div>
            <div>
                <label for="rawatRegister">Waktu Register</label>
                <input type="timestamp" name="rawatRegister" id="rawatRegister">
            </div>
            <div>
                <label for="rawatCheckout">Waktu Checkout</label>
                <input type="timestamp" name="rawatCheckout" id="rawatCheckout">
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
