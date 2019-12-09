package com.sls.mq_two;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sls
 **/
@RestController
public class ConfirmController {

    @Resource
    private ConfirmProducer confirmProducer;

    @PostMapping("/confirm-message")
    public void confirmMessage() {
        confirmProducer.send("hello confirm message");
    }
}
