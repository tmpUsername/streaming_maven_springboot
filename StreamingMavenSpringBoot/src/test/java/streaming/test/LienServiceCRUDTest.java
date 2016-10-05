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
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.service.LienServiceCRUD;
import streaming.spring.SpringConfig;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class LienServiceCRUDTest {
    @Autowired
    private LienServiceCRUD service;
    
    @BeforeClass
    public static void avant() throws ClassNotFoundException, SQLException, DatabaseUnitException, FileNotFoundException {
        new ImportDB().test();
    }
    
    //13. Tous les liens d'un film donné
    @Test
    public void liensFilmdonne(){
        Assert.assertEquals(3, service.findAllByFilmId(4L).size());
    }
    
    //16. Tous les liens d'un numéro d'épisode d'un numéro de saison d'une série donnée
    @Test
    public void liensEpSerieSaisonTitreOK(){
        Assert.assertNotNull(service.findOnelByEpisodeNumEpisodeAndEpisodeSaisonNumSaisonAndEpisodeSaisonSerieTitre(1, 1, "Borgia"));
    }
    
    @Test
    public void liensEpSerieSaisonTitreKO(){
        Assert.assertNotNull(service.findOnelByEpisodeNumEpisodeAndEpisodeSaisonNumSaisonAndEpisodeSaisonSerieTitre(125, 1, "Borgia"));
    }
}
