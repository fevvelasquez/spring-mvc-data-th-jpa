package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.service;

import java.util.List;

/**
 * Quick Notes.
 * 
 * Generic DAO Interface.
 * 
 * @author fevvelasquez
 *
 */
public interface IService<T, ID_T> {

	public List<T> findAll();

	public T findOne(ID_T id);

	public void save(T t);
	
	public void delete(ID_T id);

}
