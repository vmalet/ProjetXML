package module.base.actions;

import java.io.File;
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

import module.base.model.Ajout;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class Supprimer implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		
		String base = request.getParameter("base");
		String table = request.getParameter("table");
		String action = request.getParameter("objet");
		String name = request.getParameter("nom");
		
		System.out.println("table: "+action+" nom: "+name);
		
		HttpSession session = request.getSession();
		String nomFichier = (String) session.getAttribute("leFichier");
		String fichierLog = (String) session.getAttribute("fichierLog");
		File file = new File(nomFichier);
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		
		
		String nomUtilisateur = (String) session.getAttribute("login");
		
		Document doc = docBuilder.parse(nomFichier);
		NodeList nodeList = null;

		nodeList = doc.getElementsByTagName(action);
		for (int j = 0; j < nodeList.getLength(); j++) {//Parcours tous 
			Node nodeCourant = nodeList.item(j);
			if(nodeCourant.getNodeType() == Node.ELEMENT_NODE){//S'il s'agit d'un Element
				if(nodeCourant.getAttributes().getNamedItem("name").getNodeValue().equals(name)){//Si correspond au choix
					Element elNode = (Element) nodeCourant;
					System.out.println("Node en cours: "+nodeCourant.getAttributes().getNamedItem("name").getNodeValue());
					//Remove Valeur et Type
					if(action.equals("table"))
					{
						//Parcours tous les champs
						NodeList listNodeEnfant = nodeCourant.getChildNodes();
						for (int k = 0; k < listNodeEnfant.getLength(); k++) {//Parcours tous ces champs
							Node nodeEnfant = listNodeEnfant.item(k);
							if(nodeEnfant.getNodeType() == Node.ELEMENT_NODE){//S'il s'agit d'un Element
								Element elEnfant = (Element) nodeEnfant;
								System.out.println("Champ: "+nodeEnfant.getAttributes().getNamedItem("name").getNodeValue());
								//Remove Valeur et Type
								Node removeValeur = elEnfant.getElementsByTagName("valeur").item(0);
								nodeEnfant.removeChild(removeValeur);
								Node removeType = elEnfant.getElementsByTagName("type").item(0);
								nodeEnfant.removeChild(removeType);
								elEnfant.getParentNode().removeChild(elEnfant);
							}
						}
						elNode.getParentNode().removeChild(elNode);//remove table
					}else if(action.equals("champ"))
					{
						System.out.println("Suppression d'un champ");
						Node removeValeur = elNode.getElementsByTagName("valeur").item(0);
						nodeCourant.removeChild(removeValeur);
						Node removeType = elNode.getElementsByTagName("type").item(0);
						nodeCourant.removeChild(removeType);
						elNode.getParentNode().removeChild(elNode);
					}else if(action.equals("dataBase"))
					{
						//Parcours tous les champs
						NodeList listNodeEnfant = nodeCourant.getChildNodes();
						for (int k = 0; k < listNodeEnfant.getLength(); k++) {//Parcours tous ces champs
							Node nodeEnfant = listNodeEnfant.item(k);
							if(nodeEnfant.getNodeType() == Node.ELEMENT_NODE){//S'il s'agit d'un Element
								Element elEnfant = (Element) nodeEnfant;
								System.out.println("table: "+nodeEnfant.getAttributes().getNamedItem("name").getNodeValue());
								NodeList listNodeChild = nodeEnfant.getChildNodes();
								for (int l = 0; l < listNodeChild.getLength(); l++) {//Parcours tous ces champs
									Node nodeChlid = listNodeChild.item(l);
									if(nodeChlid.getNodeType() == Node.ELEMENT_NODE){//S'il s'agit d'un Element
										Element elChild = (Element) nodeChlid;
										System.out.println("table: "+nodeChlid.getAttributes().getNamedItem("name").getNodeValue());
										elChild.getParentNode().removeChild(elChild);
									}
								}
								elEnfant.getParentNode().removeChild(elEnfant);
							}
						}
						elNode.getParentNode().removeChild(elNode);
					}
					
				}
			}
		}
		
        Element e = doc.getDocumentElement();
        NodeList enfants =  e.getElementsByTagName(action);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(nomFichier);

        transformer.transform(source, result);
        System.out.println("File saved!");
        
        Ajout ajt = new Ajout();
        String faire = action+" nomme "+name; 
    	ajt.log(fichierLog, "Supprimer", nomUtilisateur, faire);
    	
    	
        request.setAttribute("title", "Suppression reussi");
		request.setAttribute("succes", "Vous avez correctement supprimer le/la "+ action +" nomme "+name);
	}
}
