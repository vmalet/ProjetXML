<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<%@ page import="javax.xml.parsers.DocumentBuilder" %>
<%@ page import="javax.xml.parsers.DocumentBuilderFactory" %>
<%@ page import="org.w3c.dom.Document" %>
<%@ page import="org.w3c.dom.NodeList" %>
<%@ page import="org.w3c.dom.Node" %>
<%@ page import="org.w3c.dom.Element" %>
<%@ page import="java.io.File" %>


<!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
		<h2 class="page-heading"><span><%= request.getAttribute("title") %></span></h2>	
       	
		<!-- page content -->
       	<div id="page-content" class="clearfix">
			
			<%
// 			String nomFichier = "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\fileBIS.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			String nomUtilisateur = (String) session.getAttribute("login");
			String nomFichier = (String) session.getAttribute("leFichier");
			if(!new File(nomFichier).exists()) //le fichier existe pas 
			{
			%> Aucune base existante <%
			}else{
				Document doc = docBuilder.parse(nomFichier);
				Element e = doc.getDocumentElement();
				NodeList enfants =  e.getElementsByTagName("user");
			
				for (int i=0; i < enfants.getLength() ; i++) {
					Element el = (Element)enfants.item(i);
					if(el.hasAttribute("name")){ %>
						</br>
						<% if(el.getAttribute("name").equals(nomUtilisateur)){ 
							NodeList base =  el.getElementsByTagName("dataBase");
							int nombreDElementsEnfants = base.getLength();%>
							<%= el.getAttribute("name").toString() %> as <%= nombreDElementsEnfants %> base</br></br>
							<% for (int j=0; j < base.getLength() ; j++) {
								Element el1 = (Element)base.item(j);
								if(el1.hasAttribute("name")){
									%></br>Nom de la base: <%= el1.getAttribute("name") %>
									La base a ete creer <%= el1.getAttribute("dateC") %> par <%=el.getAttribute("name")%>
									<a href="<%= request.getContextPath() %>/base/supprimer?objet=dataBase&nom=<%= el1.getAttribute("name") %>">SUP</a>
									<table class="bddtable"> 
										<tr>
											<th id="table" >Nom de la table</th>
											<th id="champs">Nom des champs</th>
											<th id="valeur">Nom des valeurs</th>
											<th id="type">Types des valeurs</th>
										</tr>
										<% NodeList table = el1.getElementsByTagName("table");
										int nbTable = table.getLength();
										for (int k=0; k < table.getLength(); k++){ // parcours les tables
											Element el2 = (Element)table.item(k);
											NodeList lesEnfantsC =  e.getElementsByTagName("champ");
											if(el2.hasAttribute("name")){
												NodeList champs = el2.getElementsByTagName("champ");
												int nbChamps = champs.getLength();
												%><tr><td rowspan='<%= nbChamps %>'><%= el2.getAttribute("name") %>
												<a href="<%= request.getContextPath() %>/base/supprimer?objet=table&nom=<%= el2.getAttribute("name") %>">SUP</a>
												</td>
												<% for (int l=0; l < champs.getLength(); l++){
													Element el3 = (Element)champs.item(l);
													if(el3.hasAttribute("name")){ %>
														<td><%= el3.getAttribute("name") %></td>
														<% NodeList sousElements = el3.getChildNodes();
														for (int m = 0; m < sousElements.getLength(); m++) {
											                Node child = sousElements.item(m);
											                if (child instanceof Element)
											                    %><td><%= sousElements.item(m).getTextContent() %></td><%
											            }
														%>
														<td><a href="<%= request.getContextPath() %>/base/supprimer?objet=champ&nom=<%= el3.getAttribute("name") %>">SUP</a></td>
														</tr><%
													}
												}
											}
										}
										%>
									</table>
									<%
								}
							}
						}
					}
				}
			}
			%>
			
        	<div class="clearfix"></div>
			<!-- ENDS contact-sidebar -->
		</div>	        	
       	<!--  page content-->
	</div>
</div>
<!-- ENDS MAIN -->