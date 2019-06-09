package com.sls.test;

import com.sls.BootMqApplication;
import com.sls.mq.Sender;
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
public class MQTest {

    @Autowired
    private Sender sender;

    @Test
    public void driectTest() {
        SimpleDateFormat sf = new SimpleDateFormat();
        sender.directSend("Driect Data:" + sf.format(new Date()));
    }
}
