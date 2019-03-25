package com.qq;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by QQ on 2019/3/22.
 */
public class Task implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(Task.class);
    private  int num;

    public Task(int num){
        this.num = num;
    }
    public void run()  {
        try {
            //Thread.currentThread().setName("Thread"+num);
            while (true) {

                //System.out.println(Thread.currentThread().getName()+" running...");
                logger.error(Thread.currentThread().getName() +" error");
                ThreadContext.put("ROUTINGKEY", Thread.currentThread().getName());;
                logger.info(Thread.currentThread().getName() +" info");
                ThreadContext.remove("ROUTINGKEY");
                Thread.sleep(1000);
                if(num>1000){
                    break;
                }
            }
        }
        catch (Exception ex){

        }
    }
}
