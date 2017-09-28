/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.PasienDao;
import com.tabeldata.Pasien;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/pasien/update"})
public class PasienUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Pasien pasien = new Pasien();
        pasien.setId(Integer.valueOf(req.getParameter("id")));

        PasienDao pasienDao = new PasienDao();
        pasien = pasienDao.cariPasienDenganId(pasien.getId());

        req.setAttribute("p", pasien);
        req.getRequestDispatcher("/pages/pasien/updatePasien.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Pasien pasienBaru = new Pasien();
        pasienBaru.setId(Integer.valueOf(req.getParameter("pasienId")));
        pasienBaru.setNama(req.getParameter("pasienNama"));
        pasienBaru.setAlamat(req.getParameter("pasienAlamat"));
        pasienBaru.setTanggalLahir(java.sql.Date.valueOf(req.getParameter("pasienTanggalLahir")));

        PasienDao pasienDao = new PasienDao();
        pasienDao.update(pasienBaru);
        
        resp.sendRedirect(req.getServletContext().getContextPath() + "/pasien/list");
    }
}
