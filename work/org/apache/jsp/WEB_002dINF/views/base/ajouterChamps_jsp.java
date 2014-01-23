/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2014-01-19 17:41:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public final class ajouterChamps_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function Choix(formulaire) {\r\n");
      out.write("\ti = formulaire.base.selectedIndex; //Index de la base choisi\r\n");
      out.write("\tvar nb = $(\"#nbBase\").attr(\"class\"); //Nombre de base\r\n");
      out.write("\tvar table= 0;\r\n");
      out.write("\t\r\n");
      out.write("\tif(i != 0){ //Si une base est choisie\r\n");
      out.write("\t\tfor(j=1; j<=nb; j++){ //On boucle autant de fois qu'il y a de bases\r\n");
      out.write("\t\t\tdocument.getElementById('table_'+j).style.display = 'none'; //On cache toutes les tables\r\n");
      out.write("\t\t\tif(j == i){ //Si une table correspond à une base\r\n");
      out.write("\t\t\t\tdocument.getElementById('table_'+i).style.display = 'block';1 //On l'affiche\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("$('#valider').click(function(){\r\n");
      out.write("\talert('.typeChamp');\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- MAIN -->\r\n");
      out.write("<div id=\"main\">\t\r\n");
      out.write("\t<div class=\"wrapper clearfix\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<h2 class=\"page-heading\"><span>");
      out.print( request.getAttribute("title") );
      out.write("</span></h2>\t\r\n");
      out.write("       \t\r\n");
      out.write("\t\t<!-- page content -->\r\n");
      out.write("       \t<div id=\"page-content\" class=\"clearfix\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<form action=\"ajouterChamps\" name=\"formulaire\" method=\"post\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t");
 
		       	String nomFichier = "C:\\Users\\Valeri\\workspace2\\XMLproject\\fileBIS.xml";
// 		       	String nomFichier = (String) session.getAttribute("fichier");
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				String nomUtilisateur = "Valerie";//A modifier par la variable de session
				
				if(!new File(nomFichier).exists()) //le fichier existe pas 
				{
				
      out.write(" Veuillez créer une base d'abord.");

				}else{
					Document doc = docBuilder.parse(nomFichier);
					Element e = doc.getDocumentElement();
					NodeList enfants =  e.getElementsByTagName("user");
				
					for (int i=0; i < enfants.getLength() ; i++) {
						Element el = (Element)enfants.item(i);
						if(el.hasAttribute("name")){
							
							if(el.getAttribute("name").equals(nomUtilisateur)){ 
								NodeList base =  el.getElementsByTagName("dataBase");
								int nombreDElementsEnfants = base.getLength();
								
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"nbBase\" class=\"");
      out.print( nombreDElementsEnfants );
      out.write("\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\tChoissisez une base:<select id=\"base\" name=\"base\" onChange='Choix(this.form)'>\r\n");
      out.write("\t\t\t\t\t\t\t\t<option selected>--- Choisissez une base ---</option>");

								for (int j=0; j < base.getLength() ; j++) {
									Element el1 = (Element)base.item(j);
									if(el1.hasAttribute("name")){
										
      out.write(" <option value=\"");
      out.print( el1.getAttribute("name") );
      out.write('_');
      out.print( j+1 );
      out.write('"');
      out.write('>');
      out.print( el1.getAttribute("name")  );
      out.write("</option> ");

									}
								}
								
      out.write("</select>");

								for (int k=0; k < base.getLength() ; k++) {
									Element el2 = (Element)base.item(k);
									if(el2.hasAttribute("name")){
										
      out.write(" \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div id=\"table_");
      out.print( k+1 );
      out.write("\" style=\"display:none;\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tChoissisez une table:<select id=\"table_");
      out.print( k+1 );
      out.write("\" name=\"table_");
      out.print( k+1 );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option selected>--- Choisissez une table ---</option>");

										NodeList tables = el2.getElementsByTagName("table");
										for (int l=0; l < tables.getLength(); l++){ // parcours les tables
											Element el3 = (Element)tables.item(l);
											if(el3.hasAttribute("name")){
												
      out.write(" <option value=\"");
      out.print( el3.getAttribute("name") );
      out.write('"');
      out.write('>');
      out.print( el3.getAttribute("name"));
      out.write("</option> ");

											}
										}
										
      out.write("</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>");

									}
								}
							}
						}
		       		}
		       	}
		       	
      out.write("\r\n");
      out.write("\t\t       \t\r\n");
      out.write("\t\t       \t</br>Nom du champ: \r\n");
      out.write("\t\t\t\t<input id=\"champ\" type=\"text\" name=\"champ\" >\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</br>Nom de la valeur: \r\n");
      out.write("\t\t\t\t<input id=\"valeur\" type=\"text\" name=\"valeur\" >\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t</br>Type de la valeur: \r\n");
      out.write("\t\t\t\t<select name=\"typeChamp\">\r\n");
      out.write("\t\t\t\t     <option value=\"varchar\" selected=\"selected\">Varchar</option>\r\n");
      out.write("\t\t\t\t     <option value=\"integer\" >integer</option>\r\n");
      out.write("\t\t\t\t     <option value=\"boolean\">boolean</option>\r\n");
      out.write("\t\t\t\t     <option value=\"dateTime\">Date Time</option>\r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</br>\r\n");
      out.write("\t\t       \t<input id=\"valider\" name=\"validerChamps\" type=\"submit\" value=\"Valider\">\r\n");
      out.write("\t\t\t</form>\t\t\t\r\n");
      out.write("\t\t</div>\t        \t\r\n");
      out.write("       \t<!--  page content-->\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- ENDS MAIN -->\r\n");
      out.write("\t\t");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
