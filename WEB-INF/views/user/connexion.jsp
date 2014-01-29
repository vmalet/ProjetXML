 <%@ page import="java.net.HttpURLConnection" %>
 
 <!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
		<h2 class="page-heading"><span>CONNEXION </span></h2>	
       	
		<!-- page content -->
       	<div id="page-content" class="clearfix">
			
			<% 
			String login = (String) request.getAttribute("login");
			session.setAttribute("login", login);
			session.setAttribute("leFichier", "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\fileBIS.xml");
			session.setAttribute("destinationXMl", "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\base\\"); //Ne pas oublié les double anti slash de la fin
			session.setAttribute("fichierLog", "C:\\Users\\Valeri\\workspace2\\XMLproject\\fichier\\log.txt");
			
			%>
			Bienvenue <%= session.getAttribute("login") %>
        	<div class="clearfix"></div>
			<!-- ENDS contact-sidebar -->
			
		</div>	        	
       	<!--  page content-->
       	
	</div>
</div>
<!-- ENDS MAIN -->
		