/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import org.dbunit.DatabaseUnitException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.service.SaisonServiceCRUD;
import streaming.spring.SpringConfig;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class SaisonServiceCRUDTest {
    @Autowired
    private SaisonServiceCRUD service;

    @BeforeClass
    public static void avant() throws ClassNotFoundException, SQLException, DatabaseUnitException, FileNotFoundException {
        new ImportDB().test();
    }
    
    //14. Toutes les saisons d'une série donnée classées par ordre
    @Test
    public void toutesLesSaisonsDeDexter(){
        Assert.assertEquals(8, service.findAllBySerieTitreOrderByNumSaisonAsc("Dexter").size());
    }
}
