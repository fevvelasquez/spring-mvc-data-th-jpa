package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.daoWithSpringData.IClientDAO;
import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.entity.Client;

/**
 * Quick Notes.
 * 
 * @author fevvelasquez
 *
 */
@Service
public class ClientService implements IClientService {

	@Autowired
	// @Qualifier("qclientDAO") // If multiple implementations
	IClientDAO clientDAO;
	// We can have multiple DAO's here.

	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() {
		return (List<Client>) clientDAO.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Client findOne(Long id) {
		return clientDAO.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void save(Client client) {
		clientDAO.save(client);
	}

	@Transactional
	@Override
	public void delete(Long id) {
		clientDAO.deleteById(id);
	}

}
