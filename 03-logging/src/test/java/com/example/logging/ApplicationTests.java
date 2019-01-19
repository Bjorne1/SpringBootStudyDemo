package com.example.logging;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        logger.trace("this trace log");
        logger.debug("this is debug log");
        //spring boot默认的日志级别是Info级别,所以以上两个并不会输出
        logger.info("this is info log");
        logger.warn("this is warn log");
        logger.error("this is error log");
    }

}

