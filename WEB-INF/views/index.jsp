<%@page import="java.util.List"%>

	<% session.setAttribute("fichier", "C:\\Users\\Valeri\\workspace2\\XMLproject\\fileBIS.xml"); %>
		<!-- MAIN -->
		<div id="main">	
			<div class="wrapper">

				<!-- slider holder -->
				<div id="slider-holder" class="clearfix">
					
					<!-- slider -->
			        <div class="flexslider home-slider">
					  <ul class="slides">
					    <li>
					      <img src="<%= request.getContextPath() %>/res/styles/default/img/slides/01.jpg" alt="alt text" />
					    </li>
					    <li>
					      <img src="<%= request.getContextPath() %>/res/styles/default/img/slides/02.jpg" alt="alt text" />
					      <!-- <p class="flex-caption">Pellentesque habitant morbi  feugiat vitae.</p> -->
					    </li>
					    <li>
					      <img src="<%= request.getContextPath() %>/res/styles/default/img/slides/03.jpg" alt="alt text" />
					    </li>
					  </ul>
					</div>
		        	<!-- ENDS slider -->
		        	
		        	<div class="home-slider-clearfix "></div>
		        	
		        	<%if (session.getAttribute("user") == null){ %>
		        	<!-- Headline -->
		        	<div id="headline">
                    <h2>CONNEXION</h2><br/>
                    <p>
                    	<form action="<%= request.getContextPath() %>/user/connexion" method="POST">
                    		LOGIN<br> 
                    		<input type="text" style="width:80%" name="username"><br/><br/>
                    
                    		PASSWORD<input type="password" style="width:80%" name="password"><br>
                    		<input type="submit" value="Valider">
                    		
                    		Mot de passe oublie ? <a href="#"> Cliquez ici</a>
                    	</form> 
                    </p>
                    <em id="corner"></em><br>
                    <a href="<%= request.getContextPath() %>/user/inscription" class="hover_pink"><h2>INSCRIVEZ VOUS </h2></a> <!-- redirection vers page inscription -->
		        	</div>
		        	<!-- ENDS headline -->
		        	<%}else{%>
		        	<div id="headline"><br></div>
<%-- 		        	<a href="<%= request.getContextPath() %>/user/deconnection" class="hover_pink"><h2>DECONNEXION </h2></a> <!-- redirection vers page inscription --> --%>
		        	<%} %>
		        	
		        	
				</div>
				<!-- ENDS slider holder -->
				
				
				<!-- home-block -->
	        	
	        		        	
			</div>
		</div>
		<!-- ENDS MAIN -->
		
		
		