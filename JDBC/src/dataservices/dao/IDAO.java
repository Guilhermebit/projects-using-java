package dataservices.dao;

import java.util.List;

public interface IDAO<T> {
	
	public void save(T entity);
	
	public T getLivro(long id);
	
	public List<T> list();
	
	public void remove(T entity);
	
	public void update(T entity);

}
