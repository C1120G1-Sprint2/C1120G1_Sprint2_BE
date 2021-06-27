package com.c1120g1.cinema.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {
    private String wardName;
    private String districtName;
    private String provinceName;
}
