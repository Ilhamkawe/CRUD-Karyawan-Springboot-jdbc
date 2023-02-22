package com.ilhamkawe.karyawancrud.domain;

import java.sql.Timestamp;

public class Karyawan {
    private String kodeKaryawan;
    private String nama;
    private String tglMasuk;
    private String noHP;
    private long limitReimbursement;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Karyawan(String kodeKaryawan) {
        this.kodeKaryawan = kodeKaryawan;
    }

    public Karyawan() {

    }

    public Karyawan(String kodeKaryawan, String nama, String tglMasuk, String noHP, long limitReimbursement,
            Timestamp createdAt, Timestamp updatedAt) {
        this.kodeKaryawan = kodeKaryawan;
        this.nama = nama;
        this.tglMasuk = tglMasuk;
        this.noHP = noHP;
        this.limitReimbursement = limitReimbursement;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getKodeKaryawan() {
        return kodeKaryawan;
    }

    public void setKodeKaryawan(String kodeKaryawan) {
        this.kodeKaryawan = kodeKaryawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public long getLimitReimbursement() {
        return limitReimbursement;
    }

    public void setLimitReimbursement(long limitReimbursement) {
        this.limitReimbursement = limitReimbursement;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

}
