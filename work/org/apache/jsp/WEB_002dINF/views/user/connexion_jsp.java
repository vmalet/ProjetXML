/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.30
 * Generated at: 2014-01-28 15:35:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.net.HttpURLConnection;

public final class connexion_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" <!-- MAIN -->\r\n");
      out.write("<div id=\"main\">\t\r\n");
      out.write("\t<div class=\"wrapper clearfix\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<h2 class=\"page-heading\"><span>CONNEXION </span></h2>\t\r\n");
      out.write("       \t\r\n");
      out.write("\t\t<!-- page content -->\r\n");
      out.write("       \t<div id=\"page-content\" class=\"clearfix\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
 
			String login = (String) request.getAttribute("login");
			session.setAttribute("login", login);
			session.setAttribute("leFichier", "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\fileBIS.xml");
			session.setAttribute("destinationXMl", "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\base\\"); //Ne pas oublié les double anti slash de la fin
			session.setAttribute("fichierLog", "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\log.txt");
			
			
      out.write("\r\n");
      out.write("\t\t\tBienvenue ");
      out.print( session.getAttribute("login") );
      out.write("\r\n");
      out.write("        \t<div class=\"clearfix\"></div>\r\n");
      out.write("\t\t\t<!-- ENDS contact-sidebar -->\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\t        \t\r\n");
      out.write("       \t<!--  page content-->\r\n");
      out.write("       \t\r\n");
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
