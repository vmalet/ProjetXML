<!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
		<h2 class="page-heading"><span><%= request.getAttribute("title") %></span></h2>	
       	
		<!-- page content -->
       	<div id="page-content" class="clearfix">
			
			<%= request.getAttribute("succes") %>
			
			<div class="clearfix"></div>
			
			<a href="<%= request.getContextPath() %>/base/voirBase">Voir vos bases</a>
			<!-- ENDS contact-sidebar -->
			
		</div>	        	
       	<!--  page content-->
       	
       	

       	
	</div>
</div>
<!-- ENDS MAIN -->
		