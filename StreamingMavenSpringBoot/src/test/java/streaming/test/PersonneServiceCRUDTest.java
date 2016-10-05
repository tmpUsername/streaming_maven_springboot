/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.entity.Personne;
import streaming.spring.SpringConfig;
import streaming.service.PersonneServiceCRUD;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class PersonneServiceCRUDTest {
    @Autowired
    private PersonneServiceCRUD dao;
    
    @Before
    public void init(){
        dao.deleteAll();
        
        Personne p = new Personne();
        p.setNom("Smith");
        p.setPrenom("Will");
        dao.save(p);
        p = new Personne();
        p.setNom("Smith");
        p.setPrenom("Will");
        dao.save(p);
    }
    
    @Test
    public void ajouter(){
        Personne p = new Personne();
        p.setNom("Smith");
        p.setPrenom("Will");
        dao.save(p);
    }
    
    @Test
    public void findOneKO(){
        try {
            dao.findOneByPrenomAndNom("Will", "Smith");
            Assert.fail();
        } catch (Exception e) {}
    }
    
    @Test
    public void findAllOK(){
        Assert.assertNotNull(dao.findAllByPrenomAndNom("Will", "Smith"));
    }
}
