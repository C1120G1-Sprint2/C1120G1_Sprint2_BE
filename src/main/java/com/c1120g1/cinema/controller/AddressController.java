package com.c1120g1.cinema.controller;

import com.c1120g1.cinema.service.DistrictService;
import com.c1120g1.cinema.service.ProvinceService;
import com.c1120g1.cinema.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class AddressController {

    @Autowired
    ProvinceService provinceService;

    @Autowired
    DistrictService districtService;

    @Autowired
    WardService wardService;

}
