package com.ilhamkawe.karyawancrud.service.impl;

import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import com.ilhamkawe.karyawancrud.domain.Karyawan;
import com.ilhamkawe.karyawancrud.dto.CreateRequestDto;
import com.ilhamkawe.karyawancrud.dto.UpdateRequestDto;
import com.ilhamkawe.karyawancrud.helper.Helper;
import com.ilhamkawe.karyawancrud.repository.impl.KaryawanRepositoryImpl;
import com.ilhamkawe.karyawancrud.service.KaryawanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service("karyawanService")
@RequiredArgsConstructor

public class KaryawanServiceImpl implements KaryawanService {

    private final KaryawanRepositoryImpl repo;
    private final Helper helper;

    @Override
    public List<Karyawan> all() {

        return repo.All();
    }

    @Override
    public List<Karyawan> FindByName(String name) {
        return repo.FindByName(name);
    }

    @Override
    public List<Karyawan> FindByNameExceptMe(String name, String kode) {
        return repo.FindByNameExceptMe(name, kode);
    }

    @Override
    public int Create(CreateRequestDto input) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        Timestamp timestamp = Timestamp.valueOf(formattedDateTime);
        Karyawan data = new Karyawan(
                helper.createID("informasi", "K", 4, "kode_karyawan"),
                input.getNama(),
                input.getTglMsk(), input.getNoHp(),
                input.getLimitReimbursement(), timestamp, timestamp);
        return repo.Create(data);
    }

    @Override
    public int Update(UpdateRequestDto update) {
        // TODO Auto-generated method stub
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        Timestamp timestamp = Timestamp.valueOf(formattedDateTime);
        Karyawan data = new Karyawan(
                update.getKodeKaryawan(),
                update.getNama(),
                update.getTglMsk(), update.getNoHp(),
                update.getLimitReimbursement(), timestamp, timestamp);
        return repo.Update(data);

    }

    @Override
    public String nama() {
        // TODO Auto-generated method stub
        return "ilham";
    }

    @Override
    public List<Karyawan> FindByNoHP(String noHp) {
        return repo.FindByNoHP(noHp);
    }

    @Override
    public int Destroy(String id) {
        return repo.Destroy(id);
    }

    @Override
    public Karyawan FindByKode(String kode) {
        return repo.FindByKode(kode);
    }

    @Override
    public List<Karyawan> FindByNameLIKE(String name) {
        return repo.FindByNameLIKE(name);
    }

    @Override
    public List<Karyawan> FindByTglMasuk(String tglMsk) {
        return repo.FindByTglMasuk(tglMsk);
    }

    @Override
    public List<Karyawan> FindByAll(String name, String tglMsk, String noHp) {
        return repo.FindByAll(name, tglMsk, noHp);
    }

    @Override
    public List<Karyawan> FindByNameAndTglMsk(String name, String tglMsk) {

        return repo.FindByNameAndTglMsk(name, tglMsk);
    }

    @Override
    public List<Karyawan> FindByNameAndnoHp(String name, String noHp) {

        return repo.FindByNameAndnoHp(name, noHp);
    }

    @Override
    public List<Karyawan> FindBytglMskAndnoHp(String tglMsk, String noHp) {

        return repo.FindBytglMskAndnoHp(tglMsk, noHp);
    }

    @Override
    public List<Karyawan> Search(String name, String tglMsk, String noHp) {

        if (!name.equals("") && !tglMsk.equals("") && !noHp.equals("")) {
            return this.FindByAll(name, tglMsk, noHp);
        }
        if (name.equals("") && tglMsk.equals("") && noHp.equals("")) {
            return this.all();
        }

        if (!name.equals("")) {
            if (!tglMsk.equals("")) {
                return this.FindByNameAndTglMsk(name, tglMsk);
            } else if (!noHp.equals("")) {
                return this.FindByNameAndnoHp(name, noHp);
            } else {
                return this.FindByNameLIKE(name);
            }
        } else if (!noHp.equals("")) {
            if (!tglMsk.equals("")) {
                return this.FindBytglMskAndnoHp(tglMsk, noHp);
            } else {
                return this.FindByNoHP(noHp);
            }
        } else {
            return this.FindByTglMasuk(tglMsk);
        }

    }

}