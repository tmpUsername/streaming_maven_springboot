/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import streaming.entity.Pays;
import streaming.spring.SpringConfig;

/**
 *
 * @author admin
 */
@Repository
public class PaysDAO {

    @PersistenceContext
    private EntityManager em;

    public Pays rechercher(long id) {
        return em.find(Pays.class, id);
    }

    @Transactional
    public void ajouter(Pays p) {
        em.persist(p);
    }
    
    @Transactional
    public void modifier (Pays p){
        em.merge(p);
    }
    
}
