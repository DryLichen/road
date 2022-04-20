package com.dry.demo.service;

import com.dry.demo.mbg.model.PmsBrand;

import java.util.List;

public interface PmsBrandService {

    int createBrand(PmsBrand brand);

    int deleteBrand(Long id);

    int updateBrand(Long id, PmsBrand brand);

    List<PmsBrand> listAllBrand();

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
