<main id="rightCol" style="overflow: auto">
<div class="rechC">
  <form method="post" action="SaveClient.do">
		<p>
			<label for="Nom_Client">Nom : <span>*</span></label> 
			<input type="text" name="Nom_Client" id="Nom_Client" value="" required="required"/>
		</p>
		<p>
			<label for="Prenom_Client">Prénom : <span>*</span></label> 
			<input type="text" name="Prenom_Client" id="Prenom_Client" value="" required="required"/>
		</p>
		<p>
			<label for="Adresse_Client">Adresse : <span>*</span></label>
			 <input type="text" name="Adresse_Client" id="Adresse_Client" value="" required="required"/>
		</p>
		<p>
			<label for="Email_Client">Email : <span>*</span></label> 
			<input type="email" name="Email_Client" id="Email_Client" value="" required="required"/>
		</p>
		<p>
			 <label for="NumeroTele_Client">Numero Tele : </label>
			 <input type="tel" name="NumeroTele_Client" id="NumeroTele_Client" value="" />
		</p>
		<p>
			<label for="PassWord_Client">Mot de passe : <span>*</span></label>
			 <input type="password" name="PassWord_Client" id="PassWord_Client" value="" required="required"/>
		</p>

		<input type="submit" value="Envoyer"/>
		 <p class="p"> </p>
		<span>*</span> : Les champs indiqués par une <span>*</span> sont obligatoires .
  		<p class="p"> </p>
		
	</form>
 </div>
 </main>