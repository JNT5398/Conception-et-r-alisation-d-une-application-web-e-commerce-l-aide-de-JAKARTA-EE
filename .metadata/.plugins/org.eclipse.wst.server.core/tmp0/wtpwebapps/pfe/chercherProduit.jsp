 <main id="rightCol" style="overflow: auto">
<div class="rechC">
   <div><h2>Recherche de produit:</h2></div>
   <div>
    <form action="chercherP.do" method="get">
      <label>Mot cle:</label>
      <input type= "text" name = "motCle" value="${model.motCle}"/>
      <button type = "submit">Chercher</button>
    </form>
    <table border="1">
     <tr>
         <th>ID</th>
         <th>Nom</th>
         <th>Prix DH</th>
         <th>Quantite</th>
         <th>Image de Produit</th>
         <th>ID Fornisseur</th>
         <th>ID Categorie</th>
     </tr>
         <c:forEach items= "${model.produit}" var="p">
           <tr> 
             <td>${p.getId()}</td>
             <td>${p.getNom()}</td>
             <td>${p.getPrix()}</td>
             <td>${p.getQuantite()}</td>
             <td><img alt="" src="img/${p.getImage()}"  width="100"
            	     height="150"> </td>
             <td>${p.getId_Fornisseur()}</td>
             <td>${p.getId_Categorie()}</td>
          
             <td><a onclick="return confirm('Etes vous sure?')" href= "SupprimerP.do?id=${p.getId()}">Supprimer</a></td>
             <td><a href= "EditP.do?id=${p.getId()}">Edit</a></td> 
             </tr>
         </c:forEach>
    </table>
   </div>
 </div>
 </main>