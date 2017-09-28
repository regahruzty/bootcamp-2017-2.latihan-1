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
@WebServlet(urlPatterns = {"/dokter/new"})
public class DokterAddController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        req.getRequestDispatcher("/pages/dokter/addDokter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Dokter dokterBaru = new Dokter();
        dokterBaru.setNama(req.getParameter("dokterNama"));
        dokterBaru.setSpesialis(req.getParameter("dokterSpesialis"));

        DokterDao dokterDao = new DokterDao();
        dokterDao.save(dokterBaru);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/dokter/list");

        System.out.println("nilai yang diambil dari form: " + dokterBaru.getNama() + " ,spesialis: " + dokterBaru.getSpesialis());

    }

}
