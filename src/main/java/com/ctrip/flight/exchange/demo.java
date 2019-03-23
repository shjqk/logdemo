package com.ctrip.flight.exchange;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.concurrent.*;

/**
 * Created by qiangjiang on 2019/3/21.
 */
public class demo  {
    private static final Logger logger = LoggerFactory.getLogger(demo.class);
    public static void main(String[] args) throws Exception {

        //logger.info("Test log4j2 info");
        logger.error("我是debug信息");
        logger.warn("hello warn {}", "slf4j");
        logger.info("hello info {}", "slf4j");
        logger.debug("hello debug {}", "slf4j");
        logger.trace("hello trace {}", "slf4j");

        for(int i=0;i<5 ;i++) {
            ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("QQThread"+i).build();

            ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                    5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),threadFactory);
            executorService.execute(new Task(i));
        }
    }
}
