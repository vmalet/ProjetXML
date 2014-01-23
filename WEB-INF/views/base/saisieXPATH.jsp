<!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
		<h2 class="page-heading"><span><%= request.getAttribute("title") %></span></h2>	
       	
		<!-- page content -->
       	<div id="page-content" class="clearfix">
			
			<form action="<%= request.getContextPath() %>/base/saisieXPATH" method="post">
				Champ de saisie Xpath: <input id="xpath" name="xpath" class="xpath"/>
<!-- 				<div class="clearfix"></div> -->
				 <input type="submit" value="Valider" class="xpath" name="validerXpath"/>
			</form>
					
			<% if (request.getAttribute("resultat") == "null") { %>
				aucun reusltat
			<% } else { %>
				<%= request.getAttribute("resultat") %>
			<% } %>
        	<div class="clearfix"></div>
			<!-- ENDS contact-sidebar -->
			
		</div>	        	
       	<!--  page content-->
       	
       	

       	
	</div>
</div>
<!-- ENDS MAIN -->
		