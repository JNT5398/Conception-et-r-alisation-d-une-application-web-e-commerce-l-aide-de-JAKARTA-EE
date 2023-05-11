 <main id="rightCol" style="overflow: auto">
<div class="rechC">
  <form method="post" action="UpdateFornisseur.do">
		<p>
			<label for="Id_Fornisseur">Id : <span>*</span></label> <input type="text" name="Id_Fornisseur"
				id="Id_Fornisseur" value="${fornisseur.id_Fornisseur}" required="required"/>
		</p>
		<p>
			<label for="Nom_Fornisseur">Nom et Prenom: <span>*</span></label> <input type="text" name="Nom_Fornisseur"
				id="Nom_Fornisseur" value="${fornisseur.nom_Fornisseur}" required="required"/>
		</p>
		<p>
			<label for="NumeroTele_Fornisseur">Numero Tele : </label> <input type="tel"
				name="NumeroTele_Fornisseur" id="NumeroTele_Fornisseur" value="${fornisseur.tele_Fornisseur}" required="required"/>
		</p> 
		<p>
			<label for="Adresse_Fornisseur">Adresse : <span>*</span></label> <input type="text"
				name="Adresse_Fornisseur" id="Adresse_Fornisseur" value="${fornisseur.adresse_Fornisseur}" required="required"/>
		</p> 
		<input type="submit" value="Envoyer"/>
		  <p class="p"> </p>
		<span>*</span> : Les champs indiqués par une <span>*</span> sont obligatoires .
  		<p class="p"> </p>
	</form>
 </div>
 </main>