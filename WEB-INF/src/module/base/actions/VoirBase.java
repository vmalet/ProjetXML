package module.base.actions;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class VoirBase implements IAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, TransformerException {
		HttpSession session = request.getSession();
		// TODO Auto-generated method stub
		System.out.println(session.getAttribute("utilisateur"));
		request.setAttribute("title", "Voir vos bases");
	}

}
