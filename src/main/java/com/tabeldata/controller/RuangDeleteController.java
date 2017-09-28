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
@WebServlet(urlPatterns = {"/ruang/delete"})
public class RuangDeleteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        Integer idRuang = Integer.valueOf((req.getParameter("ruangId")));
        RuangDao ruangDao = new RuangDao();
        ruangDao.hapusRuangById(idRuang);
        resp.sendRedirect(req.getServletContext().getContextPath() + "/ruang/list");
        
    }

}

