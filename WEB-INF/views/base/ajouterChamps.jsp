<script type="text/javascript">
function Choix(formulaire) {
	i = formulaire.base.selectedIndex; //Index de la base choisi
	var nb = $("#nbBase").attr("class"); //Nombre de base
	var table= 0;
	
	if(i != 0){ //Si une base est choisie
		for(j=1; j<=nb; j++){ //On boucle autant de fois qu'il y a de bases
			document.getElementById('table_'+j).style.display = 'none'; //On cache toutes les tables
			if(j == i){ //Si une table correspond à une base
				document.getElementById('table_'+i).style.display = 'block';1 //On l'affiche
			}
		}
	}
}

$('#valider').click(function(){
	alert('.typeChamp');
	
});
</script>

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

			<form action="ajouterChamps" name="formulaire" method="post">
			
				<% 
				String nomFichier = (String) session.getAttribute("leFichier");
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
								Choissisez une base:<select id="base" name="base" onChange='Choix(this.form)'>
								<option selected>--- Choisissez une base ---</option><%
								for (int j=0; j < base.getLength() ; j++) {
									Element el1 = (Element)base.item(j);
									if(el1.hasAttribute("name")){
										%> <option value="<%= el1.getAttribute("name") %>_<%= j+1 %>"><%= el1.getAttribute("name")  %></option> <%
									}
								}
								%></select><%
								for (int k=0; k < base.getLength() ; k++) {
									Element el2 = (Element)base.item(k);
									if(el2.hasAttribute("name")){
										%> 
										<div id="table_<%= k+1 %>" style="display:none;">
										Choissisez une table:<select id="table_<%= k+1 %>" name="table_<%= k+1 %>">
										<option selected>--- Choisissez une table ---</option><%
										NodeList tables = el2.getElementsByTagName("table");
										for (int l=0; l < tables.getLength(); l++){ // parcours les tables
											Element el3 = (Element)tables.item(l);
											if(el3.hasAttribute("name")){
												%> <option value="<%= el3.getAttribute("name") %>"><%= el3.getAttribute("name")%></option> <%
											}
										}
										%></select>
										</div><%
									}
								}
							}
						}
		       		}
		       	}
		       	%>
		       	
		       	</br>Nom du champ: 
				<input id="champ" type="text" name="champ" >
				
				</br>Nom de la valeur: 
				<input id="valeur" type="text" name="valeur" >
				
				</br>Type de la valeur: 
				<select name="typeChamp">
				     <option value="varchar" selected="selected">Varchar</option>
				     <option value="integer" >integer</option>
				     <option value="boolean">boolean</option>
				     <option value="dateTime">Date Time</option>
				</select>
				</br>
		       	<input id="valider" name="validerChamps" type="submit" value="Valider">
			</form>			
		</div>	        	
       	<!--  page content-->
	</div>
</div>
<!-- ENDS MAIN -->
		