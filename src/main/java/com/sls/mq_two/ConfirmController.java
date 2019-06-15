package com.sls.mq_two;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sls
 **/
@RestController
public class ConfirmController {

    @Resource
    private ConfirmProducer confirmProducer;

    @GetMapping("/confirm")
    public void confirmMessage() {
        confirmProducer.send("hello confirm message");
    }
}
