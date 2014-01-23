<!-- MAIN -->
<div id="main">	
	<div class="wrapper clearfix">
		
		<h2 class="page-heading"><span>Formulaire de creation de base de donnees</span></h2>	
       	<!-- <span><%= request.getAttribute("title") %></span>-->
		<!-- page content -->
       	<div id="page-content" class="clearfix">
			<form action="<%= request.getContextPath() %>/base/valideBase" method="post">
			
			
			<table align="center" bgcolor="#99FFCC" border="1" width="70%">
			    <tr>
			        <td colspan="2" align="center">Creation de base de donnees </td>
			    </tr>
			    <tr>
			        <td>Nom de la base </td>
			        <td><input type="text" name="nomBase" maxlength="25"></td>
			    </tr>
			    <tr>
			        <td>Nom de la table </td>
			        <td><input type="text" name="nomTable" maxlength="40"></td>
			    </tr>
			    <br>
			    <tr>
			        <td>Nom du champ n1 </td>
			        <td><input type="text" name="champ1" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Valeur du champ n1 </td>
			        <td><input type="text" name="valeur1" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Type du champ n1 </td>
			        <td><select name="typeChamp1">
					     <option value="varchar" selected="selected">Varchar</option>
					     <option value="integer" >integer</option>
					     <option value="boolean">boolean</option>
					     <option value="dateTime">Date Time</option>
					</select></td>
			    </tr> 
			    <div class="clearfix"></div>
			    <tr>
			        <td>Nom du champ n2 </td>
			        <td><input type="text" name="champ2" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Valeur du champ n2 </td>
			        <td><input type="text" name="valeur2" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Type du champ n2 </td>
			        <td><select name="typeChamp2">
					     <option value="varchar" selected="selected">Varchar</option>
					     <option value="integer" >integer</option>
					     <option value="boolean">boolean</option>
					     <option value="dateTime">Date Time</option>
					</select></td>
			    </tr> 
			    <div class="clearfix"></div>
			    <tr>
			        <td>Nom du champ n3 </td>
			        <td><input type="text" name="champ3" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Valeur du champ n3 </td>
			        <td><input type="text" name="valeur3" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Type du champ n3 </td>
			        <td><select name="typeChamp3">
					     <option value="varchar" selected="selected">Varchar</option>
					     <option value="integer" >integer</option>
					     <option value="boolean">boolean</option>
					     <option value="dateTime">Date Time</option>
					</select></td>
			    </tr> 
			    <tr>
			        <td>Nom de la table n2</td>
			        <td><input type="text" name="nomTable2" maxlength="40"></td>
			    </tr>
			    <br>
			    <tr>
			        <td>Nom du champ n1 </td>
			        <td><input type="text" name="champ4" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Valeur du champ n1 </td>
			        <td><input type="text" name="valeur4" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Type du champ n1 </td>
			        <td><select name="typeChamp4">
					     <option value="varchar" selected="selected">Varchar</option>
					     <option value="integer" >integer</option>
					     <option value="boolean">boolean</option>
					     <option value="dateTime">Date Time</option>
					</select></td>
			    </tr> 
			    <div class="clearfix"></div>
			    <tr>
			        <td>Nom du champ n2 </td>
			        <td><input type="text" name="champ5" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Valeur du champ n5 </td>
			        <td><input type="text" name="valeur5" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Type du champ n2 </td>
			        <td><select name="typeChamp5">
					     <option value="varchar" selected="selected">Varchar</option>
					     <option value="integer" >integer</option>
					     <option value="boolean">boolean</option>
					     <option value="dateTime">Date Time</option>
					</select></td>
			    </tr> 
			    <div class="clearfix"></div>
			    <tr>
			        <td>Nom du champ n3 </td>
			        <td><input type="text" name="champ6" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Valeur du champ n6 </td>
			        <td><input type="text" name="valeur6" maxlength="10"></td>
			    </tr>
			    <tr>
			        <td>Type du champ n3 </td>
			        <td><select name="typeChamp6">
					     <option value="varchar" selected="selected">Varchar</option>
					     <option value="integer" >integer</option>
					     <option value="boolean">boolean</option>
					     <option value="dateTime">Date Time</option>
					</select></td>
			    </tr> 
			    <tr>
			        <td colspan="2" align="center"><input type="submit" value="Creer"></td>
			    </tr> 
			</table>
			
			</form>
        	<div class="clearfix"></div>
			<!-- ENDS contact-sidebar -->
			
		</div>	        	
       	<!--  page content-->

	</div>
</div>
<!-- ENDS MAIN -->
		