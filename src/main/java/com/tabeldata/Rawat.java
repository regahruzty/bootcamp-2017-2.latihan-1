/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Diani
 */
public class Rawat {
    
    private Integer id;
    private Pasien pasienId;
    private Dokter dokterId;
    private Ruang ruangId;
    private Timestamp waktuRegister;
    private Timestamp waktuCheckout;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pasien getPasienId() {
        return pasienId;
    }

    public void setPasienId(Pasien pasienId) {
        this.pasienId = pasienId;
    }

    public Dokter getDokterId() {
        return dokterId;
    }

    public void setDokterId(Dokter dokterId) {
        this.dokterId = dokterId;
    }

    public Ruang getRuangId() {
        return ruangId;
    }

    public void setRuangId(Ruang ruangId) {
        this.ruangId = ruangId;
    }

    public Timestamp getWaktuRegister() {
        return waktuRegister;
    }

    public void setWaktuRegister(Timestamp waktuRegister) {
        this.waktuRegister = waktuRegister;
    }

    public Timestamp getWaktuCheckout() {
        return waktuCheckout;
    }

    public void setWaktuCheckout(Timestamp waktuCheckout) {
        this.waktuCheckout = waktuCheckout;
    }
    
    
    
}
