/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.entity.Personne;
import streaming.spring.SpringConfig;
import streaming.service.PersonneService;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class PersonneDAOTest {
    @Autowired
    private PersonneService dao;
    
    @Test
    public void ajouter(){
        Personne p = new Personne();
        p.setNom("LALA");
        p.setPrenom("Michel");
        dao.save(p);
    }
    
}
