/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.Dokter;
import com.tabeldata.Pasien;
import com.tabeldata.Rawat;
import com.tabeldata.Ruang;
import com.tabeldata.dao.DokterDao;
import com.tabeldata.dao.PasienDao;
import com.tabeldata.dao.RawatDao;
import com.tabeldata.dao.RuangDao;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
@WebServlet(urlPatterns = {"/rawat/update"})
public class RawatUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        String kodeRawat = req.getParameter("id");
        Rawat rawat = new Rawat();
        PasienDao pasienDao = new PasienDao();
        DokterDao dokterDao = new DokterDao();
        RuangDao ruangDao = new RuangDao();
        RawatDao rawatDao = new RawatDao();

        List<Pasien> listPasien = pasienDao.semuaDataPasien();
        List<Dokter> listDokter = dokterDao.semuaDataDokter();
        List<Ruang> listRuang = ruangDao.semuaDataRuang(false);
        rawat = rawatDao.cariRawatDenganId(Integer.valueOf(kodeRawat));

        req.setAttribute("listPasien", listPasien);
        req.setAttribute("listDokter", listDokter);
        req.setAttribute("listRuang", listRuang);
        req.setAttribute("rwt", rawat);
        req.getRequestDispatcher("/pages/rawat/updateRawat.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Rawat rawatBaru = new Rawat();
        String rawatId = req.getParameter("id");
        rawatBaru.setId(Integer.valueOf(rawatId));

        String rawatPasien = req.getParameter("rawatPasien");
        Pasien pasien = new Pasien();
        pasien.setId(Integer.valueOf(rawatPasien));
        rawatBaru.setPasienId(pasien);

        String rawatDokter = req.getParameter("rawatDokter");
        Dokter dokter = new Dokter();
        dokter.setId(Integer.valueOf(rawatDokter));
        rawatBaru.setDokterId(dokter);

        String rawatRuang = req.getParameter("rawatRuang");
        Ruang ruang = new Ruang();
        ruang.setId(Integer.valueOf(rawatRuang));
        rawatBaru.setRuangId(ruang);

        rawatBaru.setWaktuRegister(Timestamp.valueOf(LocalDateTime.now()));
        rawatBaru.setWaktuCheckout(Timestamp.valueOf(LocalDateTime.now()));

        RawatDao rawatDao = new RawatDao();
        rawatDao.update(rawatBaru.getId(), rawatBaru.getPasienId().getId(), rawatBaru.getDokterId().getId(), rawatBaru.getRuangId().getId(), rawatBaru.getWaktuRegister(), rawatBaru.getWaktuCheckout());

        resp.sendRedirect(req.getServletContext().getContextPath() + "/rawat/list");
    }
}
