<div >
<div align="center">
 <table>
<tr>
   <th><a href="client.do"> Client </a></th>
   
   <th><a href="produit.do"> Produit </a></th>
   
   <th><a href="fornisseur.do"> Fornisseur </a></th>
   
   <th><a href="Deconnection.do"> Deconnection  </a></th>
</tr>  
</table>
</div>
</div>

<c:if test="${ !empty sessionScope.Login}"> <h6 style="margin: 5px">Bienvenue: ${sessionScope.Login } </h6>
    </c:if>