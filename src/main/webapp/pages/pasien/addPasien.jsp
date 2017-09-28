<%-- 
    Document   : addPasien
    Created on : Sep 28, 2017, 1:02:03 AM
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
        <form action="${pageContext.servletContext.contextPath}/pasien/new" method="post">
            <div>
                <label for="pasienNama">Nama Pasien</label>
                <input type="text" name="pasienNama" id="pasienNama"
            </div>
            <div>
                <label for="pasienAlamat">Alamat</label>
                <input type="text" name="pasienAlamat" id="pasienAlamat"
            </div>
            <div>
                <label for="pasienTanggalLahir">Tanggal Lahir</label>
                <input type="date" name="pasienTanggalLahir" id="pasienTanggalLahir"
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
