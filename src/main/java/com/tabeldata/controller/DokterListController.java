/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.DokterDao;
import com.tabeldata.Dokter;
import java.io.IOException;
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

@WebServlet(urlPatterns = {"/dokter/list"})
public class DokterListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DokterDao dokterDao = new DokterDao();
        List<Dokter> dataDokter = dokterDao.semuaDataDokter();
        
        req.setAttribute("listDokter", dataDokter); 
        req.getRequestDispatcher("/pages/dokter/index.jsp").forward(req, resp);
    }
    
    
}
