<!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
       	<% if ( request.getAttribute( "title" ) != null ) { %>  
      		<h2 class="page-heading"><span>Base créer</span></h2>
      		<%=request.getAttribute( "title" )%>
       	<% } %>  
		
		<% if ( request.getAttribute( "Erreur" ) != null ) { %>  
      		<h2 class="page-heading"><span>Erreur</span></h2>
      		<%=request.getAttribute( "Erreur" )%>
       	<% } %>  
        	
		<!-- page content -->
       	<div id="page-content" class="clearfix">
				
			
        	<div class="clearfix"></div>
			<!-- ENDS contact-sidebar -->
			
		</div>	        	
       	<!--  page content-->
       	
       	

       	
	</div>
</div>
<!-- ENDS MAIN -->
		