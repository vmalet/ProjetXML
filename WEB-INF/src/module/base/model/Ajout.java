package module.base.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
	
	public void log(String action, String user, String objet) throws IOException
	{
//		FileWriter fw = new FileWriter ("C:\\Users\\Valeri\\workspace2\\XMLproject\\log.txt", true) ; 
		FileWriter writer = null;
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy"); 
		String texte = user+" à "+action +" "+ objet + " le: "+date.format(new Date()) +"\n";
		try{
		     writer = new FileWriter("C:\\Users\\Valeri\\workspace2\\XMLproject\\log.txt", true);
//		     writer = new FileWriter("log.txt", true);
		     writer.write(texte,0,texte.length());
		     System.out.println("Ecriture dans mon fichier ");
		}catch(IOException ex){
		    ex.printStackTrace();
		}finally{
		  if(writer != null){
		     writer.close();
		  }
		}
		
		
		/*File fichier = new File("../../../log.txt");
		if(!fichier.exists())
		{
			fichier.createNewFile();
		}else{
			System.out.println("le fichier existe");
		}*/
		
	}
	public void Ajouter(String base, String table, String champ, String valeur, String type) throws SAXException, IOException, ParserConfigurationException, TransformerException
	{
		
		String nomFichier = "C:\\Users\\Valeri\\workspace2\\XMLproject\\fileBIS.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc;
		Element user = null;
		String nomUtilisateur = "Valerie";
		// le fichier existe
		doc = docBuilder.parse(nomFichier);
			
        Element e = doc.getDocumentElement();
		NodeList enfants =  e.getElementsByTagName("user"); // recherche tous les enfants de "user"
			
		for (int i=0; i < enfants.getLength() ; i++) {//parcours tous les enfants de "user"
			Element el = (Element)enfants.item(i);
			if(el.hasAttribute("name")){
				if(el.getAttribute("name").equals(nomUtilisateur)){ //si l'utilisateur correspond à l'user connecté
					NodeList lesBases =  el.getElementsByTagName("dataBase");
					int nombreDElementsEnfants = lesBases.getLength();
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
				else{
					System.out.println("pas le meme nom");
				}
			}
		}
		
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(nomFichier);

		transformer.transform(source, result);
		System.out.println("File saved!");
	}

}
