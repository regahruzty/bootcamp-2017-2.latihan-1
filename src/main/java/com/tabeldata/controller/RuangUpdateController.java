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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diani
 */
@WebServlet(urlPatterns = {"/ruang/update"})
public class RuangUpdateController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        Ruang ruang = new Ruang();
        ruang.setId(Integer.valueOf(req.getParameter("id")));

        RuangDao ruangDao = new RuangDao();
        ruang = ruangDao.cariRuangDenganId(ruang.getId());

        req.setAttribute("r", ruang);
        req.getRequestDispatcher("/pages/ruang/updateRuang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.

        Ruang ruangBaru = new Ruang();
        ruangBaru.setId(Integer.valueOf(req.getParameter("ruangId")));
        ruangBaru.setNo_ruangan(req.getParameter("ruangNo_ruangan"));
        ruangBaru.setKosong(Boolean.valueOf(req.getParameter("ruangKosong")));

        RuangDao ruangDao = new RuangDao();
        ruangDao.update(ruangBaru);

        resp.sendRedirect(req.getServletContext().getContextPath() + "/ruang/list");
    }
}