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

public class AjouterChamp implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, TransformerException {
		// TODO Auto-generated method stub
	
		String valider = request.getParameter("validerChamps");
		if (request.getMethod().equals("POST") && !valider.isEmpty()) {
			System.out.println("Méthode POST");
			
			String base = request.getParameter("base");
			String[] temp = base.split("_");
			base = temp[0];
	        String table = request.getParameter("table_"+temp[1]);
	        String champ = request.getParameter("champ");
	        String valeur = request.getParameter("valeur");
	        String type = request.getParameter("typeChamp");
	        
	        if(table.isEmpty() || base.isEmpty() || champ.isEmpty() || valeur.isEmpty() || type.isEmpty())
	        {
	        	request.setAttribute("rate", "Vous n'avez pas réussi à ajouter la table. Veuillez réessayer.");
	        	System.out.println("problème");
	        }else
	        {
	        	request.setAttribute("reussi", "Vous avez ajouter un champ: "+ champ+" qui a pour valeur"+valeur+" de type"+type);
	        	System.out.println("base: "+ base + " nom: "+table+ " champ: "+champ+" valeur: "+valeur+" type: "+type);
	        	// TODO appel de la fonction pour modifier le fichier XML 
	        	
	        	Ajout ajt = new Ajout();
	        	ajt.Ajouter(base, table, champ, valeur, type);
	        	String faire = "un champ nommé: "+champ;
	        	ajt.log("creer", "valerie", faire);
	        	
	        }
		}else{
			System.out.println("PAR LA ");
		}
		
		request.setAttribute("title", "Ajouter des champs");
	}

}
