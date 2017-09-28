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
import com.tabeldata.Pasien;
import java.sql.Connection;
import java.sql.Date;
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
public class PasienDao {

    public List<Pasien> semuaDataPasien() {
        List<Pasien> listPasien = new ArrayList<>();
        try {
            Connection koneksiDB = KonfigDB.getDataSource().getConnection();
            String sql = "select id, nama, alamat, tanggal_lahir from latihan_1.pasien order by id";
            Statement s = koneksiDB.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Pasien pasien = new Pasien();
                pasien.setId(r.getInt("id"));
                pasien.setNama(r.getString("nama"));
                pasien.setAlamat(r.getString("alamat"));
                pasien.setTanggalLahir(r.getDate("tanggal_lahir"));
                listPasien.add(pasien);
            }

            r.close();
            s.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listPasien;

    }

    public void save(Pasien objPasien) {
        try {
            Connection koneksiDB = KonfigDB.getDataSource().getConnection();
            String sql = "insert into latihan_1.pasien(id, nama, alamat, tanggal_lahir) values (nextval('latihan_1.pasien_id_seq') ,?, ?, ?)";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objPasien.getNama());
            ps.setString(2, objPasien.getAlamat());                   
            ps.setDate(3, objPasien.getTanggalLahir());
            ps.executeUpdate(); 

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Pasien cariPasienDenganId(Integer id) {

        try {
            Connection koneksi = KonfigDB.getDataSource().getConnection();
            String sql = "select * from latihan_1.pasien where id = ?";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Pasien pasien = new Pasien();
            if (rs.next()) {
                pasien.setId(rs.getInt("id"));
                pasien.setNama(rs.getString("nama"));
                pasien.setAlamat(rs.getString("alamat"));
                pasien.setTanggalLahir(rs.getDate("tanggal_lahir"));
            }
            return pasien;
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void update(Pasien objPasien) {
        try {
            Connection koneksiDB = KonfigDB.getDataSource().getConnection();
            String sql = "update latihan_1.pasien set nama = ?, alamat = ?, tanggal_lahir = ? where id = ?";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setString(1, objPasien.getNama());
            ps.setString(2, objPasien.getAlamat());
            ps.setDate(3, objPasien.getTanggalLahir());
            ps.setInt(4, objPasien.getId());
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hapusPasienById(Integer id) {
        String sql = "delete from latihan_1.pasien where id = ?";

        try {
            Connection conection = KonfigDB.getDataSource().getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            ps.close();
            conection.close();

        } catch (SQLException ex) {
            Logger.getLogger(PasienDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
