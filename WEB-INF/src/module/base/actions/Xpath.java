package module.base.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class Xpath implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, TransformerException, XPathExpressionException {
		// TODO Auto-generated method stub

		String valider = request.getParameter("validerXpath");
		if (request.getMethod().equals("POST") && !valider.isEmpty()) {
		
			String xpath = request.getParameter("xpath");
			FileInputStream file = new FileInputStream(new File("C:\\Users\\Valeri\\workspace2\\XMLproject\\fileBIS.xml"));
	        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder =  builderFactory.newDocumentBuilder();
	        Document xmlDocument = builder.parse(file);
	        XPath xPath =  XPathFactory.newInstance().newXPath();
	
	        System.out.println("*************************");
//	        String expression = "/users/user/dataBase/table/champ/valeur";
	        System.out.println(xpath);
	        NodeList nodeList = (NodeList) xPath.compile(xpath).evaluate(xmlDocument, XPathConstants.NODESET);
	        String reponse = "";
	        for (int i = 0; i < nodeList.getLength(); i++) {
	            System.out.println(nodeList.item(i).getFirstChild().getNodeValue()); 
	            reponse = reponse +", "+ nodeList.item(i).getFirstChild().getNodeValue();
	        }
	        request.setAttribute("resultat",reponse);
		}
        request.setAttribute("title", "Champ de saisie XPATH");
        
	}

}
