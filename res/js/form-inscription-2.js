jQuery(document).ready(function($){

	// hide messages 
	$("#error2").hide();
	$("#sent-form-msg").hide();
	
	// on submit...
	$("#form2 #submit2").click(function() {
        $("#error2").hide();
        
                //genre
                var genre = $("input[type=radio][name=genre]:checked").attr('value');
                if(genre == ""){
                        $("#error2").fadeIn().text("Choisir une civilit&eacute;.");
			$("input[type=radio][name=genre]").focus();
			return false;
                }
                
		//nom
		var nom = $("input#nom-chef").val();
		if(nom == ""){
			$("#error2").fadeIn().text("Name required.");
			$("input#nom-chef").focus();
			return false;
		}
                
                //prenom
		var prenom = $("input#prenom-chef").val();
		if(prenom == ""){
			$("#error2").fadeIn().text("Firstname required.");
			$("input#prenom-chef").focus();
			return false;
		}
		
                //adresse
		var adresse = $("input#adresse-chef").val();
		if(adresse == ""){
			$("#error2").fadeIn().text("Address required.");
			$("input#adresse-chef").focus();
			return false;
		}
                
                //code postal
		var code = $("input#code-chef").val();
		if(code == ""){
			$("#error2").fadeIn().text("Code postal required.");
			$("input#code-chef").focus();
			return false;
		}
                
                //ville
		var ville = $("input#ville-chef").val();
		if(ville == ""){
			$("#error2").fadeIn().text("City required.");
			$("input#ville-chef").focus();
			return false;
		}
                
		// email
		var email = $("input#email-chef").val();
		if(email == ""){
			$("#error2").fadeIn().text("Email required");
			$("input#email-chef").focus();
			return false;
		}

                //telephone
		var tel = $("input#tel-chef").val();
		if(tel == ""){
			$("#error2").fadeIn().text("Phone required.");
			$("input#tel-chef").focus();
			return false;
		}
            
	});  
	
    return false;
});

