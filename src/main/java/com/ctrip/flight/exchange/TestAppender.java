package com.ctrip.flight.exchange;

import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;

import java.io.Serializable;

/**
 * Created by qiangjiang on 2019/3/21.
 */

@Plugin(name = "TestAppender", category = "Core", elementType = "appender", printObject = true)
public class TestAppender extends AbstractAppender {

    protected TestAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @PluginFactory
    public static TestAppender createAppender(@PluginAttribute("name") String name,
                                              @PluginElement("Filter") final Filter filter,
                                              @PluginElement("Layout") Layout<? extends Serializable> layout,
                                              @PluginAttribute("ignoreExceptions") boolean ignoreExceptions) {
        return new TestAppender(name,filter,layout,ignoreExceptions);
    }

    public void append(LogEvent event) {
        System.out.println("sleep...1000");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TestAppender:" + getLayout().toSerializable(event).toString());
    }
}
