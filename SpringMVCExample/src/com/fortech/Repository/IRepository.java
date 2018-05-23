package com.fortech.Repository;

import java.util.List;

public interface IRepository<ID, T> {
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T findOne(ID id);
	
	public List<T> findAll();

}
