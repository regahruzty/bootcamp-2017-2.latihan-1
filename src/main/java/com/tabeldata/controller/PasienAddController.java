/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.PasienDao;
import com.tabeldata.Pasien;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/pasien/new"})
public class PasienAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        req.getRequestDispatcher("/pages/pasien/addPasien.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Pasien pasienBaru = new Pasien();
        pasienBaru.setNama(req.getParameter("pasienNama"));
        pasienBaru.setAlamat(req.getParameter("pasienAlamat"));
        pasienBaru.setTanggalLahir(java.sql.Date.valueOf(req.getParameter("pasienTanggalLahir")));

        PasienDao pasienDao = new PasienDao();
        pasienDao.save(pasienBaru);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/pasien/list");

        System.out.println("nilai yang diambil dari form: " + pasienBaru.getNama() + " ,alamat: " + pasienBaru.getAlamat() + " ,tanggal lahir: " + pasienBaru.getTanggalLahir());

    }

}
