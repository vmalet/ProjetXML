package module.base.actions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import servlet.mvc.IAction;

public class Connexion implements IAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ParserConfigurationException, SAXException, IOException,
			TransformerConfigurationException, TransformerException,
			XPathExpressionException {

		String login = request.getParameter("username");
		String password = request.getParameter("password");
//		String postParameters = "username="+login+"&password="+password;
//		
//		URL url = new URL("http://localhost/XML/WebService/Client.php");
//		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//		
//        urlConnection.setRequestMethod("POST");
//        urlConnection.setDoInput(true);
//        urlConnection.setDoOutput(true);
//        urlConnection.connect();
//
//        if(urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK)
//        {
//        	System.out.println(urlConnection.getResponseMessage());
//        	System.out.println("LA");
//        	
//        	 request.setAttribute("login", login);
//        	 request.setAttribute("password", password);
//        }

		String urlParameters = "username="+login+"&password="+password;
		URL url = new URL("http://localhost/XML/WebService/Client.php");
		URLConnection conn = url.openConnection();

		conn.setDoOutput(true);

		OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());

		writer.write(urlParameters);
		writer.flush();

		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		while ((line = reader.readLine()) != null) {
		    System.out.println(line);
		}
		writer.close();
		reader.close();    
		request.setAttribute("login", login);
		request.setAttribute("password", password);
        
        
	}

}
