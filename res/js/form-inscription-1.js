jQuery(document).ready(function($){

	// hide messages 
	$("#error1").hide();
	$("#sent-form-msg").hide();
	
	// on submit...
	$("#form1 #submit1").click(function() {
		$("#error1").hide();
		
		//required:
		
                //genre
                var genre = $("input[type=radio][name=genre]:checked").attr('value');
                if(genre == ""){
                        $("#error1").fadeIn().text("Choisir une civilit&eacute;.");
			$("input[type=radio][name=genre]").focus();
			return false;
                }
                
		//nom
		var nom = $("input#nom").val();
		if(nom == ""){
			$("#error1").fadeIn().text("Name required.");
			$("input#nom").focus();
			return false;
		}
                
                //prenom
		var prenom = $("input#prenom").val();
		if(prenom == ""){
			$("#error1").fadeIn().text("Firstname required.");
			$("input#prenom").focus();
			return false;
		}
		
                //adresse
		var adresse = $("input#adresse").val();
		if(adresse == ""){
			$("#error1").fadeIn().text("Address required.");
			$("input#adresse").focus();
			return false;
		}
                
                //code postal
		var code = $("input#code").val();
		if(code == ""){
			$("#error1").fadeIn().text("Code postal required.");
			$("input#code").focus();
			return false;
		}
                
                //ville
		var ville = $("input#ville").val();
		if(ville == ""){
			$("#error1").fadeIn().text("City required.");
			$("input#ville").focus();
			return false;
		}
                
		// email
		var email = $("input#email").val();
		if(email == ""){
			$("#error1").fadeIn().text("Email required");
			$("input#email").focus();
			return false;
		}

                //telephone
		var tel = $("input#tel").val();
		if(tel == ""){
			$("#error1").fadeIn().text("Phone required.");
			$("input#tel").focus();
			return false;
		}
               
        });  
	
    return false;
});

