package module.base.actions;

//import java.io.File;
//import java.io.IOException;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import module.base.model.Ajout;

import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class CreerBase implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		
		String valider = request.getParameter("validerBase");
		if (request.getMethod().equals("POST") && !valider.isEmpty()) {
			System.out.println("M�thode POST");
			
			HttpSession session = request.getSession();
			String nomUtilisateur = (String) session.getAttribute("login");
			String nomFichier = (String) session.getAttribute("leFichier");
			String fichierLog = (String) session.getAttribute("fichierLog");
			String base = request.getParameter("base");
	        
	        if(base.isEmpty())
	        {
	        	request.setAttribute("rate", "Vous n'avez pas r�ussi � ajouter la table. Veuillez r�essayer.");
	        	System.out.println("probl�me");
	        }else
	        {
	        	request.setAttribute("reussi", "Vous avez creer la base: "+ base);
	        	System.out.println("base: "+ base);
	        	// TODO appel de la fonction pour modifier le fichier XML 
	        	
//	        	Ajout ajt = new Ajout(base, table, "", "", "");
	        	Ajout ajt = new Ajout();
	        	ajt.Ajouter(nomFichier, nomUtilisateur, base, "", "", "", "");
	        	String faire = " une table nomm�e "+base;
		    	ajt.log(fichierLog, "cr�er", nomUtilisateur, faire);
	        }
		}
		
		request.setAttribute("title", "Creer une base");
		request.setAttribute("succes", "Base cree");
		
	}
	

}
