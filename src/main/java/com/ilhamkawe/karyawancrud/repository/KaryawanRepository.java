package com.ilhamkawe.karyawancrud.repository;

import com.ilhamkawe.karyawancrud.domain.Karyawan;
import java.util.List;

public interface KaryawanRepository {
    public int Create(Karyawan Karyawan);

    public int Update(Karyawan Karyawan);

    public List<Karyawan> All();

    public List<Karyawan> FindByName(String name);

    public List<Karyawan> FindByNameLIKE(String name);

    public List<Karyawan> FindByNameExceptMe(String name, String kode);

    public List<Karyawan> FindByTglMasuk(String tglMsk);

    public List<Karyawan> FindByNoHP(String noHP);

    public List<Karyawan> FindByAll(String name, String tglMsk, String noHp);

    public int Destroy(String id);

    public Karyawan FindByKode(String kode);

    public List<Karyawan> FindByNameAndTglMsk(String name, String tglMsk);

    public List<Karyawan> FindByNameAndnoHp(String name, String noHp);

    public List<Karyawan> FindBytglMskAndnoHp(String tglMsk, String noHp);

}
