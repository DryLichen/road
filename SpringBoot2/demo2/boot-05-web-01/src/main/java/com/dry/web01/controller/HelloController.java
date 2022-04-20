package com.dry.web01.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloController {

    ///cars/sell;low=10;brand=byd,audi,bmw
    @RequestMapping(value = "/cars/{paths}", method = RequestMethod.GET)
    public Map carSell(@MatrixVariable("low") Integer low,
                       @MatrixVariable("brand") List<String> brand,
                       @PathVariable("paths") String paths){

        Map<String,Object> map = new HashMap<>();

        map.put("low", low);
        map.put("brand", brand);
        map.put("paths", paths);

        return map;
    }
}
