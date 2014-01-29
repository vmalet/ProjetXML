package module.base.actions;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import module.base.model.Ajout;

import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class ConvertionTxt implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, TransformerException,
			XPathExpressionException {
		// TODO Auto-generated method stub
		
		
		String valider = request.getParameter("validerConvertionTxt");
		if (request.getMethod().equals("POST") && !valider.isEmpty()) {
			
			HttpSession session = request.getSession();
			String destination = (String) session.getAttribute("destinationXMl");
			
			String base = request.getParameter("base");
			String[] temp = base.split(".xml");
			base = temp[0];
			// Ecriture du fichier TXT
			Ajout ajt = new Ajout();
        	ajt.créerFichierTxt(base, destination);

        	request.setAttribute("reussi", "Votre base "+ base + " a ete correctement convertie en un fichier texte" );
		}
		
		
		
		request.setAttribute("title", "Convertir une base en fichier txt");
	}

}
