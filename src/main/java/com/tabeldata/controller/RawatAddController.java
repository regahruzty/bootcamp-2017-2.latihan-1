/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.RuangDao;
import com.tabeldata.Pasien;
import com.tabeldata.Dokter;
import com.tabeldata.Rawat;
import com.tabeldata.Ruang;
import com.tabeldata.dao.RawatDao;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/rawat/new"})
public class RawatAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        PasienDao pasienDao = new PasienDao();
        List<Pasien> listPasien = pasienDao.semuaDataPasien();

        DokterDao dokterDao = new DokterDao();
        List<Dokter> listDokter = dokterDao.semuaDataDokter();

        RuangDao ruangDao = new RuangDao();
        List<Ruang> listRuang = ruangDao.semuaDataRuang();

        req.setAttribute("listPasien", listPasien);
        req.setAttribute("listDokter", listDokter);
        req.setAttribute("listRuang", listRuang);

        req.getRequestDispatcher("/pages/rawat/addRawat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Rawat rwt = new Rawat();
        Pasien pasien = new Pasien();
        Dokter dokter = new Dokter();
        Ruang ruang = new Ruang();

        rwt.setWaktuRegister(Timestamp.valueOf(req.getParameter("rawatRegister")));
        rwt.setWaktuCheckout(Timestamp.valueOf(req.getParameter("rawatCheckout")));
        
        pasien.setId(Integer.valueOf(req.getParameter("rawatPasien")));
        dokter.setId(Integer.valueOf(req.getParameter("rawatDokter")));
        ruang.setId(Integer.valueOf(req.getParameter("rawatRuang")));

        rwt.setPasienId(pasien);
        rwt.setDokterId(dokter);
        rwt.setRuangId(ruang);
        
        System.out.println("Data rawat { pasien.id " + rwt.getPasienId().getId() + ", dokter.id : "
                + rwt.getDokterId().getId() + ", ruang.id: "
                + rwt.getRuangId().getId()+ ", waktu register:" + rwt.getWaktuRegister() + ", waktu checkout: " + rwt.getWaktuCheckout());

        RawatDao rawatDao = new RawatDao();
        rawatDao.simpanRawat(rwt);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/rawat/list");
    }

}
