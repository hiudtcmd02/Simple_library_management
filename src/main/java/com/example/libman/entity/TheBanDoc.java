package com.example.libman.entity;

import lombok.Data;

import java.sql.Date;

@Data
public class TheBanDoc {
    private int id;
    private String maThe;
    private Date ngayTaoThe;
    private Date ngayHetHan;
    private int banDocId;
}
