<main id="rightCol" style="overflow: auto">
<div>
<h1>Votre produit choisir</h1>
  <form action="Client.do">
         <table border="1">
     <tr>
         <th>ID</th>
         <th>Nom</th>
         <th>Prix</th>
<!--          <th>Quantite</th> -->
         <th>Image de Produit</th>
     </tr>
         <c:forEach items= "${model.getProduit()}" var="pp">
           <tr> 
             <td>${pp.getId()}</td>
             <td>${pp.getNom()}</td>
             <td>${pp.getPrix()}</td>
<%--              <td>${pp.getQuantite()}</td> --%>
             <td><img alt="" src="img/${pp.getImage()}"  width="auto"
            	     height="100 px"> </td>
             </tr>
         </c:forEach>
    </table>
   <c:if test="${ !empty sessionScope.prixTotal}">
   <p>Facture</p>
        <p>prix Total: ${sessionScope.prixTotal } DH </p>
    </c:if>
    <input type="submit" value="Confirmer"/>
    </form>
   </div>
   </main>