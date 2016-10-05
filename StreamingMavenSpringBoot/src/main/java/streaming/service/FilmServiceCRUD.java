/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Film;

/**
 *
 * @author admin
 */
public interface FilmServiceCRUD extends CrudRepository<Film, Long>{
    
    public List<Film> findAllByTitre(String titre);
    public Film findOneByTitre(String titre);
    
    public List<Film> findAllByAnnee(Integer annee);
    
    public List<Film> findAllByTitreOrAnnee(String titre, Integer annee);
    public List<Film> findAllByTitreAndAnnee(String titre, Integer annee);
    
    public List<Film> findAllByGenreId(Long genreID);
    
    public List<Film> findAllByPaysId(Long payID);
    
    public List<Film> findAllByGenreIdAndPaysId(Long genreID, Long payID);
    
    public List<Film> findAllByActeursNomAndActeursPrenom(String nom, String prenom);
    
    public Long countByActeursNomAndActeursPrenom(String nom, String prenom);
    
    public List<Film> findAllByRealisateursNomAndRealisateursPrenomOrderByTitreAsc(String nom, String prenom);
    
    public Long countByRealisateursNomAndRealisateursPrenom(String nom, String prenom);
    
    public List<Film> findAllByGenreIdAndPaysIdAndActeursIdAndRealisateursId(Long genreId, Long payID, Long acteurId, Long realisateurId);
}
