package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.dao;

import java.util.List;

/**
 * Quick Notes.
 * 
 * Generic DAO Interface.
 * 
 * @author fevvelasquez
 *
 */
public interface IDAO<T, ID_T> {

	public List<T> findAll();

	public void save(T t);
	
	public T findOne(ID_T id);
	
	public void delete(ID_T id);

}
