<!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
<!-- 		<h2 class="page-heading"><span>Formulaire de creation de base de donnees</span></h2>	 -->
		<h2 class="page-heading"><span><%= request.getAttribute("title") %></span></h2>
		<!-- page content -->
       	<div id="page-content" class="clearfix">
       	<%= request.getAttribute("Erreur") %>
       	<span><%= request.getAttribute("reussi") %></span>
       	
       		<form method="post" action="creerBase">
       			</br>Nom de la base: 
				<input id="base" type="text" name="base" >
				
				</br>
				<input id="valider" name="validerBase" type="submit" value="Valider">
       		</form>
       		
        	<div class="clearfix"></div>
			<!-- ENDS contact-sidebar -->
			
		</div>	        	
       	<!--  page content-->

	</div>
</div>
<!-- ENDS MAIN -->
		