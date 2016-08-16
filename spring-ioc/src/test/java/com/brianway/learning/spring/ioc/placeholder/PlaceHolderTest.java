package com.brianway.learning.spring.ioc.placeholder;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import javax.sql.DataSource;

/**
 * Created by brian on 16/6/23.
 */
public class PlaceHolderTest {
    @Test
    public void testPlaceHolder() throws Exception {
        String resourceFile = "com/brianway/learning/spring/ioc/placeholder/beans-placeholder.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(resourceFile);
        DataSource ds = ctx.getBean(DataSource.class);
        Connection conn = ds.getConnection();

        System.out.println(ctx.getBean(MyDataSource.class));
    }
}
