/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.Rawat;
import com.tabeldata.Ruang;
import com.tabeldata.dao.RawatDao;
import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/rawat/update"})
public class RawatUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Rawat rawat = new Rawat();
        rawat.setId(Integer.valueOf(req.getParameter("id")));

        RawatDao rawatDao = new RawatDao();
        rawat = rawatDao.cariRawatDenganId(rawat.getId());

        req.setAttribute("rwt", rawat);
        req.getRequestDispatcher("/pages/rawat/updateRawat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Rawat rawatBaru = new Rawat();
        rawatBaru.setId(Integer.valueOf(req.getParameter("rawatId"))); 
        rawatBaru.setWaktuRegister(Timestamp.valueOf(req.getParameter("rawatRegister")));
        rawatBaru.setWaktuCheckout(Timestamp.valueOf(req.getParameter("rawatCheckout")));
        
        Ruang ruang = new Ruang();
        ruang.setId(Integer.valueOf(req.getParameter("ruangId")));
        ruang.setNo_ruangan(req.getParameter("ruangNo_ruangan"));
        ruang.setKosong(Boolean.valueOf(req.getParameter("ruangKosong")));
        rawatBaru.setRuangId(ruang);
       
        
        RawatDao rawatDao = new RawatDao();
        rawatDao.update(rawatBaru);
        
        resp.sendRedirect(req.getServletContext().getContextPath() + "/ruang/list");
    }
}
