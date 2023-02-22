package com.ilhamkawe.karyawancrud.dto;

import lombok.Data;

@Data
public class SearchRequestDto {
    private String kodeKaryawan;
    private String tglMasuk;
    private String noHP;
}
