package com.ilhamkawe.karyawancrud.dto;

import lombok.Data;

@Data
public class UpdateRequestDto {
    private String kodeKaryawan;
    private String nama;
    private String tglMsk;
    private String noHp;
    private long limitReimbursement;
}
