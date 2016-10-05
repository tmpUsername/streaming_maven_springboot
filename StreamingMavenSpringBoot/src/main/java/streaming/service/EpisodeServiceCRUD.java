/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Episode;

/**
 *
 * @author admin
 */
public interface EpisodeServiceCRUD extends CrudRepository<Episode, Long>{
    public List<Episode> findAllBySaisonNumSaisonAndSaisonSerieTitreOrderByNumEpisodeAsc(Integer numSaison, String titreSerie);
}
