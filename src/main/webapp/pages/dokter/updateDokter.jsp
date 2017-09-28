<%-- 
    Document   : updateDokter
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
        <h1>Form Dokter</h1>
        <!--${pageContext.servletContext.contextPath}-->
        <form action="${pageContext.servletContext.contextPath}/dokter/update" method="post">
            
            <input type="hidden" name="dokterId" value="${d.id}">
            <div>
                <label for="dokterNama">Nama Dokter</label>
                <input type="text" name="dokterNama" value="${d.nama}"
            </div>
            <div>
                <label for="dokterSpesialis">Spesialis</label>
                <input type="text" name="dokterSpesialis" value="${d.spesialis}"
            </div>
            <div>
                <button type="submit">Kirim</button>
                <button type="reset">Reset</button>
            </div>
        </form>
    </body>
</html>
