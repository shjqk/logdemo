package com.qq.log;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LogTest 
{
    private static Logger logger = LogManager.getLogger(LogTest.class.getName());
    public static void main(String[] args)
    {                     
        System.out.println("test");
        logger.entry();   //trace�������Ϣ�������г�����ϣ������ĳ���������߳����߼���ʼ��ʱ����ã���logger.trace("entry")����һ����˼
        logger.error("Did it again!");   //error�������Ϣ�������������������Ϣ
        logger.info("����info��Ϣ");    //info�������Ϣ
        logger.debug("����debug��Ϣ");
        logger.warn("����warn��Ϣ");
        logger.fatal("����fatal��Ϣ");
        logger.log(Level.DEBUG, "����debug��Ϣ");   //��������ƶ�Level���͵ĵ��ã�˭����û�µ��������Ҳ��һ��Ŷ��
        logger.exit();    //��entry()��Ӧ�Ľ�����������logger.trace("exit");һ����˼
    
    }
}
