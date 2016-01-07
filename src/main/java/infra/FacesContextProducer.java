package infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

@ApplicationScoped //é necessária uma instância do FacesContextProducer
public class FacesContextProducer {
	
	@Produces //deve ser sempre usado qndo o processo de criação de um obj não é default
	@RequestScoped // get() deve ser chamado a cada request
	public FacesContext get(){ 
		return FacesContext.getCurrentInstance();
	}
}
//FacesContext é produzido a cada request, caso contrário pode acabar injetando uma isntância que foi populada
//com informações de outra requisição