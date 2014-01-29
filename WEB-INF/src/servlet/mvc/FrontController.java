package servlet.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import module.base.actions.AjouterChamp;
import module.base.actions.AjouterTable;
import module.base.actions.Connexion;
import module.base.actions.ConvertionTxt;
import module.base.actions.ConvertionXML;
import module.base.actions.CreerBase;
import module.base.actions.ModifierBase;
import module.base.actions.Supprimer;
import module.base.actions.ValideBaseBis;
import module.base.actions.VoirBase;
import module.base.actions.Xpath;

import org.xml.sax.SAXException;

public class FrontController extends HttpServlet {
	
	Map<String, IAction> actions = new HashMap<>();
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		actions.put("base/creerBase", new CreerBase());
		actions.put("base/valideBaseTotal", new ValideBaseBis());
		actions.put("base/voirBase", new VoirBase());
		actions.put("base/modifierBase", new ModifierBase());
		actions.put("base/ajouterTable", new AjouterTable());
		actions.put("base/ajouterChamps", new AjouterChamp());
		actions.put("base/supprimer", new Supprimer());
		actions.put("base/saisieXPATH", new Xpath());
		actions.put("base/XMLversTxt", new ConvertionTxt());
		actions.put("base/baseVersXML", new ConvertionXML());
		actions.put("user/connexion", new Connexion());
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request
				 .getRequestURI()
				 .substring(request.getContextPath().length()+1);

		if (url.trim().isEmpty()) {
			url = "index";
		}
		System.out.println(url);

		IAction action = actions.get(url);
		if (null != action)
			try {
				try {
					action.execute(request, response);
				} catch (TransformerConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (XPathExpressionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		request
		.getRequestDispatcher(url.endsWith(".ajax") ? "/WEB-INF/views/"+url+".jsp" : "/layout.jsp")
		.include(request, response);

	}

}
