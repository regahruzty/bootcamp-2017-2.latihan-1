/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.DokterDao;
import com.tabeldata.Dokter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/dokter/update"})
public class DokterUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Dokter dokter = new Dokter();
        dokter.setId(Integer.valueOf(req.getParameter("id")));

        DokterDao dokterDao = new DokterDao();
        dokter = dokterDao.cariDokterDenganId(dokter.getId());

        req.setAttribute("d", dokter);
        req.getRequestDispatcher("/pages/dokter/updateDokter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Dokter dokterBaru = new Dokter();
        dokterBaru.setId(Integer.valueOf(req.getParameter("dokterId")));
        dokterBaru.setNama(req.getParameter("dokterNama"));
        dokterBaru.setSpesialis(req.getParameter("dokterSpesialis"));

        DokterDao dokterDao = new DokterDao();
        dokterDao.update(dokterBaru);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/dokter/list");
    }
}
