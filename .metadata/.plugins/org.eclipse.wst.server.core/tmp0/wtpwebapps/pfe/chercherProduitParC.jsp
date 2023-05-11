 <main id="rightCol" style="overflow: auto">
<div class="rechC">
   <div><h2>Recherche de produit:</h2></div>
   <div>
   <form action="valider.do">
    <table border="1">
     <tr>
         <th>check</th>
         <th>Nom</th>
         <th>Prix DH</th>
         <th>Quantite</th>
         <th>Image de Produit</th>
     </tr>
         <c:forEach items= "${model.produit}" var="p">
           <tr> 
             <td><input type="checkbox" id="coding" name="interest" value="${p.getId() }"></td>
             <td><label for="coding">${p.getNom()}</label></td>
             <td>${p.getPrix()}</td>
             <td>${p.getQuantite()}</td>
             <td><img alt="" src="img/${p.getImage()}"  width="100"
            	     height="150"> </td>
             </tr>
         </c:forEach>
    </table>
    <input type="submit" value="Valider"/>
    </form>
   </div>
 </div>
 </main>