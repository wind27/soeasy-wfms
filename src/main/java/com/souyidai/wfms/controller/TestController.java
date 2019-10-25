package com.souyidai.wfms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author qianchun
 * @date 2019/9/26
 **/

@RestController
@RequestMapping(value = "ajax/test")
public class TestController {
    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping(value = { "t1", "t2" })
    public String remindsms() {
        logger.info("测试");
        return "测试";
    }
}
