package com.example.libman.dto;

import lombok.Data;

import java.util.List;

@Data
public class LendingRequest {
    private int readerId;
    private List<Integer> lentDocIds;
}
