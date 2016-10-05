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
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import streaming.spring.SpringConfig;
import streaming.service.FilmServiceCRUD;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringConfig.class)
public class FilmServiceCRUDTest {

    @Autowired
    private FilmServiceCRUD service;

    @BeforeClass
    public static void avant() throws ClassNotFoundException, SQLException, DatabaseUnitException, FileNotFoundException {
        new ImportDB().test();
    }

    //1. Le film pour un titre donné
    @Test
    public void filmTitreDonneeOK() {
        Assert.assertNotNull(service.findOneByTitre("Fargo"));
    }

    @Test
    public void filmTitreDonneeKO() {
        Assert.assertNull(service.findOneByTitre("Caca"));
    }

    //2. Les films pour une année donnée
    @Test
    public void filmsAnneesDonneesOK() {
        Assert.assertFalse(service.findAllByAnnee(1968).isEmpty());
    }

    @Test
    public void filmsAnneesDonneesKO() {
        Assert.assertTrue(service.findAllByAnnee(1800).isEmpty());
    }
    
    //3. Les films pour un titre donné ou un année donnée
    @Test
    public void filmsAnneesOuTitreDonneesOK(){
        Assert.assertFalse(service.findAllByTitreOrAnnee("Fargo",1968).isEmpty());
        Assert.assertFalse(service.findAllByTitreOrAnnee("Fargo",1900).isEmpty());
        Assert.assertFalse(service.findAllByTitreOrAnnee("Caca", 1968).isEmpty());
    }
    //4. Les films pour un titre et une année donnée
    @Test
    public void filmsPourTitreEtAnneeDonneeOK(){
        Assert.assertFalse(service.findAllByTitreAndAnnee("Fargo",1996).isEmpty());
    }
    
    @Test 
    public void filmsPourTitreEtAnneeDonneeKO(){
        Assert.assertTrue(service.findAllByTitreAndAnnee("Fargo", 1900).isEmpty());
    }
    
    //5. Les films pour un genre id donné
    @Test
    public void filmsParGenreID(){
        Assert.assertFalse(service.findAllByGenreId(1L).isEmpty());
    }
    
    //6. Les films pour un pays id donnée
    @Test
    public void filmsParPaysID(){
        Assert.assertFalse(service.findAllByPaysId(1L).isEmpty());
    }
    
    //7. Les films pour un genre id et un pays id donnés
    @Test
    public void filmsParGenreIdEtPaysId(){
        Assert.assertFalse(service.findAllByGenreIdAndPaysId(1L, 1L).isEmpty());
    }
    
    //8. Les films pour un acteur (nom/prénom) donné
    @Test
    public void filmsParActeur(){
        Assert.assertFalse(service.findAllByActeursNomAndActeursPrenom("Polanski", "Roman").isEmpty());
    }
    //9. Le nombre de films pour un acteur donné
    @Test
    public void NbFilmJouePolanski(){
        Assert.assertEquals((Long)1L, service.countByActeursNomAndActeursPrenom("Polanski", "Roman"));
    }
    
    //10. Les films pour un réalisateur donné, classés par titre
    @Test
    public void filmRealRomanPolanski(){
        Assert.assertEquals(2, service.findAllByRealisateursNomAndRealisateursPrenomOrderByTitreAsc("Polanski", "Roman").size());
    }
    
    @Test
    public void filmRealEthanCoen(){
        Assert.assertEquals(2, service.findAllByRealisateursNomAndRealisateursPrenomOrderByTitreAsc("Coen", "Ethan").size());
    }
    //11. Le nombre de films pour un réalisateur donné
    @Test
    public void NBfilmRealRomanPolanski(){
        Assert.assertEquals((Long)2L, service.countByRealisateursNomAndRealisateursPrenom("Polanski", "Roman"));
    }
    
    @Test
    public void NBfilmRealEthanCoen(){
        Assert.assertEquals((Long)2L, service.countByRealisateursNomAndRealisateursPrenom("Coen", "Ethan"));
    }
    
    //12. Les films d'un pays donné, pour un genre donné, un réalisateur donné et un acteur donné
    @Test
    public void filmDePolanskiAvecPolanskiHorreurEtUKOK(){
        Assert.assertFalse(service.findAllByGenreIdAndPaysIdAndActeursIdAndRealisateursId(1L, 1L, 1L, 1L).isEmpty());
    }
    
    @Test
    public void filmDePolanskiAvecPolanskiHorreurEtFranceKO(){
        Assert.assertTrue(service.findAllByGenreIdAndPaysIdAndActeursIdAndRealisateursId(1L, 2L, 1L, 1L).isEmpty());
    }
    
}
