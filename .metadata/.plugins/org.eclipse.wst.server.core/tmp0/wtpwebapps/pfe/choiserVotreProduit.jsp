<main id="rightCol" style="overflow: auto">

  <h1>Choisser votre Prosuit :</h1>
  <form action="valider.do">
         <table border="1" style="left: 0px">
     <tr>
         <th>check</th>
         <th>Nom</th>
         <th>Prix DH</th>
         <th>Quantite</th>
         <th>Image de Produit</th>
     </tr>
     
         <c:forEach items= "${model.produit}" var="p">
           <tr>
             <td><input type="checkbox" id="coding" name="interest" value="${p.getId()}"></td>
             <td><label for="coding">${p.getNom()}</label></td>
             <td>${p.getPrix()}</td>
             <td>${p.getQuantite()}</td> 
             <td><img alt="" src="img/${p.getImage()}"  width="auto"
            	     height="100 px"> </td>
             </tr>
         </c:forEach>
    </table>
     <input type="submit" value="Valider"/>
    </form>
</main>