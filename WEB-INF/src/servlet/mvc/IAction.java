package servlet.mvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public interface IAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException, XPathExpressionException;
}
