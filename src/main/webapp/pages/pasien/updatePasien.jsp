<%-- 
    Document   : updatePasien
    Created on : Sep 28, 2017, 1:04:18 AM
    Author     : Diani
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Form Pasien</h1>
        <!--${pageContext.servletContext.contextPath}-->
        <form action="${pageContext.servletContext.contextPath}/pasien/update" method="post">
            
            <input type="hidden" name="pasienId" value="${p.id}">
            <div>
                <label for="pasienNama">Nama Pasien</label>
                <input type="text" name="pasienNama" value="${p.nama}"
            </div>
            <div>
                <label for="pasienAlamat">Alamat Pasien</label>
                <input type="text" name="pasienAlamat" value="${p.alamat}"
            </div>
            <div>
                <label for="pasienTanggalLahir">Tanggal Lahir Pasien</label>
                <input type="date" name="pasienTanggalLahir" value="${p.tanggalLahir}"
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
