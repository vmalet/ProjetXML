package module.base.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathExpressionException;

import module.base.model.Ajout;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class ConvertionXML implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, TransformerException,
			XPathExpressionException {
		// TODO Auto-generated method stub
		
		
		String valider = request.getParameter("validerConvertionXml");
		if (request.getMethod().equals("POST") && !valider.isEmpty()) {
			System.out.println("Méthode POST");
			
			String nomBase = request.getParameter("base");
	        
	        if(nomBase.isEmpty())
	        {
	        	request.setAttribute("rate", "Vous n'avez pas réussi à convertir la base en XML. Veuillez réessayer.");
	        	System.out.println("problème");
	        }else
	        {
	        	HttpSession session = request.getSession();
	        	String nomFichierBase = (String) session.getAttribute("destinationXMl");
	        	String fichierLog = (String) session.getAttribute("fichierLog");
	        	nomFichierBase = nomFichierBase + nomBase + ".xml";
	        	
//	        	String nomFichierBase = "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\base\\"+nomBase+".xml";
				
	        	DocumentBuilderFactory docFactoryBis = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilderBis = docFactoryBis.newDocumentBuilder();
				Document docBase = null;
				
				System.out.println("nom fichier :"+nomFichierBase);
				
				String nomFichier = (String) session.getAttribute("leFichier");
	    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	    		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
	    		Document doc;
	    		
				String nomUtilisateur = (String) session.getAttribute("login");
	    		// le fichier existe
	    		doc = docBuilder.parse(nomFichier);
	    			
	            Element e = doc.getDocumentElement();
	    		NodeList base =  e.getElementsByTagName("dataBase"); // recherche tous les enfants de "user"
	    			
	    		for (int i=0; i < base.getLength() ; i++) {//parcours toutes les "dataBase"
	    			Element el = (Element)base.item(i);
	    			Node nodeEnfant = base.item(i);
	    			if(el.hasAttribute("name")){ //Si c'est un élement
	    				if(el.getAttribute("name").equals(nomBase)){ //si la base[i] correspond a la base selectionné
	    					//NodeList lesBases =  el.getElementsByTagName("dataBase"); 
	    					System.out.println("Base choisi: "+el.getAttribute("name"));
	    					System.out.println(nodeEnfant.getAttributes().getNamedItem("name").getNodeValue());
	    					
    						System.out.println("Le fichier existe pas");
    						// root elements
    						docBase = docBuilderBis.newDocument();
    						Element rootElement = docBase.createElement("users");
    						docBase.appendChild(rootElement);
    						
    						// user elements
    						Element user = docBase.createElement("user");
    						rootElement.appendChild(user);
    						
    						Attr attrN = docBase.createAttribute("name");
    						attrN.setValue(nomUtilisateur);
    						user.setAttributeNode(attrN);
//	    						
    						Node node = nodeEnfant; //noeud a importer
	    					node = docBase.importNode(node, true);
	    					user.appendChild(node);
	    				}
	    			}
	    		}
	    		TransformerFactory transformerFactory = TransformerFactory.newInstance();
	    		Transformer transformer = transformerFactory.newTransformer();
	    		DOMSource source = new DOMSource(docBase);
	    		StreamResult result = new StreamResult(nomFichierBase);
	    		transformer.transform(source, result);
	    		
	        	request.setAttribute("succes", "Vous avez reussi a convertir la base "+ nomBase +" en XML.");
	        	
	        	Ajout ajt = new Ajout();
	        	String faire = "la base nommé "+nomBase+" en XML.";
	        	ajt.log(fichierLog, "convertie", nomUtilisateur, faire);
	        	
	        }
		}
		
		request.setAttribute("title", "Convertir une base en un fichier XML");
	}

}
