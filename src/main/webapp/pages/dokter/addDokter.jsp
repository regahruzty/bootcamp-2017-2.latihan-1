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
        <h1>Form Dokter</h1>
        <!--${pageContext.servletContext.contextPath}-->
        <form action="${pageContext.servletContext.contextPath}/dokter/new" method="post">
            <div>
                <label for="dokterNama">Nama Dokter</label>
                <input type="text" name="dokterNama" id="dokterNama"
            </div>
            <div>
                <label for="dokterSpesialis">Spesialis</label>
                <input type="text" name="dokterSpesialis" id="dokterSpesialis"
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
