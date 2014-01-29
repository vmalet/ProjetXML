<%@ page import="java.io.File" %>

<!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
		<h2 class="page-heading"><span><%= request.getAttribute("title") %></span></h2>	
       	
    	<%= request.getAttribute("reussi") %>
		<!-- page content -->
       	<div id="page-content" class="clearfix">
			
			<form action="XMLversTxt" method="POST">
				<%
				String destinationXML = (String) session.getAttribute("destinationXMl");
				
				File repertoire = new File(destinationXML);
				File[] files=repertoire.listFiles();
				%>Choissisez une base a convertir <select id="base" name="base"><%
				for (int i = 0; i < files.length; i++) {
					File file = files[i];
					System.out.println(file.getName());
					%><option value="<%= file.getName() %>"><%= file.getName() %></option><%
				}
				%>
				</select>
				
				<input id="validerConvertionTxt" name="validerConvertionTxt" type="submit" value="Valider">
			</form>
		</div>	        	
       	<!--  page content-->
       	
	</div>
</div>
<!-- ENDS MAIN -->
		