package module.base.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ajout {

	private String type; 
	
	private String base;
	
	private String table;
	
	private String champ;
	
	private String valeur;

	private String action;
	
	private String user;
	
	private String objet;
	
	public Ajout(String base, String table, String champ, String valeur,
			String type, String action, String user, String objet) {
		super();
		this.type = type;
		this.base = base;
		this.table = table;
		this.champ = champ;
		this.valeur = valeur;
		this.user = user;
		this.action = action;
		this.objet = objet;
	}

	public Ajout() {
		super();
	}
	
	public void créerFichierTxt(String fichier, String destination) throws ParserConfigurationException, SAXException, IOException
	{
		String nomFichier = destination + fichier + ".xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc;
		
		FileWriter writer = null;
		//Parcours de tous le noeud de la base pour écrire le fichier texte
		if(new File(nomFichier).exists()) //le fichier existe pas 
		{
			new FileWriter(new File(destination + fichier + ".txt")).close();
		}
		try{
			writer = new FileWriter(destination + fichier + ".txt", true);
			String texte = "";
			writer.write(texte,0,texte.length()); //ecriture du fichier texte //Base
			
			doc = docBuilder.parse(nomFichier);
			Element e = doc.getDocumentElement();
			NodeList enfants =  e.getElementsByTagName("user");
		
			for (int i=0; i < enfants.getLength() ; i++) {
				Element el = (Element)enfants.item(i);
				if(el.hasAttribute("name")){
					texte = "Utilisateur: "+ el.getAttribute("name")+"\n";
					writer.write(texte,0,texte.length()); //ecriture du fichier texte //Utilisateur
					NodeList base =  el.getElementsByTagName("dataBase");
					int nombreDElementsEnfants = base.getLength();
					for (int j=0; j < base.getLength() ; j++) {
						Element el1 = (Element)base.item(j);
						if(el1.hasAttribute("name")){
							texte = "Base: "+ el1.getAttribute("name")+"\n";
							writer.write(texte,0,texte.length()); //ecriture du fichier texte //Base
							NodeList table = el1.getElementsByTagName("table");
							int nbTable = table.getLength();
							for (int k=0; k < table.getLength(); k++){ // parcours les tables
								Element el2 = (Element)table.item(k);
								NodeList lesEnfantsC =  e.getElementsByTagName("champ");
								if(el2.hasAttribute("name")){
									texte = "table: "+el2.getAttribute("name")+"\n";
									writer.write(texte,0,texte.length());//ecriture du fichier texte //Table
									NodeList champs = el2.getElementsByTagName("champ");
									int nbChamps = champs.getLength();
									for (int l=0; l < champs.getLength(); l++){
										Element el3 = (Element)champs.item(l);
										if(el3.hasAttribute("name")){ 
											texte = "champs: "+el3.getAttribute("name")+"\n";
											writer.write(texte,0,texte.length());//ecriture du fichier texte //Champ
											NodeList sousElements = el3.getChildNodes();
											for (int m = 0; m < sousElements.getLength(); m++) {
								                Node child = sousElements.item(m);
								                if (child instanceof Element)
								                	if(sousElements.item(m).getNodeName().equals("type"))
								                	{
								                		texte = "Type: "+ sousElements.item(m).getTextContent()+"\n";
														writer.write(texte,0,texte.length());//ecriture du fichier texte //Valeur et & type	
								                	}else if(sousElements.item(m).getNodeName().equals("valeur")){
								                		texte = "Valeur: "+ sousElements.item(m).getTextContent()+"\n";
														writer.write(texte,0,texte.length());//ecriture du fichier texte //Valeur et & type	
								                	}
								                    sousElements.item(m).getTextContent();
								                	
								            }
										}
									}
								}
							}
						}
					}
				}
			}
		}catch(IOException ex){
		    ex.printStackTrace();
		}finally{
		  if(writer != null){
		     writer.close();
		  }
		}
		
	}
	public void log(String fichier, String action, String user, String objet) throws IOException
	{
		FileWriter writer = null;
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy"); 
		String texte = user+" à "+action +" "+ objet + " le: "+date.format(new Date()) +"\n";
		try{
		     writer = new FileWriter(fichier, true);
		     writer.write(texte,0,texte.length());
		     System.out.println("Ecriture dans mon fichier ");
		}catch(IOException ex){
		    ex.printStackTrace();
		}finally{
		  if(writer != null){
		     writer.close();
		  }
		}
		
	}
	public void Ajouter(String nomFichier, String nomUtl, String base, String table, String champ, String valeur, String type) throws SAXException, IOException, ParserConfigurationException, TransformerException
	{
		
//		nomFichier = "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\fileBIS.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc;
		Element user = null;
		String nomUtilisateur = nomUtl;
		// le fichier existe
		doc = docBuilder.parse(nomFichier);
			
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
		 
		}else{
			System.out.println ("Ce fichier existe déjà");
			doc = docBuilder.parse(nomFichier);
//			doc.getDocumentElement().normalize();
			
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
						System.out.println(nomUtilisateur);
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
		}
//        Element e = doc.getDocumentElement();
//		NodeList enfants =  e.getElementsByTagName("user"); // recherche tous les enfants de "user"
			
//		for (int i=0; i < enfants.getLength() ; i++) {//parcours tous les enfants de "user"
//			Element el = (Element)enfants.item(i);
//			if(el.hasAttribute("name")){
//				if(el.getAttribute("name").equals(nomUtilisateur)){ //si l'utilisateur correspond à l'user connecté
					NodeList lesBases =  user.getElementsByTagName("dataBase");
					int nombreDElementsEnfants = lesBases.getLength();
					if(!base.isEmpty() && table.isEmpty()){ //On ajoute une base
						System.out.println("On va créer une base");
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
					}else{
						for (int j=0; j < lesBases.getLength() ; j++) { //parcours toutes les bases de l'utilisateur connecté
							Element el1 = (Element)lesBases.item(j);
							if(el1.hasAttribute("name")){
								if(el1.getAttribute("name").equals(base)){ // Si la base choisi correspond
									if(champ.isEmpty() && valeur.isEmpty() && !table.isEmpty()){ //Si on veux ajouter une table
										//table 1
										Element EleTable1 = doc.createElement("table");
										el1.appendChild(EleTable1);
										//attribut de table
										Attr attrT = doc.createAttribute("name");
										attrT.setValue(table);
										EleTable1.setAttributeNode(attrT);
									}else{
										NodeList lesTables = el1.getElementsByTagName("table");
										for (int k=0; k < lesTables.getLength(); k++){ // parcours les tables
											Element el2 = (Element)lesTables.item(k);
											if(el2.hasAttribute("name")){
												if(el2.getAttribute("name").equals(table)){ // Si la table correspond
													if(!champ.isEmpty() && !valeur.isEmpty()){ //Si les champs ne sont pas vide
														
														Element EleChamp = doc.createElement("champ");
														el2.appendChild(EleChamp);
														//attribut de champ1
														Attr attrC1 = doc.createAttribute("name");
														attrC1.setValue(champ);
														EleChamp.setAttributeNode(attrC1);
														
														// Chhamp elements
														Element EleValeur1 = doc.createElement("valeur");
														EleValeur1.appendChild(doc.createTextNode(valeur));
														EleChamp.appendChild(EleValeur1);
												 
														//Type champ elements
														Element typeValeur = doc.createElement("type");
														typeValeur.appendChild(doc.createTextNode(type));
														EleChamp.appendChild(typeValeur);
														
													}
												}
											}
										}
									}
								}
							}
						}
					}
//				}
//				else{
//					System.out.println("pas le meme nom");
//				}
//			}
//		}
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(nomFichier);

		transformer.transform(source, result);
		System.out.println("File saved!");
	}

}
