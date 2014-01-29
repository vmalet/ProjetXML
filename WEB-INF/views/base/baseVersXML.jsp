<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>
<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="org.w3c.dom.Document" %>
<%@ page import="org.w3c.dom.NodeList" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="java.io.File" %>

<!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
		<h2 class="page-heading"><span><%= request.getAttribute("title") %></span></h2>	
       	
		<!-- page content -->
       	<div id="page-content" class="clearfix">
			
		<%= request.getAttribute("succes") %>
		<%= request.getAttribute("rate") %>
		<form action="baseVersXML" method="POST">
			<% 
			String nomFichier = (String) session.getAttribute("leFichier");
// 		       	String nomFichier = "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\fileBIS.xml";
				DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
				String nomUtilisateur = (String) session.getAttribute("login");
				
				if(!new File(nomFichier).exists()) //le fichier existe pas 
				{
				%> Veuillez créer une base d'abord.<%
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
								%>
								<div id="nbBase" class="<%= nombreDElementsEnfants %>"></div>
								Choissisez une base:<select id="base" name="base"'>
								<option selected>--- Choisissez une base ---</option><%
								for (int j=0; j < base.getLength() ; j++) {
									Element el1 = (Element)base.item(j);
									if(el1.hasAttribute("name")){
										%> <option value="<%= el1.getAttribute("name") %>"><%= el1.getAttribute("name")  %></option> <%
									}
								}
								%></select><%
							}
						}
					}
				}
				%>
				<div class="clearfix"></div>
				<input id="validerConvertionXml" name="validerConvertionXml" type="submit" value="Valider">
	        	<div class="clearfix"></div>
        	</form>
			<!-- ENDS contact-sidebar -->
			
		</div>	        	
       	<!--  page content-->
       	
	</div>
</div>
<!-- ENDS MAIN -->
		