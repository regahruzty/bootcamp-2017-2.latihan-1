/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.PasienDao;
import com.tabeldata.Pasien;
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

@WebServlet(urlPatterns = {"/pasien/list"})
public class PasienListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PasienDao pasienDao = new PasienDao();
        List<Pasien> dataPasien = pasienDao.semuaDataPasien();
        
        req.setAttribute("listPasien", dataPasien); 
        req.getRequestDispatcher("/pages/pasien/index.jsp").forward(req, resp);
    }
    
    
}
