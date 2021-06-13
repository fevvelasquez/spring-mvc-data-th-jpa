package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.entity.Client;

/**
 * 
 * Quick Notes.
 * 
 * {@code clients} table data initialization script located at
 * "resources/import.sql"
 * 
 * @author fevvelasquez
 *
 */
@Repository("qclientDAO")
public class ClientDAO implements IClientDAO {

	// H2 by default
	@PersistenceContext
	private EntityManager em;

	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() {
		return em.createQuery("from Client", Client.class).getResultList();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Client findOne(Long id) {
		return em.find(Client.class, id);
	}

	@Transactional
	@Override
	public void save(Client client) {
		if (client.getId() == null) {
			em.persist(client);
		} else {
			em.merge(client);
		}
	}

	@Transactional
	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
