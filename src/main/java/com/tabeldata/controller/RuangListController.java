/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.controller;

/**
 *
 * @author Diani
 */
import com.tabeldata.dao.RuangDao;
import com.tabeldata.Ruang;
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

@WebServlet(urlPatterns = {"/ruang/list"})
public class RuangListController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RuangDao ruangDao = new RuangDao();
        List<Ruang> dataRuang = ruangDao.semuaDataRuang(Boolean.TRUE);
        
        req.setAttribute("listRuang", dataRuang); 
        req.getRequestDispatcher("/pages/ruang/index.jsp").forward(req, resp);
    }
    
    
}
