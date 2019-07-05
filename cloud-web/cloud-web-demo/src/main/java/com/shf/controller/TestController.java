package com.shf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @Author shf
 * @Date 2019/7/3 17:18
 * @Version V1.0
 **/
@RestController
@Slf4j
public class TestController {
    @RequestMapping("/test")
    public String test() {
        log.info("尼玛，终于过来啦");
        return "OK";
    }
}
