/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import junit.framework.Assert;
import org.dbunit.DatabaseUnitException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.service.EpisodeServiceCRUD;
import streaming.spring.SpringConfig;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class EpisodeServiceCRUDTest {
    @Autowired
    private EpisodeServiceCRUD service;

    @BeforeClass
    public static void avant() throws ClassNotFoundException, SQLException, DatabaseUnitException, FileNotFoundException {
        new ImportDB().test();
    }

    //15. Tous les épisodes d'une saison donnée d'une série donnée, classés par ordre    
    @Test
    public void nbEpisodeSaison1DeDexter(){
        Assert.assertEquals(12, service.findAllBySaisonNumSaisonAndSaisonSerieTitreOrderByNumEpisodeAsc(1, "Dexter").size());
    }
}
