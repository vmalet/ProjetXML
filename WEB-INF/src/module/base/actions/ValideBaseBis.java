package module.base.actions;

//import java.io.File;
//import java.io.IOException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import module.base.model.Ajout;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class ValideBaseBis implements IAction{

	@SuppressWarnings("deprecation")
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ParserConfigurationException, SAXException, IOException, TransformerException {
		// TODO Auto-generated method stub
		String base = request.getParameter("nomBase");
		String table1 = request.getParameter("nomTable");
		String champ1 = request.getParameter("champ1");
		String valeur1 = request.getParameter("valeur1");
		String typeChamp1 = request.getParameter("typeChamp1");
		String champ2 = request.getParameter("champ2");
		String valeur2 = request.getParameter("valeur2");
		String typeChamp2 = request.getParameter("typeChamp2");
		String champ3 = request.getParameter("champ3");
		String valeur3 = request.getParameter("valeur3");
		String typeChamp3 = request.getParameter("typeChamp3");
		String table2 = request.getParameter("nomTable2");
		String champ4 = request.getParameter("champ4");
		String valeur4 = request.getParameter("valeur4");
		String typeChamp4 = request.getParameter("typeChamp4");
		String champ5 = request.getParameter("champ5");
		String valeur5 = request.getParameter("valeur5");
		String typeChamp5 = request.getParameter("typeChamp5");
		String champ6 = request.getParameter("champ6");
		String valeur6 = request.getParameter("valeur6");
		String typeChamp6 = request.getParameter("typeChamp6");
		
		HttpSession session = request.getSession();
		String nomUtilisateur = (String) session.getAttribute("login");
		session.setAttribute("utilisateur", nomUtilisateur);

		if(base.isEmpty() || table1.isEmpty() || champ1.isEmpty() || valeur1.isEmpty() ||typeChamp1.isEmpty() || champ2.isEmpty()
				|| valeur2.isEmpty() || typeChamp2.isEmpty() || champ3.isEmpty() || valeur3.isEmpty() || typeChamp3.isEmpty()
				|| table2.isEmpty() || champ4.isEmpty() || valeur4.isEmpty() || typeChamp4.isEmpty() || champ5.isEmpty()
				|| valeur5.isEmpty() || typeChamp5.isEmpty() || champ6.isEmpty() || valeur6.isEmpty() || typeChamp6.isEmpty()){
			
			request.setAttribute("Erreur", "Veuillez remplir tous les champs s'il vous plait!");
			request.setAttribute("title", "Erreur");
			RequestDispatcher view = request.getRequestDispatcher("creerBase.jsp");
            /*try {
				view.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}else{
			String nomFichier = (String) session.getAttribute("leFichier");
			String fichierLog = (String) session.getAttribute("fichierLog");
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc;
			Element user = null;
			if(!new File(nomFichier).exists()) //le fichier existe pas 
			{
				System.out.println("Le fichier existe pas");
				// root elements
				doc = docBuilder.newDocument();
				Element rootElement = doc.createElement("users");
				doc.appendChild(rootElement);
				
				// user elements
				user = doc.createElement("user");
				rootElement.appendChild(user);
				// attribute user element
				Attr attrN = doc.createAttribute("name");
				attrN.setValue(nomUtilisateur);
				user.setAttributeNode(attrN);
			 
			}else{ // le fichier existe
				System.out.println ("Ce fichier existe déjà");
				doc = docBuilder.parse(nomFichier);
//				doc.getDocumentElement().normalize();
				
                Element e = doc.getDocumentElement();
				
				NodeList enfants =  e.getElementsByTagName("user");
				int nombreDElementsEnfants = enfants.getLength();
				System.out.println("nombre :" + nombreDElementsEnfants);
				
				boolean bool = false;
				for (int i=0; i < enfants.getLength() ; i++) {
					Element el = (Element)enfants.item(i);
					if(el.hasAttribute("name")){
						System.out.println("i: "+ i + " user: " + el.getAttribute("name").toString() + " nom Utilisateur: " + nomUtilisateur);
						/*PROBLEME A CETTE LIGNE */
						if(nomUtilisateur.equals(el.getAttribute("name"))){ 
							//Ne trouve pas de correspondance.
							bool = true;
							user = el;
							System.out.println("meme nom");
							break;
						}
						else{
							bool = false;
							System.out.println("pas le meme nom");
						}
					}
				}
				if(bool == false)
				{
					user = doc.createElement("user");
					e.appendChild(user);
					
					Attr attrN = doc.createAttribute("name");
					attrN.setValue(nomUtilisateur);
					user.setAttributeNode(attrN);
				}
//				user = doc.createElement("user");
			}
			
			//base
			Element dataBase = doc.createElement("dataBase");
			user.appendChild(dataBase);
			//attribut de base
			Attr attrB = doc.createAttribute("name");
			attrB.setValue(base);
			dataBase.setAttributeNode(attrB);
			//attribut de base
			Attr attrD = doc.createAttribute("dateC");
			DateFormat format = new SimpleDateFormat("dd/MM/yyyy"); 
			attrD.setValue(format.format(new Date()));
			dataBase.setAttributeNode(attrD);
			
			//table 1
			Element EleTable1 = doc.createElement("table");
			dataBase.appendChild(EleTable1);
			//attribut de table
			Attr attrT = doc.createAttribute("name");
			attrT.setValue(table1);
			EleTable1.setAttributeNode(attrT);
			
			//champ1
			Element EleChamp = doc.createElement("champ");
			EleTable1.appendChild(EleChamp);
			//attribut de champ1
			Attr attrC1 = doc.createAttribute("name");
			attrC1.setValue(champ1);
			EleChamp.setAttributeNode(attrC1);
			
			// Chhamp elements
			Element EleValeur1 = doc.createElement("valeur");
			EleValeur1.appendChild(doc.createTextNode(valeur1));
			EleChamp.appendChild(EleValeur1);
	 
			//Type champ elements
			Element typeValeur = doc.createElement("type");
			typeValeur.appendChild(doc.createTextNode(typeChamp1));
			EleChamp.appendChild(typeValeur);
	 
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(nomFichier);

			transformer.transform(source, result);
			System.out.println("File saved!");
			
			request.setAttribute("title", "Base cree!");
			
			Ajout ajt = new Ajout();
			String faire =" une base nommé "+base;
	    	ajt.log(fichierLog, "Créér", nomUtilisateur, faire);
		}
	
	}
	

}
