package module.base.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import module.base.model.Ajout;

import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class AjouterTable implements IAction{

	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		
		String valider = request.getParameter("validerTable");
		if (request.getMethod().equals("POST") && !valider.isEmpty()) {
			System.out.println("Méthode POST");
			
			String base = request.getParameter("base");
	        String table = request.getParameter("nom");
	        
	        if(table.isEmpty() || base.isEmpty())
	        {
	        	request.setAttribute("rate", "Vous n'avez pas réussi à ajouter la table. Veuillez réessayer.");
	        	System.out.println("problème");
	        }else
	        {
	        	request.setAttribute("reussi", "Vous avez ajouter la table: "+ table);
	        	System.out.println("base: "+ base + "nom: "+table);
	        	// TODO appel de la fonction pour modifier le fichier XML 
	        	
//	        	Ajout ajt = new Ajout(base, table, "", "", "");
	        	Ajout ajt = new Ajout();
	        	ajt.Ajouter(base, table, "", "", "");
	        	String faire = " une table nommée "+table;
		    	ajt.log("créer", "valerie", faire);
	        }
		}
		
		request.setAttribute("title", "Ajouter une table");


	}
}
