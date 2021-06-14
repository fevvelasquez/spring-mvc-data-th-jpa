package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.daoWithSpringData;

import org.springframework.data.repository.CrudRepository;

import me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.entity.Client;

/**
 * Quick Notes.
 * 
 * Client DAO interface using Spring Data CrudRepository Interface.
 * 
 * @author fevvelasquez
 *
 */
public interface IClientDAO extends CrudRepository<Client, Long> {

}
