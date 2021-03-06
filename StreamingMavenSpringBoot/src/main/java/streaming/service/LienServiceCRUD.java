/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.service;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import streaming.entity.Lien;

/**
 *
 * @author admin
 */
public interface LienServiceCRUD extends CrudRepository<Lien, Long>{
    public List<Lien> findAllByFilmId(Long filmId);
    public List<Lien> findAllByEpisodeNumEpisodeAndEpisodeSaisonNumSaisonAndEpisodeSaisonSerieTitre(Integer numEpisode, Integer numSaison, String titre);
}
