package com.sls.test;

import com.sls.BootMqApplication;
import com.sls.mq.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sls
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BootMqApplication.class)
public class TopicTest {

    @Autowired
    private TopicSender topicSender;

    @Test
    public void Test() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        topicSender.topicSender("time==>" + sf.format(new Date()));
    }
}
