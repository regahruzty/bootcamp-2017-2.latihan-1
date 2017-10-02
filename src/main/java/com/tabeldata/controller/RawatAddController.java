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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/rawat/new", "/rawat/newproses"})
public class RawatAddController extends HttpServlet {
    
    private final Logger console = LoggerFactory.getLogger(RawatAddController.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        PasienDao pasienDao = new PasienDao();
        DokterDao dokterDao = new DokterDao();
        RuangDao ruangDao = new RuangDao();

        List<Pasien> listPasien = pasienDao.semuaDataPasien();
        List<Dokter> listDokter = dokterDao.semuaDataDokter();
        List<Ruang> listRuang = ruangDao.semuaDataRuang(Boolean.TRUE);

        req.setAttribute("listPasien", listPasien);
        req.setAttribute("listDokter", listDokter);
        req.setAttribute("listRuang", listRuang);

        req.getRequestDispatcher("/pages/rawat/addRawat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Rawat rawatBaru = new Rawat();
        Pasien pasien = new Pasien();
        Dokter dokter = new Dokter();
        Ruang ruang = new Ruang();

        rawatBaru.setWaktuRegister(Timestamp.valueOf(LocalDateTime.now()));
        rawatBaru.setWaktuCheckout(Timestamp.valueOf(LocalDateTime.now()));

        pasien.setId(Integer.valueOf(req.getParameter("rawatPasien")));
        dokter.setId(Integer.valueOf(req.getParameter("rawatDokter")));
        ruang.setId(Integer.valueOf(req.getParameter("rawatRuang")));

        rawatBaru.setPasienId(pasien);
        rawatBaru.setDokterId(dokter);
        rawatBaru.setRuangId(ruang);

//        System.out.println("Data rawat { pasien.id " + rawatBaru.getPasienId().getId() + ", dokter.id : "
//                + rawatBaru.getDokterId().getId() + ", ruang.id: "
//                + rawatBaru.getRuangId().getId() + ", waktu register:" + rawatBaru.getWaktuRegister() + ", waktu checkout: " + rawatBaru.getWaktuCheckout());

        RawatDao rawatDao = new RawatDao();
        try {
            rawatDao.simpanRawat(rawatBaru);
        console.info("pasienId: {}, dokterId: {}, ruangId: {}, waktuRegister: {}",
                rawatBaru.getPasienId().getId(),
                rawatBaru.getDokterId().getId(),
                rawatBaru.getRuangId().getId(),
                rawatBaru.getWaktuRegister());
        resp.sendRedirect(req.getServletContext().getContextPath() + "/rawat/list");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(RawatAddController.class.getName()).log(Level.SEVERE, null, ex);
        console.error("tidak dapat menyimpan data Rawat", ex);
        }

    }

}
