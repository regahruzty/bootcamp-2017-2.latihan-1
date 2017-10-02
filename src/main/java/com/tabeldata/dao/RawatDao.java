/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.dao;

import com.tabeldata.configs.KonfigDB;
import com.tabeldata.Dokter;
import com.tabeldata.Pasien;
import com.tabeldata.Rawat;
import com.tabeldata.Ruang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diani
 */
public class RawatDao {

    public List<Rawat> semuaDataRawat() {
        List<Rawat> listRawat = new ArrayList<>();

        String sql = "Select\n" + 
                "rwt.id as id_rawat,\n" + 
                "rwt.waktu_register as waktu_register,\n" +
                "rwt.waktu_checkout as waktu_checkout,\n" + 
                "pasien.id as id_pasien,\n" + 
                "pasien.nama as nama_pasien,\n" + 
                "pasien.alamat as alamat_pasien,\n" + 
                "pasien.tanggal_lahir as tanggal_lahir_pasien,\n" + 
                "dokter.id as id_dokter,\n" + 
                "dokter.nama as nama_dokter,\n" + 
                "dokter.spesialis as spesialis_dokter,\n" + 
                "ruang.id as id_ruang,\n" + 
                "ruang.no_ruangan as no_ruangan_ruang,\n" + 
                "ruang.kosong as kosong_ruang\n" + 
                "from latihan_1.rawat rwt\n" + 
                "join latihan_1.pasien pasien on (rwt.pasien_id = pasien.id)\n" +
                "join latihan_1.dokter dokter on (rwt.dokter_id = dokter.id)\n" +
                "join latihan_1.ruang ruang on (rwt.ruang_id = ruang.id)";

        try {
            Connection connection = KonfigDB.getDataSource().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                Rawat rwt = new Rawat();
                rwt.setId(rs.getInt("id_rawat"));

                Pasien pasien = new Pasien();
                pasien.setId(rs.getInt("id_pasien"));
                pasien.setNama(rs.getString("nama_pasien"));
                pasien.setAlamat(rs.getString("alamat_pasien"));
                pasien.setTanggalLahir(rs.getDate("tanggal_lahir_pasien"));
                rwt.setPasienId(pasien);

                Dokter dokter = new Dokter();
                dokter.setId(rs.getInt("id_dokter"));
                dokter.setNama(rs.getString("nama_dokter"));
                dokter.setSpesialis(rs.getString("spesialis_dokter"));
                rwt.setDokterId(dokter);

                Ruang ruang = new Ruang();
                ruang.setId(rs.getInt("id_ruang"));
                ruang.setNo_ruangan(rs.getString("no_ruangan_ruang"));
                ruang.setKosong(rs.getBoolean("kosong_ruang"));
                rwt.setRuangId(ruang);

                rwt.setWaktuRegister(rs.getTimestamp("waktu_register"));
                rwt.setWaktuCheckout(rs.getTimestamp("waktu_checkout"));

                listRawat.add(rwt);
            }

            rs.close();
            st.close();
            connection.close();

        } catch (SQLException error) {
            error.printStackTrace();
        }
        return listRawat;

    }

    public void simpanRawat(Rawat rwt) throws SQLException {

        String sql = "insert into latihan_1.rawat (pasien_id, dokter_id, ruang_id, waktu_register, waktu_checkout)"
                + "values (?, ?, ?, ?, ?)";
        
            Connection connection = KonfigDB.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, rwt.getPasienId().getId());
            ps.setInt(2, rwt.getDokterId().getId());
            ps.setInt(3, rwt.getRuangId().getId());
            ps.setTimestamp(4, rwt.getWaktuRegister());
            ps.setTimestamp(5, rwt.getWaktuCheckout());
            ps.executeUpdate();
            
            sql = "update latihan_1.ruang set kosong = FALSE WHERE id = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, rwt.getRuangId().getId());
            ps.executeUpdate();
            ps.close();
            connection.close();

        } 

    public Rawat cariRawatDenganId(Integer id) {
        try {
            Connection koneksi = KonfigDB.getDataSource().getConnection();
            String sql = "select * from latihan_1.rawat where id = ? ";
            PreparedStatement ps = koneksi.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Rawat rawat = new Rawat();
            if (rs.next()) {
                rawat.setId(rs.getInt("id"));

                Pasien pasien = new Pasien();
                pasien.setId(rs.getInt("pasien_id"));
                rawat.setPasienId(pasien);

                Dokter dokter = new Dokter();
                dokter.setId(rs.getInt("dokter_id"));
                rawat.setDokterId(dokter);

                Ruang ruang = new Ruang();
                ruang.setId(rs.getInt("ruang_id"));
                rawat.setRuangId(ruang);

                rawat.setWaktuRegister(rs.getTimestamp("waktu_register"));
                rawat.setWaktuCheckout(rs.getTimestamp("waktu_checkout"));
            }
            return rawat;
        } catch (SQLException ex) {
            Logger.getLogger(RawatDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void update(Integer id, Integer pasienId, Integer dokterId, Integer ruangId, Timestamp waktuRegister, Timestamp waktuCheckout) {

        try {
            Connection koneksiDB = KonfigDB.getDataSource().getConnection();
            String sql = "update latihan_1.rawat set pasien_id = ?, dokter_id = ?, ruang_id = ?, waktu_register = ?, waktu_checkout = ? where id = ?";
            PreparedStatement ps = koneksiDB.prepareStatement(sql);
            ps.setInt(1, pasienId);
            ps.setInt(2, dokterId);
            ps.setInt(3, ruangId);
            ps.setTimestamp(4, waktuRegister);
            ps.setTimestamp(5, waktuCheckout);
            ps.setInt(6, id);
            ps.executeUpdate();

            ps.close();
            koneksiDB.close();

        } catch (SQLException ex) {
            Logger.getLogger(RawatDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hapusRawatById(Rawat rwt) {
        String sql = "delete from latihan_1.rawat where id = ?";

        try {
            Connection conection = KonfigDB.getDataSource().getConnection();
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, rwt.getId());
            ps.executeUpdate();
            
            sql = "update latihan_1.ruang set kosong = true WHERE id = ?";
            ps = conection.prepareStatement(sql);
            System.out.println(rwt.getRuangId().getId());
            ps.setInt(1, rwt.getRuangId().getId());
            ps.executeUpdate();
            ps.close();
            conection.close();

            ps.close();
            conection.close();

        } catch (SQLException ex) {
            Logger.getLogger(RawatDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
