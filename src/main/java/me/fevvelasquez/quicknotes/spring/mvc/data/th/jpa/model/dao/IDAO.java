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

}
