/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

import com.tabeldata.dao.RawatDao;
import com.tabeldata.Rawat;
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
@WebServlet(urlPatterns = {"/rawat/list"})
public class RawatListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.

        RawatDao rawatDao = new RawatDao();
        List<Rawat> listRawat = rawatDao.semuaDataRawat();
        req.setAttribute("listRawat", listRawat);
        req.getRequestDispatcher("/pages/rawat/index.jsp").forward(req, resp);

    }

}
