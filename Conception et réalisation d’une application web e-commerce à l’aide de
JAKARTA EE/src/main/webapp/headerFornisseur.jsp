 <main id="rightCol" style="overflow: auto">
 <div class="rechC">
   <div><h2>Recherche les produit de fornisseur:</h2></div>
   <div>
    <form action="chercherF.do" method="get">
      <label>Mot cle:</label>
      <input type= "text" name = "motCle" value="${model.motCle}"/>
      <button type = "submit">Chercher</button>
    </form>
    <table border="1">
     <tr>
         <th>ID</th>
         <th>Nom</th>
         <th>Tele</th>
         <th>Adresse</th>
     </tr>
         <c:forEach items= "${model.fornisseur}" var="f">
           <tr> 
             <td>${f.getId_Fornisseur()}</td>
             <td>${f.getNom_Fornisseur()}</td>
             <td>${f.getTele_Fornisseur()}</td>
             <td>${f.getAdresse_Fornisseur()}</td>
          
             <td><a onclick="return confirm('Etes vous sure?')" href= "SupprimerF.do?id=${f.getId_Fornisseur()}">Supprimer</a></td>
             <td><a href= "EditF.do?id=${f.getId_Fornisseur()}">Edit</a></td> 
             </tr>
         </c:forEach>
          </table>
          <div>
         <table border="1">
     <tr>
         <th>ID de Produit</th>
         <th>Nom</th>
         <th>Prix</th>
         <th>Quantite</th>
         <th>Image de Produit</th>
         <th>ID Categorie</th>
     </tr>
         <c:forEach items= "${model1.produit}" var="p">
           <tr> 
             <td>${p.getId()}</td>
             <td>${p.getNom()}</td>
             <td>${p.getPrix()}</td>
             <td>${p.getQuantite()}</td>
             <td><img alt="" src="img/${p.getImage()}"  width="auto"
            	     height="100 px"> </td>
             <td>${p.getId_Categorie()}</td>
          
             <td><a onclick="return confirm('Etes vous sure?')" href= "SupprimerPf.do?id=${p.getId()}">Supprimer</a></td>
             <td><a href= "EditP.do?id=${p.getId()}">Edit</a></td> 
             </tr>
         </c:forEach>
    </table>
   </div>
   </div>
   </div>
 </main>