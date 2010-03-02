package org.avaje.demo.test;
import junit.framework.Assert;

import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;


public class TestDbConnection {

    @Test
    public void test(){
        
        String sql = "select count(*) as cnt from b_testtable";
        SqlRow row = Ebean.createSqlQuery(sql)
            .findUnique();
        
        Integer count = row.getInteger("cnt");
        
        Assert.assertNotNull(count);
        
    }
}
