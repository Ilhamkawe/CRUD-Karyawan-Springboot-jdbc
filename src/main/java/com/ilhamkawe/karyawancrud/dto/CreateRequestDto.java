package com.ilhamkawe.karyawancrud.dto;

import lombok.Data;

@Data
public class CreateRequestDto {
    private String nama;
    private String tglMsk;
    private String noHp;
    private long limitReimbursement;
}
