<html class="no-js">
	<head>
		<meta charset="utf-8"/>
		<title>Adopte un Chef</title>
		
		
		<%session.getAttribute("user"); %>
		
		
		<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/res/styles/default/style.css"/>
		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link rel="stylesheet" media="all" href="<%= request.getContextPath() %>/res/styles/default/style.css"/>
		<meta name="viewport" content="width=device-width, initial-scale=1"/>
		<!-- Adding "maximum-scale=1" fixes the Mobile Safari auto-zoom bug: http://filamentgroup.com/examples/iosScaleBug/ -->
		
		
		<!-- JS -->
		<script src="<%= request.getContextPath() %>/res/js/jquery-1.6.4.min.js"></script>
		<script src="<%= request.getContextPath() %>/res/js/css3-mediaqueries.js"></script>
		<script src="<%= request.getContextPath() %>/res/js/custom.js"></script>
		<script src="<%= request.getContextPath() %>/res/js/tabs.js"></script>
		
		<!-- Tweet -->
		<link rel="stylesheet" href="<%= request.getContextPath() %>/res/styles/default/jquery.tweet.css" media="all"  /> 
		<script src="<%= request.getContextPath() %>/res/js/tweet/jquery.tweet.js" ></script> 
		<!-- ENDS Tweet -->
		
		<!-- superfish -->
		<link rel="stylesheet" media="screen" href="<%= request.getContextPath() %>/res/styles/default/superfish.css" /> 
		<script  src="<%= request.getContextPath() %>/res/js/superfish-1.4.8/js/hoverIntent.js"></script>
		<script  src="<%= request.getContextPath() %>/res/js/superfish-1.4.8/js/superfish.js"></script>
		<script  src="<%= request.getContextPath() %>/res/js/superfish-1.4.8/js/supersubs.js"></script>
		<!-- ENDS superfish -->
		
		<!-- prettyPhoto -->
		<script  src="<%= request.getContextPath() %>/res/js/prettyPhoto/js/jquery.prettyPhoto.js"></script>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/res/js/prettyPhoto/css/prettyPhoto.css"  media="screen" />
		<!-- ENDS prettyPhoto -->
		
		<!-- poshytip -->
		<link rel="stylesheet" href="<%= request.getContextPath() %>/res/js/poshytip-1.1/src/tip-twitter/tip-twitter.css"  />
		<link rel="stylesheet" href="<%= request.getContextPath() %>/res/js/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css"  />
		<script  src="<%= request.getContextPath() %>/res/js/poshytip-1.1/src/jquery.poshytip.min.js"></script>
		<!-- ENDS poshytip -->
		
		<!-- GOOGLE FONTS -->
		<link href='http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz:400,300' rel='stylesheet' type='text/css'>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
		
		<!-- Flex Slider -->
		<link rel="stylesheet" href="<%= request.getContextPath() %>/res/styles/default/flexslider.css" >
		<script src="<%= request.getContextPath() %>/res/js/jquery.flexslider-min.js"></script>
		<!-- ENDS Flex Slider -->
		
		<!-- Less framework -->
		<link rel="stylesheet" media="all" href="<%= request.getContextPath() %>/res/styles/default/lessframework.css"/>
		
		<!-- modernizr -->
		<script src="<%= request.getContextPath() %>/res/js/modernizr.js"></script>
		
		<!-- SKIN -->
		<link rel="stylesheet" media="all" href="<%= request.getContextPath() %>/res/styles/default/skin.css"/>
	
		<link rel="stylesheet" href="<%= request.getContextPath() %>/res/styles/default/global.css" >
		
		<script  src="<%= request.getContextPath() %>/res/js/js_pack.js"></script>
	</head>

	<body lang="fr">
		<header class="clearfix">
		<!-- top widget -->
			<div id="top-widget-holder">
				<div class="wrapper">
					<div id="top-widget">
						<div class="padding">
							<ul  class="widget-cols clearfix">
								<li class="first-col">
									<div class="widget-block">
			                         	<img src="<%= request.getContextPath() %>/res/styles/default/img/heart/O1.jpg" />
									</div>
								</li>
								
								<li class="second-col">
									<div class="widget-block"></div>
								</li>
									
								<li class="third-col">
									<div class="widget-block"></div>
								</li>
									
								<li class="fourth-col">
									<div class="widget-block"></div>
								</li>	
							</ul>				
						</div>
					</div>
				</div>
				<a href="#" id="top-open">Menu</a>
			</div>
			<!-- ENDS top-widget -->
		
			<div class="wrapper clearfix">
				<a href="<%= request.getContextPath() %>" id="logo"><img src="<%= request.getContextPath() %>/res/styles/default/img/logo_auc.png" alt="Zeni"></a>	
				<nav>
					<ul id="nav" class="sf-menu">
						<li class="current-menu-item"><a href="<%= request.getContextPath() %>">ACCUEIL</a></li>
						<%if (session.getAttribute("user") != null)	 { %>
							<li><a href="<%= request.getContextPath() %>/user/profil?user=<% out.println(session.getAttribute("idUser"));%>">VOTRE PROFIL</a></li>
						<%} %>
						<li><a href="<%= request.getContextPath() %>/base/voirBase">VOIR VOS BASES</a></li>
						<li><a href="<%= request.getContextPath() %>/base/modifierBase">MODIFIER VOS BASE</a>
							<ul>
								<li><a href="<%= request.getContextPath() %>/base/creerBase">CREER VOTRE BASE</a></li>
								<li><a href="<%= request.getContextPath() %>/base/ajouterTable">AJOUTER UNE TABLE</a></li>
								<li><a href="<%= request.getContextPath() %>/base/ajouterChamps">AJOUTER DES CHAMPS</a></li>
							</ul>
						</li>
						<li><a href="<%= request.getContextPath() %>/base/saisieXPATH">XPATH</a></li>
						<li><a href="">CONVERTION DES BASES</a>
							<ul>
								<li><a href="">CONVERTIR BASE EN XML</a></li>
								<li><a href="">CONVERTIR XML EN TXT</a></li>
							</ul>
						</li>
						
		                <%if (session.getAttribute("user")!=null) {%>
		               	<li ><a href="<%= request.getContextPath() %>/user/deconnection" class="hover_pink">DECONNEXION </a> <!-- redirection vers page inscription --></li>
		                <%} %>
					</ul>
					<div id="combo-holder"></div>
				</nav>
			</div>
		</header>
	  
		<div id="context">
			<% 
			 out.flush();
			 String url = request
					 .getRequestURI()
					 .substring(request.getContextPath().length()+1);
			 
			 if( url.isEmpty() ) {
				url = "index";
			 }
			 
			 request.getRequestDispatcher("/WEB-INF/views/"+url+".jsp")
			 .include(request, response);
			
			 
			%>
		</div>
	  
	  	<footer>
			<div class="wrapper">
			
				<ul  class="widget-cols clearfix">
					<li class="first-col">
						
						<div class="widget-block">
							<h4>NOS PACKS</h4>
							<ul>
                                <li><a href="<%= request.getContextPath() %>/pack/packNoTime">NO TIME</a></li>
                                <li><a href="<%= request.getContextPath() %>/pack/packJunior">JUNIOR</a></li>
                                <li><a href="<%= request.getContextPath() %>/pack/packExpert">EXPERT</a></li>
                                
                            </ul>
                            <br>
                            <h4>NOS PACKS CLASSIQUE</h4>
							<ul>
                                 <li><a href="<%= request.getContextPath() %>/pack/packAmoureux">DINER EN AMOUREUX</a></li>
                                 <li><a href="<%= request.getContextPath() %>/pack/packNoel">NOEL PRESTIGE</a></li>
                                 <li><a href="<%= request.getContextPath() %>/pack/packAnniversaire">ANNIVESAIRE</a></li>
                                 
                             </ul>
						</div>
					</li>
					
					<li class="second-col">
						<div class="widget-block">
							<h4>MENU</h4>
                             <ul>
                                 <li><a href="<%= request.getContextPath() %>">ACCUEIL</a></li>
                                 <li><a href="<%= request.getContextPath() %>/user/listeChef">NOS CHEFS</a></li>
                                 <li><a href="">PLUS ENCORE</a></li>
                                 <li><a href="<%= request.getContextPath() %>/about/about">ABOUT</a></li>
                                 <li><a href="<%= request.getContextPath() %>/about/contact">CONTACT</a></li>
                             </ul>
						</div>
					</li>
					
					<li class="third-col">
						<div class="widget-block">
	         				<h4>AUTRES</h4>
                            <ul>
                      			<li><a href="<%= request.getContextPath() %>/about/faq">FAQ</a></li>
                                <li><a href="<%= request.getContextPath() %>/user/devenirChef">DEVENIR CHEF</a></li>
                                <li><a href="<%= request.getContextPath() %>/user/devenirClient">DEVENIR CLIENT</a></li>
                                <li><a href="<%= request.getContextPath() %>/about/mentionsLegales">MENTION LEGALE</a></li>
                                <li><a href="<%= request.getContextPath() %>/about/planSite">PLAN DU SITE</a></li>
                            </ul>
		         		</div>
		         	</li>
		         		
					<li class="fourth-col">
						<div class="widget-block">
							<h4>RECETTES</h4>
                            <ul>
                                <li><a href="">PLATS DU MONDE</a></li>
                                <li><a href="">PLAT DE NOS REGIONS</a></li>
                                <li><a href="page.html">DESSERTS</a></li>
                                <li><a href="page.html">CUISINE FACILE</a></li>
                                <li></li>
                            </ul>
                   		</div>
					</li>	
				</ul>				
				
				
				<div class="footer-bottom">
					<div class="left">Design by <a href="#" > adopteunchef.com</a></div>
					<div class="right">
						<ul id="social-bar">
							<li><a href=""  title="Become a fan" class="poshytip"><img src="<%= request.getContextPath() %>/res/styles/default/img/social/facebook.png"  alt="Facebook" /></a></li>
							<li><a href="" title="Follow my tweets" class="poshytip"><img src="<%= request.getContextPath() %>/res/styles/default/img/social/twitter.png"  alt="twitter" /></a></li>
							<li><a href=""  title="Add to the circle" class="poshytip"><img src="<%= request.getContextPath() %>/res/styles/default/img/social/plus.png" alt="Google plus" /></a></li>
						</ul>
					</div>
				</div>
				
			</div>
		</footer>
						
	</body>
	
</html>