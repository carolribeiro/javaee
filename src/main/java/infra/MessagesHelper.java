package infra;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@ApplicationScoped
public class MessagesHelper {
	
	@Inject
	private FacesContext facesContext;

	public void addFlash(FacesMessage facesMessage) {
		facesContext.getExternalContext().getFlash().setKeepMessages(true); // mantem as msgs ate o prox request
		facesContext.addMessage("messages",facesMessage);
	}
}
