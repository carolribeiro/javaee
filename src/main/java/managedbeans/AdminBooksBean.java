package managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import dao.AuthorDAO;
import dao.BookDAO;
import infra.MessagesHelper;
import model.Author;
import model.Book;

@Model
@Named(value = "adminBooksBean")
public class AdminBooksBean {
	
	private Book product = new Book();
	@Inject
	private BookDAO bookDAO;
	@Inject
	private AuthorDAO authorDAO;
	private List<Author> authors = new ArrayList<Author>();
	@Inject
	private MessagesHelper mh;
	
	public AdminBooksBean(){}
	
	@Transactional
	public String save() {
		bookDAO.save(product);
		mh.addFlash(new FacesMessage("Livro gravado com sucesso"));
		return "livros/list?faces-redirect=true";
	}
	
	public Book getProduct() {
		return product;
	}
	
//	private List<Integer> selectedAuthorsIds = new ArrayList<>();
//
//	public List<Integer> getSelectedAuthorsIds() {
//		return selectedAuthorsIds;
//	}
//
//	public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
//		this.selectedAuthorsIds = selectedAuthorsIds;
//	}
//	//java 8  lambda = ->
//	private void populateBookAuthor(){
//		selectedAuthorsIds.stream().map((id) ->{
//			return new Author(id);
//			}).forEach(product :: add);
//	}
//	
	public List<Author> getAuthors(){
		return authors;
	}
//	
//	@PostConstruct //rodar code dps de feita a @Inject
//	public void loadObjects(){
//		this.authors = authorDAO.list();
//	}
//	
//	private void clearObjects() {
//		this.product = new Book();
//		this.selectedAuthorsIds.clear();
//	}
}
