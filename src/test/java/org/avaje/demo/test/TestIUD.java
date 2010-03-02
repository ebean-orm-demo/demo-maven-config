package org.avaje.demo.test;

import org.avaje.demo.test.model.BasicEntity;
import org.junit.Assert;
import org.junit.Test;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;

public class TestIUD {

    @Test
    public void test() {
        
        BasicEntity e = new BasicEntity();
        e.setName("test name");
        e.setDescription("a description");
        
        // Get the default EbeanServer and save
        EbeanServer server = Ebean.getServer(null);
        server.save(e);
        Assert.assertNotNull(e.getId());
        
        // shortcut for the above code
        //Ebean.save(e);

        e.setDescription("banana");
        server.save(e);
        
        // find by id
        BasicEntity e2 = server.find(BasicEntity.class, e.getId());
        Assert.assertNotNull("we found it in the db",e2);
        Assert.assertTrue("different instance",e2 != e);
        Assert.assertEquals("updated description","banana",e2.getDescription());
     
        server.delete(e2);

        BasicEntity e3 = server.find(BasicEntity.class, e.getId());
        Assert.assertNull("its been deleted",e3);

    }
}
