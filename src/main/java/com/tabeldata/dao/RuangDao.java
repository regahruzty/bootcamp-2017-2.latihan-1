/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

/**
 *
 * @author Diani
 */
import com.tabeldata.configs.KonfigDB;
import com.tabeldata.Ruang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diani
 */
public class RuangDao {

    public List<Ruang> semuaDataRuang(Boolean statusKamarIsi) {
        List<Ruang> listRuang = new ArrayList<>();
        try {
            Connection koneksiDB = KonfigDB.getDataSource().getConnection();
            String sql = "select id, no_ruangan, kosong from latihan_1.ruang where kosong = ?";
            PreparedStatement s = koneksiDB.prepareStatement(sql);
            s.setBoolean(1, statusKamarIsi);
            ResultSet r = s.executeQuery();
            while (r.next()) {
                Ruang ruang = new Ruang();
                ruang.setId(r.getInt("id"));
                ruang.setNo_ruangan(r.getString("no_ruangan"));
                ruang.setKosong(r.getBoolean("kosong"));
                listRuang.add(ruang);
            }

            r.close();
            s.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listRuang;

    }

    public void save(Ruang objRuang) {
        try {
            Connection koneksiDB = KonfigDB.getDataSource().getConnection();
            String sql = "insert into latihan_1.ruang(id, no_ruangan, kosong) values (nextval('latihan_1.dokter_id_seq'), ?, ?)";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objRuang.getNo_ruangan());
            ps.setBoolean(2, objRuang.getKosong());
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Ruang cariRuangDenganId(Integer id) {

        try {
            Connection koneksi = KonfigDB.getDataSource().getConnection();
            String sql = "select * from latihan_1.ruang where id = ?";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Ruang ruang = new Ruang();
            if (rs.next()) {
                ruang.setId(rs.getInt("id"));
                ruang.setNo_ruangan(rs.getString("no_ruangan"));
                ruang.setKosong(rs.getBoolean("kosong"));
            }
            return ruang;
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void update(Ruang objRuang) {
        try {
            Connection koneksiDB = KonfigDB.getDataSource().getConnection();
            String sql = "update latihan_1.ruang set no_ruangan = ?, kosong = ? where id = ?";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objRuang.getNo_ruangan());
            ps.setBoolean(2, objRuang.getKosong());
            ps.setInt(3, objRuang.getId());
            
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hapusRuangById(Integer id) {
        String sql = "delete from latihan_1.ruang where id = ?";

        try {
            Connection conection = KonfigDB.getDataSource().getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            conection.close();

        } catch (SQLException ex) {
            Logger.getLogger(RuangDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

