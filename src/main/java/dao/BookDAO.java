package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Book;

public class BookDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void save(Book product){
		manager.persist(product);
	}
	
	public List<Book> list() {
		return manager.createQuery("select distinct(b) from Book b join fetch b.authors",
				Book.class).getResultList();
	}
}
