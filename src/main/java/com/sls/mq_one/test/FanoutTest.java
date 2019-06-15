package com.sls.mq_one.test;

import com.sls.BootMqApplication;
import com.sls.mq_one.mq.FanoutSender;
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
public class FanoutTest {

    @Autowired
    private FanoutSender fanoutSender;

    /**
     * Fanout下路由键无效（绑定的队列无效），都能消费这两个消息
     */
    @Test
    public void Test() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        fanoutSender.send("time1==>" + sf.format(new Date()));
        fanoutSender.send2("Date==>" + sf.format(new Date()));
    }
}
