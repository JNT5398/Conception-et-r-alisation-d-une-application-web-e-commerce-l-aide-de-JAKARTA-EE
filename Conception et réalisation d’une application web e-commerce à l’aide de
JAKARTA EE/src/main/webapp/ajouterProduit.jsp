 <main id="rightCol" style="overflow: auto">
<div class="rechC">
  <form method="post" action="SaveProduit.do">
		<p>
			<label for="Nom_Produit">Nom : <span>*</span></label> 
			<input type="text" name="Nom_Produit" id="Nom_Produit" value="" required="required"/>
		</p>
		<p>
			<label for="Prix_Produit">Prix : <span>*</span></label> 
			<input type="number" name="Prix_Produit" id="Prix_Produit" value="" required="required"/>
		</p>
		<p>
			<label for="Quantite_Produit">Quantite : <span>*</span></label>
			 <input type="number" name="Quantite_Produit" id="Quantite_Produit" value="" required="required"/>
		</p>
		<p>
			<label for="Image_Produit">Image de produit : <span>*</span></label>
			 <input type="file" name="Image_Produit" id="Image_Produit" value="" required="required"/>
		</p>
		<p>
			<label for="Id_Categorie">Id Categorie : <span>*</span></label>
			 <input type="number" name="Id_Categorie" id="Id_Categorie" value="" required="required"/>
		</p>
		<p>
			<label for="Id_Fornisseur">Id Fornisseur: <span>*</span></label>
			 <input type="number" name="Id_Fornisseur" id="Id_Fornisseur" value="" required="required"/>
		</p>

		<input type="submit" value="Envoyer"/>
		 <p class="p"> </p>
		<span>*</span> : Les champs indiqués par une <span>*</span> sont obligatoires .
  		<p class="p"> </p>
		
	</form>
 </div>
 </main>