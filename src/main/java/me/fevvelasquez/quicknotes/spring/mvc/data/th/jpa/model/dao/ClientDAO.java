package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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
@Deprecated
@Repository //("qclientDAO")
public class ClientDAO implements IClientDAO {

	// H2 by default
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Client> findAll() {
		return em.createQuery("from Client", Client.class).getResultList();
	}

	@Override
	public Client findOne(Long id) {
		return em.find(Client.class, id);
	}

	@Override
	public void save(Client client) {
		if (client.getId() == null) {
			em.persist(client);
		} else {
			em.merge(client);
		}
	}

	@Override
	public void delete(Long id) {
		em.remove(findOne(id));
	}

}
