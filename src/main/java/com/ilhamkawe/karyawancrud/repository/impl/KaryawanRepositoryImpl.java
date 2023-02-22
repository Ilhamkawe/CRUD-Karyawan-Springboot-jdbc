package com.ilhamkawe.karyawancrud.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.ilhamkawe.karyawancrud.domain.Karyawan;
import com.ilhamkawe.karyawancrud.repository.KaryawanRepository;

import java.util.TimeZone;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Repository
public class KaryawanRepositoryImpl implements KaryawanRepository {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<Karyawan> All() {

        String sql = "Select * from Informasi ORDER BY kode_karyawan ASC";
        return jdbc.query(sql, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public int Create(Karyawan Karyawan) {
        // TODO Auto-generated method stub
        return jdbc.update(
                "INSERT INTO informasi VALUES (?, ?, ?::date, ?, ?, ?, ?)",
                Karyawan.getKodeKaryawan(),
                Karyawan.getNama(),
                Karyawan.getTglMasuk(),
                Karyawan.getNoHP(),
                Karyawan.getLimitReimbursement(),
                Karyawan.getCreatedAt(),
                Karyawan.getUpdatedAt());
    }

    @Override
    public int Update(Karyawan Karyawan) {

        return jdbc.update(
                "UPDATE informasi SET nama_karyawan = ?, tgl_masuk = ?::date, no_hp = ?, limit_reimbursement = ?, updated_at =? WHERE LOWER(kode_karyawan) = LOWER(?)",
                Karyawan.getNama(),
                Karyawan.getTglMasuk(),
                Karyawan.getNoHP(),
                Karyawan.getLimitReimbursement(),
                Karyawan.getUpdatedAt(),
                Karyawan.getKodeKaryawan());

    }

    @Override
    public List<Karyawan> FindByName(String name) {
        String sql = "SELECT * FROM informasi WHERE LOWER(nama_karyawan) = LOWER(?)";
        return jdbc.query(sql, new Object[] { name }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public List<Karyawan> FindByNameLIKE(String name) {
        String sql = "SELECT * FROM informasi WHERE LOWER(nama_karyawan) LIKE LOWER(?)";
        String nameParam = '%' + name + '%';
        return jdbc.query(sql, new Object[] { nameParam }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public List<Karyawan> FindByNameExceptMe(String name, String kode) {
        String sql = "SELECT * FROM informasi WHERE LOWER(nama_karyawan) = LOWER(?) AND NOT LOWER(kode_karyawan) = LOWER(?)";
        return jdbc.query(sql, new Object[] { name, kode }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public List<Karyawan> FindByTglMasuk(String tglMsk) {
        String sql = "SELECT * FROM informasi WHERE tgl_masuk = ?::date";
        return jdbc.query(sql, new Object[] { tglMsk }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public List<Karyawan> FindByNoHP(String noHp) {
        String sql = "SELECT * FROM informasi WHERE no_hp = ?";
        return jdbc.query(sql, new Object[] { noHp }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public List<Karyawan> FindByAll(String name, String tglMsk, String noHp) {
        String sql = "SELECT * FROM informasi WHERE no_hp = ? AND LOWER(nama_karyawan) LIKE LOWER(?) AND tgl_masuk = ?::date";
        return jdbc.query(sql, new Object[] { noHp, name, tglMsk }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public int Destroy(String id) {
        String sql = "DELETE FROM informasi WHERE LOWER(kode_karyawan) = LOWER(?)";
        int destroy = jdbc.update(sql, id);
        return destroy;
    }

    @Override
    public Karyawan FindByKode(String kode) {
        String sql = "SELECT * FROM informasi WHERE LOWER(kode_karyawan) = LOWER(?)";
        return jdbc.queryForObject(sql, new Object[] { kode }, new RowMapper<Karyawan>() {
            @Override
            public Karyawan mapRow(ResultSet rs, int rowNum) throws SQLException {
                Karyawan karyawan = new Karyawan();
                karyawan.setKodeKaryawan(rs.getString("kode_karyawan"));
                karyawan.setNama(rs.getString("nama_karyawan"));
                karyawan.setTglMasuk(rs.getString("tgl_masuk"));
                karyawan.setNoHP(rs.getString("no_hp"));
                karyawan.setLimitReimbursement(rs.getLong("limit_reimbursement"));
                karyawan.setCreatedAt(rs.getTimestamp("created_at"));
                karyawan.setUpdatedAt(rs.getTimestamp("updated_at"));
                return karyawan;
            }
        });
    }

    @Override
    public List<Karyawan> FindByNameAndTglMsk(String name, String tglMsk) {
        String sql = "SELECT * FROM informasi WHERE LOWER(nama_karyawan) = LOWER(?) AND tgl_masuk = ?::date";
        return jdbc.query(sql, new Object[] { name, tglMsk }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public List<Karyawan> FindByNameAndnoHp(String name, String noHp) {
        String sql = "SELECT * FROM informasi WHERE LOWER(nama_karyawan) = LOWER(?) AND no_hp = ?";
        return jdbc.query(sql, new Object[] { name, noHp }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

    @Override
    public List<Karyawan> FindBytglMskAndnoHp(String tglMsk, String noHp) {
        String sql = "SELECT * FROM informasi WHERE tgl_masuk = ?::date AND no_hp = ?";
        return jdbc.query(sql, new Object[] { tglMsk, noHp }, (rs, rowNum) -> new Karyawan(
                rs.getString("kode_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getString("tgl_masuk"),
                rs.getString("no_hp"),
                rs.getLong("limit_reimbursement"),
                rs.getTimestamp("created_at"),
                rs.getTimestamp("updated_at")));
    }

}
