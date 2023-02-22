package com.ilhamkawe.karyawancrud.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ilhamkawe.karyawancrud.domain.Karyawan;

@Service
public class Helper {

    @Autowired
    JdbcTemplate jdbc;

    public String createID(String table, String inisial, int digit, String field) {
        String id = "";
        try {
            String sql = "Select " + field + " from " + table + " ORDER BY " + field + " DESC limit 1";
            String data = jdbc.queryForObject(sql, String.class);
            inisial = data.substring(0, inisial.length());
            int uid = Integer.parseInt(data.substring(inisial.length()));
            // concatenate inisial and uid
            id = inisial + String.format("%0" + digit + "d", ++uid);

        } catch (EmptyResultDataAccessException e) {
            id = inisial + String.format("%0" + digit + "d", 1);
            // handling jika data tidak ditemukan
        }
        return id;
    }

    public boolean jejangTanggal(String tglMasukKerja) {

        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(tglMasukKerja);
            Date tglSekarang = new Date();

            long selisihWaktu = tglSekarang.getTime() - date.getTime();

            long selisihBulan = selisihBulan = selisihWaktu / (1000 * 3600 * 24 * 30);

            if (selisihBulan < -2 || selisihBulan > 3) {
                return false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
