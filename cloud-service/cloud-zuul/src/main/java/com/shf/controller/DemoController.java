package com.shf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/3 16:42
 * @Version V1.0
 **/
@RestController
@Slf4j
public class DemoController {
    @RequestMapping("/demo")
    public String demo(){
        log.info("----尼玛----");
        return "OK";
    }
}
