package com.dry.demo.controller;

import com.dry.demo.common.api.CommonPage;
import com.dry.demo.common.api.CommonResult;
import com.dry.demo.mbg.model.PmsBrand;
import com.dry.demo.service.impl.PmsBrandServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌管理
 * 网页查询pms_brand表的controller
 */
@Api(tags = "PmsBrandController",  description = "商品品牌管理")
@RestController
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandServiceImpl service;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("创建一个新品牌信息")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult result;
        int count  = service.createBrand(pmsBrand);
        if(count == 1){
            result = CommonResult.success(pmsBrand);
            LOGGER.debug("create brand{} successfully", pmsBrand);
        } else {
            result = CommonResult.failed();
            LOGGER.debug("create brand failed:{}", pmsBrand);
        }

        return result;
    }

    @ApiOperation("删除指定id的品牌信息")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        CommonResult result;
        int count = service.deleteBrand(id);
        if(count == 1){
            result = CommonResult.success(null);
            LOGGER.debug("delete brand successfully:{}", id);
        } else {
            result = CommonResult.failed();
            LOGGER.debug("delete brand failed:{}",id);
        }

        return result;
    }

    @ApiOperation("更新指定id的品牌信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrand, BindingResult bindingResult){
        CommonResult result;
        int count = service.updateBrand(id, pmsBrand);
        if(count == 1){
            result = CommonResult.success(pmsBrand);
            LOGGER.debug("update brand successfully:{}", pmsBrand);
        } else {
            result = CommonResult.failed();
            LOGGER.debug("update brand failed:{}",pmsBrand);
        }

        return result;
    }

    @ApiOperation("获取所有品牌信息")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<PmsBrand>> getAllBrand(){
        return CommonResult.success(service.listAllBrand());
    }

    @ApiOperation("分业获取品牌信息")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsBrand>> getListBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                           @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<PmsBrand> pmsBrandList = service.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(pmsBrandList));
    }

    @ApiOperation("获取指定id的品牌信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CommonResult<PmsBrand> getBrand(@PathVariable Long id){
        return CommonResult.success(service.getBrand(id));
    }
}
