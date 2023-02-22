package com.ilhamkawe.karyawancrud.service;

import com.ilhamkawe.karyawancrud.dto.CreateRequestDto;
import com.ilhamkawe.karyawancrud.dto.UpdateRequestDto;

import java.util.List;
import com.ilhamkawe.karyawancrud.domain.Karyawan;

public interface KaryawanService {
    public int Create(CreateRequestDto input);

    public int Update(UpdateRequestDto update);

    public int Destroy(String id);

    public List<Karyawan> all();

    public String nama();

    public List<Karyawan> FindByName(String name);

    public List<Karyawan> FindByNameLIKE(String name);

    public List<Karyawan> FindByTglMasuk(String tglMsk);

    public List<Karyawan> FindByNoHP(String noHP);

    public List<Karyawan> FindByNameExceptMe(String name, String kode);

    public Karyawan FindByKode(String kode);

    public List<Karyawan> FindByAll(String name, String tglMsk, String noHp);

    public List<Karyawan> Search(String name, String tglMsk, String noHp);

    public List<Karyawan> FindByNameAndTglMsk(String name, String tglMsk);

    public List<Karyawan> FindByNameAndnoHp(String name, String noHp);

    public List<Karyawan> FindBytglMskAndnoHp(String tglMsk, String noHp);
}
